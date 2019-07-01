package com.grade.service;

import com.github.pagehelper.PageInfo;
import com.grade.entity.Students;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

/**
 * @author 王建兵
 * @Classname StudentService
 * @Description TODO
 * @Date 2019/6/12 11:58
 * @Created by Administrator
 */
public interface StudentService {
    List<Students> getStudentByGid(Integer gid);

    //查询所有的学生
    List<Students> getAllStudent();

    //查询所有的学生
    PageInfo<Students> getAllStudentByPage(Integer page, Integer rows);
}
