package com.neusoft.mpserver.service.impl;

import com.neusoft.mpserver.common.util.IDGenerator;
import com.neusoft.mpserver.dao.MarkRerpository;
import com.neusoft.mpserver.domain.Mark;
import com.neusoft.mpserver.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 标引词模块：service层实现
 *
 * @name fandp
 * @email fandp@neusoft.com
 */
@Service
public class MarkServiceImpl implements MarkService{
    @Autowired
    private MarkRerpository markRerpository;
    //保存标引词方法
    @Override
    public boolean addMark(String userid,List<Mark> markList) {
        List<Mark> markListResult=markList;
        for(int i=0;i<markListResult.size();i++){
            markListResult.get(i).setUserId(userid);
            markListResult.get(i).setId(IDGenerator.generate());
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            markListResult.get(i).setCreateTime(df.format(day));
        }
       if(markRerpository.saveAll(markListResult)==null){
            return false;
        }else{
            return true;
        }
    }
    //删除标引词方法
    @Override
    public boolean deleteMark(String markId) {
        markRerpository.deleteById(markId);
        return true;
    }

    //查询标引词
    @Override
    public List<Mark> showMarkList(String userid,String an){
        List<Mark> markList= markRerpository.findByUserIdAndAn(userid,an);
        return markList;
    }





}
