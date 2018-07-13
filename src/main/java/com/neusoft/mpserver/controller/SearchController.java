package com.neusoft.mpserver.controller;

import com.neusoft.mpserver.common.domain.Pagination;
import com.neusoft.mpserver.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/patent/list/{ipc}")
    public Map<String, Object> searchPatentList(@PathVariable String ipc, Pagination pagination, String token) {
        Map<String, Object> patentMap = searchService.searchPatentList(ipc, pagination);
        return patentMap;
    }

    //查询中英文解释
    @GetMapping("/ipc/{ipc}")
    public Map<String, String> searchIpc(@PathVariable String ipc, String token) {
        Map<String, String> ipcResult = searchService.searchIpc(ipc);
        return ipcResult;
    }


}
