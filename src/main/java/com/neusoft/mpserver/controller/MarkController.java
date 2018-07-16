package com.neusoft.mpserver.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.neusoft.mpserver.domain.Constant;
import com.neusoft.mpserver.domain.Mark;
import com.neusoft.mpserver.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  标引模块
 * @name fandp
 * @email fandp@neusoft.com
 */
@RestController
@RequestMapping("/mark")
@CrossOrigin
public class MarkController {
    @Autowired
    private MarkService markService;

    //保存标引词
    @PostMapping("/add")
    public  boolean addMark(@RequestBody Map postMap, HttpServletRequest request){
        Gson gson = new Gson();
        String markStr = (String) postMap.get("markList");
        ArrayList<Mark> markList = gson.fromJson(markStr, new TypeToken<List<Mark>>(){}.getType());
        String userId = (String) request.getAttribute(Constant.USER_ID);
        return markService.addMark(userId,markList);
    }

    //删除标引词
    @PostMapping("/delete")
    public boolean  deleteMark(@RequestBody Map postMap,HttpServletRequest request){
        String markId = (String) postMap.get("markId");
        String userId = (String) request.getAttribute(Constant.USER_ID);
          return markService.deleteMark(markId,userId);
    }

    //查询显示标引词
    @GetMapping("/list/{an}")
     public Map<String, List<Mark>> markList (@PathVariable String an){
        Map<String, List<Mark>> result = new HashMap<String, List<Mark>>();
        result.put("markList", markService.showMarkList(an));
          return result;
     }

}
