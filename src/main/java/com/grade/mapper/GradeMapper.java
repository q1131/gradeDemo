package com.grade.mapper;

import com.grade.entity.Grade;
import com.grade.entity.GradeExample;
import java.util.List;

public interface GradeMapper {
    int deleteByPrimaryKey(Short gid);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade>  getAllGrade();
    List<Grade> selectByExample(GradeExample example);

    Grade selectByPrimaryKey(Short gid);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

}