package com.neusoft.mpserver.controller;

import com.neusoft.mpserver.common.domain.Pagination;
import com.neusoft.mpserver.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 查询ic下案卷模块
 *
 * @name fandp
 * @email fandp@neusoft.com
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    //查询案卷列表
    @PostMapping("/patent/list")
    public Map<String, Object> searchPatentList(String ipc, Pagination pagination, String token) {
        Map<String, Object> patentMap = searchService.searchPatentList(ipc, pagination);
        return patentMap;
    }

    //查询中英文解释
    @PostMapping("/ipc")
    public Map<String, String> searchIpc(String ipc, String token) {
        Map<String, String> ipcResult = searchService.searchIpc(ipc);
        return ipcResult;
    }


}
