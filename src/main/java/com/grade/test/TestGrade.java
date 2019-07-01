package com.grade.test;

import com.grade.service.GradeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 王建兵
 * @Classname TestGrade
 * @Description TODO
 * @Date 2019/6/10 10:44
 * @Created by Administrator
 */
public class TestGrade {
    public static void main(String[] args) {
        //创建spring容器
//        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        GradeMapper gradeMapper=(GradeMapper)ctx.getBean("gradeMapper");
//
//        System.out.println(gradeMapper.getAllGrade().size());
//
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        GradeService gradeService=(GradeService)ctx.getBean("gradeServiceImpl");

        gradeService.delMore();  //同时删除多面
        System.out.println("删除成功");


    }
}
