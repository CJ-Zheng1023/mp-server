package com.neusoft.mpserver.service;

import com.eprobiti.trs.TRSException;
import com.neusoft.mpserver.common.domain.Pagination;
import com.neusoft.mpserver.domain.Patent;

import java.util.List;
import java.util.Map;

public interface SearchService {
    //查询案卷列表
    public Map<String,Object> searchPatentList(String ipc, Pagination pagination);

}
