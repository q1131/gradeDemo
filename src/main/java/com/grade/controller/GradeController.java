package com.grade.controller;

import com.github.pagehelper.PageInfo;
import com.grade.entity.Grade;
import com.grade.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 王建兵
 * @Classname GradeController
 * @Description TODO
 * @Date 2019/6/10 11:55
 * @Created by Administrator
 */
@Controller
public class GradeController {

    @Autowired
    private GradeService gradeService;

    //一请求一方法
    @RequestMapping("/showGrade")
    public String showGrade(Model model) throws  Exception{
       //调用业务
       List<Grade> list=gradeService.getAllGrade();
        System.out.println("list = " + list);
       model.addAttribute("list",list);
       return "index";
    }

    @RequestMapping("/showGrade2")
    /**
     * page 接收页码
     */
    public String showGrade2(Integer page,Model model) throws  Exception{
        //调用分页的业务
        //判断没有传页码时
        page=page==null?1:page;

        PageInfo<Grade> pageInfo=gradeService.getGradeByPage(page,4);
        model.addAttribute("pageInfo",pageInfo);
        return "index2";
    }

    @RequestMapping("/addGrade")
    public String addGrade(Grade grade) throws  Exception{
        //调用业务
        int temp=gradeService.insertSelective(grade);
        if(temp<0)
            return "error";
        else
            return "redirect:showGrade";
    }

    @RequestMapping("/delGrade")
    public String delGrade(Short gid) throws  Exception{
        //调用业务
        int temp=gradeService.deleteByPrimaryKey(gid);
        if(temp<0)
            return "error";
        else
            return "redirect:showGrade";
    }

    @RequestMapping("/getGrade")
    public String getGrade(Short gid,Model model) throws  Exception{
        //调用业务
       Grade grade=gradeService.selectByPrimaryKey(gid);
       //将控制器的数据传递到视图
        model.addAttribute("grade",grade);
       return "update";
    }

    @RequestMapping("/updateGrade")
    public String getGrade(Grade grade,Model model) throws  Exception{
       // update grade set gname=? where gid=?
        //调用业务
        int temp=gradeService.updateByPrimaryKeySelective(grade);

        if(temp<0)
            return "error";
        else
            return "redirect:showGrade";
    }

}
