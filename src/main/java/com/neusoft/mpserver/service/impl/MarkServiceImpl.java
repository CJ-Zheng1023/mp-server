package com.neusoft.mpserver.service.impl;

import com.neusoft.mpserver.common.util.IDGenerator;
import com.neusoft.mpserver.dao.MarkRerpository;
import com.neusoft.mpserver.domain.Mark;
import com.neusoft.mpserver.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 标引词模块：service层实现
 * 只有在这一层加事务管理才是真正的事务管理
 *
 * @name fandp
 * @email fandp@neusoft.com
 */
@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkRerpository markRerpository;

    //保存标引词方法
    @Override
    @Transactional
    public boolean addMark(String userId, List<Mark> markList) {
        List<Mark> markListResult = markList;
        for (int i = 0; i < markListResult.size(); i++) {
            markListResult.get(i).setUserId(userId);
            markListResult.get(i).setId(IDGenerator.generate());
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            markListResult.get(i).setCreateTime(df.format(day));
        }
        if (markRerpository.saveAll(markListResult).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    //删除标引词方法
    @Transactional
    @Override
    public boolean deleteMark(String markId, String userId) {
        if(markRerpository.deleteMarkByIdAndUserId(markId, userId)==true){
            return true;
        }else{
            return false;
        }
    }

    //查询标引词
    @Transactional
    @Override
    public List<Mark> showMarkList(String an) {
        List<Mark> markList = markRerpository.findByAn(an);
        return markList;
    }


}
