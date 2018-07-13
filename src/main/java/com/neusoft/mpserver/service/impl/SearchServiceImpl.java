package com.neusoft.mpserver.service.impl;

import com.neusoft.mpserver.common.domain.Condition;
import com.neusoft.mpserver.common.domain.Pagination;
import com.neusoft.mpserver.common.domain.Record;
import com.neusoft.mpserver.common.domain.TrsResult;
import com.neusoft.mpserver.common.engine.TrsEngine;
import com.neusoft.mpserver.domain.Constant;
import com.neusoft.mpserver.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ic业务查询模块：service层实现
 *
 * @name fandp
 * @email fandp@neusoft.com
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private TrsEngine trsEngine;

    @Override
    public Map<String, Object> searchPatentList(String ipc, Pagination pagination) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, String>> patentList = new ArrayList<Map<String, String>>();
        Condition condition = new Condition();
        String searchIc = "IC='" + ipc + "'";
        condition.setExp(searchIc);
        condition.setDbName(Constant.CNABS_DB);
        condition.setDisplayFields(Constant.PATENT_LIST_DISPLAY_FIELDS_PATENT);
        condition.setPagination(pagination);
        TrsResult tr = trsEngine.search(condition);
        List<Record> recordList = tr.getRecords();
        for (int i = 0; i < recordList.size(); i++) {
            patentList.add(recordList.get(i).getDataMap());
        }
        map.put("patentList", patentList);
        map.put("pagination", tr.getPagination());
        return map;
    }

    @Override
    public Map<String, Object> searchIpc(String ipc) {
        Map<String,Object> mapChEn =new HashMap<>();
        Condition condition = new Condition();
        String searchIc = "IC='" + ipc + "'";    //?
        condition.setExp(searchIc);
        condition.setDbName(Constant.CNABS_DB);   //?
        condition.setDisplayFields(Constant.PATENT_LIST_DISPLAY_FIELDS_CHEN);  //?
        TrsResult tr=trsEngine.search(condition);
        List<Record> recordList=tr.getRecords();
        List<Map<String,String>>  ipcChEn=new ArrayList<>();
        for (int i = 0; i < recordList.size(); i++) {
            ipcChEn.add(recordList.get(i).getDataMap());
        }
        mapChEn.put("ipcResult",ipcChEn);
        return mapChEn;
    }

    @Override
    public Map<String, Object> searchPatent(String an) {
        Map<String,Object> mapPatent =new HashMap<>();
        Condition condition = new Condition();
        String searchAn = "AN='" + an + "'";      //?
        condition.setExp(searchAn);
        condition.setDbName(Constant.CNABS_DB);    //?
        condition.setDisplayFields(Constant.PATENT_LIST_DISPLAY_FIELDS_DETAIL);
        TrsResult tr=trsEngine.search(condition);
        List<Record> recordList=tr.getRecords();
        List<Map<String,String>>  ipcChEn=new ArrayList<>();
        for (int i = 0; i < recordList.size(); i++) {
            ipcChEn.add(recordList.get(i).getDataMap());
        }
        mapPatent.put("patent",ipcChEn);
        return mapPatent;
    }
}
