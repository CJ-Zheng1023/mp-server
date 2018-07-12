package com.neusoft.mpserver.controller;

import com.neusoft.mpserver.common.domain.Pagination;
import com.neusoft.mpserver.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *  查询ic下案卷模块
 * @name fandp
 * @email fandp@neusoft.com
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
   private SearchService searchService;

    @PostMapping("/patent/list")
    public Map<String, Object> searchIpc (String ipc, Pagination pagination , String token){
        Map<String, Object> map=searchService.searchPatentList(ipc,pagination);
        return map;
    }

}
