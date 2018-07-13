package com.neusoft.mpserver.controller;

import com.neusoft.mpserver.domain.Constant;
import com.neusoft.mpserver.domain.Mark;
import com.neusoft.mpserver.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  标引模块
 * @name fandp
 * @email fandp@neusoft.com
 */
@RestController
@RequestMapping("/mark")
public class MarkController {
    @Autowired
    private MarkService markService;

    //保存标引词
    @PostMapping("/add")
    public  boolean addMark(List<Mark> markList, HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return markService.addMark(userId,markList);
    }

    //删除标引词
    @PostMapping("/delete")
    public boolean  deleteMark(String markId,HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
          return markService.deleteMark(markId,userId);
    }

    //显示标引词
    @GetMapping("/list/{an}")
     public  List<Mark> markList (@PathVariable String an,HttpServletRequest request){
         String userId = (String) request.getAttribute(Constant.USER_ID);
          return markService.showMarkList(userId,an);
     }

}
