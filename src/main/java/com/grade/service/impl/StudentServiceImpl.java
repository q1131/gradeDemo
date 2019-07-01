package com.grade.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grade.entity.Students;
import com.grade.mapper.StudentsMapper;
import com.grade.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王建兵
 * @Classname StudentServiceImpl
 * @Description TODO
 * @Date 2019/6/12 11:58
 * @Created by Administrator
 */
@Service
public class StudentServiceImpl  implements StudentService {

     @Autowired
     private StudentsMapper studentsMapper;

    @Override
    public List<Students> getStudentByGid(Integer gid) {
        return studentsMapper.getStudentByGid(gid);
    }

    @Override
    public List<Students> getAllStudent() {
        return studentsMapper.getAllStudent();
    }

    @Override
    public PageInfo<Students> getAllStudentByPage(Integer page, Integer rows) {
        //分页
        PageHelper.startPage(page,rows);
        List<Students> list=studentsMapper.getAllStudent();
        PageInfo<Students> pageinfo=new PageInfo(list);
        return pageinfo;
    }
}
