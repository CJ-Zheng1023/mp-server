package com.neusoft.mpserver.service;

import com.neusoft.mpserver.domain.Mark;

import java.util.List;

/**
 * 标引词模块：service层接口
 *
 * @name fandp
 * @email fandp@neusoft.com
 */
public interface MarkService {
    //保存标引词
    public boolean addMark(String userId, List<Mark> markList);

    //删除标引词
    public boolean deleteMark(String markId, String userId);

    //查询标引词
    public List<Mark> showMarkList(String an);
}
