package com.neusoft.mpserver.controller;

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
    public  boolean addMark(String token, List<Mark> markList, HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return markService.addMark(userId,markList);
    }

    //删除标引词
    @PostMapping("/delete")
    public boolean  deleteMark(String markId, String token){
          return markService.deleteMark(markId);
    }

    //显示标引词
     @RequestMapping(value="/list/:{token}/:{an}",method = RequestMethod.GET)
     public  List<Mark> markList (String an,String token,HttpServletRequest request){
         String userid=request.getParameter("userId");
        return markService.showMarkList(userid,an);
     }

}
