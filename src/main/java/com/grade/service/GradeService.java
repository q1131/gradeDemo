package com.grade.service;

import com.github.pagehelper.PageInfo;
import com.grade.entity.Grade;

import java.util.List;

/**
 * @author 王建兵
 * @Classname GradeService
 * @Description TODO
 * @Date 2019/6/10 11:38
 * @Created by Administrator
 */
public interface GradeService {
    //查询年级
    List<Grade> getAllGrade();

    //分页查询的方法
    PageInfo<Grade> getGradeByPage(int page, int pageSize);

    int insert(Grade record);

    int insertSelective(Grade record);

    int deleteByPrimaryKey(Short gid);

    Grade selectByPrimaryKey(Short gid);

    void delMore();  //测试

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}

