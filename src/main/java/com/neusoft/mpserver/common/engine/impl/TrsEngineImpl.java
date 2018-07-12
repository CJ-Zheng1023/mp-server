package com.neusoft.mpserver.common.engine.impl;

import com.eprobiti.trs.TRSConnection;
import com.eprobiti.trs.TRSConstant;
import com.eprobiti.trs.TRSException;
import com.eprobiti.trs.TRSResultSet;
import com.neusoft.mpserver.common.Exception.SystemException;
import com.neusoft.mpserver.common.domain.Condition;
import com.neusoft.mpserver.common.domain.Pagination;
import com.neusoft.mpserver.common.domain.Record;
import com.neusoft.mpserver.common.domain.TrsResult;
import com.neusoft.mpserver.common.engine.TrsEngine;
import com.neusoft.mpserver.domain.Constant;
import com.trs.zl.TRSSearch;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * trs引擎实现
 *
 * @name zhengchj
 * @email zhengchj@neusoft.com
 */
@Component
public class TrsEngineImpl implements TrsEngine {

    @Value("${engine.trs.hostip}")
    private String hostip;
    @Value("${engine.trs.port}")
    private String port;
    @Value("${engine.trs.username}")
    private String username;
    @Value("${engine.trs.password}")
    private String password;
    @Value("${engine.trs.userId}")
    private String userId;

    private TRSConnection createConnection() throws TRSException {
        TRSConnection conn = TRSSearch.getTRSConnection(userId, hostip, port, username, password);
        conn.SetExtendOption("HITPOINTMODE", "1");
        conn.SetExtendOption("RETRYMISCOL", "$ZERO");
        conn.SetExtendOption("SORTMISCOL", "1");
        conn.SetExtendOption("SORTNOCASE", "1");
        conn.setAutoExtend("", "", "", 0);
        return conn;
    }

    private void closeConnection(TRSConnection conn) {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    @Override
    public TrsResult search(Condition condition) {
        TRSConnection conn = null;
        TrsResult rs = new TrsResult();
        try{
            conn = createConnection();
            TRSResultSet result = TRSSearch.executeSelect(conn, condition.getDbName(), condition.getExp(),
                    "", "", "BI", TRSConstant.TCM_IDEOSINGLE | TRSConstant.TCM_LIFOSPARE, TRSConstant.TCE_NOTHIT, false);
            result.setReadOption("READOPTION", null, TRSConstant.TCM_BAN64KFILE);
            result.setCutSize(0, true);
            result.setReadOptions(TRSConstant.TCE_NOTHIT, condition.getDisplayFields(), ",");
            Pagination pagination = condition.getPagination();
            int pageSize = pagination.getSize(), pageStart = pagination.getStart();
            int total = new Long(result.getRecordCount()).intValue();
            if (pageSize == 0) {
                pageSize = total;
            }
            result.setBufferSize(pageSize, pageSize);
            result.setErrorMode(1, "-");
            pagination.setTotal(total);
            rs.setPagination(pagination);
            if (pageStart + pageSize >= total) {
                rs.setLast(true);
            }
            while (result.moveTo(0, pageStart++)) {
                String[] fields = condition.getDisplayFields().split(",");
                if (pageSize-- > 0) {
                    Record record = new Record();
                    for (String f : fields) {
                        String r = result.getString(f);
                        TRSSearch.dealTRSRSString(r);
                        record.getDataMap().put(f, r);
                    }
                    rs.getRecords().add(record);
                }else{
                    break;
                }
            }
        }catch(Exception e){
            throw new SystemException();
        }finally {
            closeConnection(conn);
        }
        return rs;
    }

}
