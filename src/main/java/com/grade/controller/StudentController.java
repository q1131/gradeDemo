package com.grade.controller;

import com.github.pagehelper.PageInfo;
import com.grade.entity.Grade;
import com.grade.entity.Students;
import com.grade.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname StudentController
 * @Description TODO
 * @Date 2019/6/12 12:00
 * @Created by Administrator
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("showStudent")
    public String showStudent(Integer gid, Model model) throws  Exception{
         //通过年级编号显示学生
         List<Students> list =studentService.getStudentByGid(gid);
         model.addAttribute("list",list);
         return "student";
    }


    //编写处理请求的服务，用于返回学生数据(数据的格式为json)
    @RequestMapping("/getData")
    @ResponseBody
    public Grade getData() throws  Exception{
        //创建实体
        Grade grade=new Grade();
        grade.setGid(new Short("101"));
        grade.setGname("9501");

      return grade;  //表示返回的页面
    }
    //注意:控制器输出到页面的内容就是返回给客户端的内容
    //@ResponseBody注解的作用就是将处理请求的方法返回值输出响应体
    //@ResponseBody在返回数据时，默认支持使用jackson工具包将java对象转化为json对象进行反回


    //返回所有学生的异步数据
    @RequestMapping("/getData2")
    @ResponseBody
    public  List<Students> getData2() throws  Exception{
       List<Students>  list=studentService.getAllStudent();
       return list;
    }


    @RequestMapping("/getData3")
    @ResponseBody
    /**
     * page 表示接收页码
     * rows表示接收页大小
     */
    public  Map<String,Object> getData3(Integer page,Integer rows) throws  Exception{
        //调用业务
       PageInfo<Students> pageInfo=studentService.getAllStudentByPage(page,rows);
       //组装返回的数据
        Map<String,Object> map=new HashMap<>();
        //填充总记录数
        map.put("total",pageInfo.getTotal());
        //填充当前页的记录
        map.put("rows",pageInfo.getList());
       return map;
    }
}
