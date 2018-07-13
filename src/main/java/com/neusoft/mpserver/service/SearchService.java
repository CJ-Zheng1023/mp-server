package com.neusoft.mpserver.service;

import com.neusoft.mpserver.common.domain.Pagination;
import java.util.Map;

/**
 * 根据ic查询案卷相关信息模块：service层接口
 * @name fandp
 * @email fandp@neusoft.com
 */
public interface SearchService {
    //查询案卷列表
    public Map<String,Object> searchPatentList(String ipc, Pagination pagination);

    //查询中英文解释
    public Map<String,Object> searchIpc(String ipc);

    //查询案卷的标题、申请人、发明人、国省代码
    public Map<String,Object> searchPatent(String an);

}
