package com.grade.mapper;

import com.grade.entity.Students;
import com.grade.entity.StudentsExample;
import java.util.List;

public interface StudentsMapper {
    int deleteByPrimaryKey(Integer xh);

    int insert(Students record);

    int insertSelective(Students record);

    List<Students> selectByExample(StudentsExample example);

    Students selectByPrimaryKey(Integer xh);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    //查询某年级下的学生
    List<Students> getStudentByGid(Integer gid);

    //查询所有的学生
    List<Students> getAllStudent();
}