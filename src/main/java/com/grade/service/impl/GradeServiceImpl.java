package com.grade.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grade.entity.Grade;
import com.grade.mapper.GradeMapper;
import com.grade.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 王建兵
 * @Classname GradeServiceImpl
 * @Description TODO
 * @Date 2019/6/10 11:39
 * @Created by Administrator
 */

//@Service(value = "gradeService")  //value指定的是bean对象的id值
    @Service  //默认是类名首字母小写
@Transactional  //实现事务支持
public class GradeServiceImpl implements GradeService {
    //业务调用dao层
    //声明Dao层接口
    @Autowired  //默认按类型自动注入
    private GradeMapper gradeMapper;


    @Override
    public List<Grade> getAllGrade() {
        return gradeMapper.getAllGrade();
    }

    @Override
    @Transactional(propagation =Propagation.NOT_SUPPORTED )  //不基于事务执行
    public PageInfo<Grade> getGradeByPage(int page, int pageSize) {
        //开启分页支持
        PageHelper.startPage(page,pageSize);
        //调用dao层查询所有
        List<Grade>  list=gradeMapper.getAllGrade();  //修改sql
        //获取分页的相关信息
        PageInfo pageInfo=new PageInfo(list);
       /* System.out.println("获取当页页:"+pageInfo.getPageNum());
        System.out.println("获取总页数"+pageInfo.getPages());
        System.out.println("每页条数:"+pageInfo.getPageSize());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("获取第一页"+pageInfo.getNavigateFirstPage());
        System.out.println("获取最后一页:"+pageInfo.getNavigateLastPage());
        System.out.println("上一页"+pageInfo.getPrePage());
        System.out.println("下一页:"+pageInfo.getNextPage());
        System.out.println("当前页的数据"+pageInfo.getList().size());*/
        return pageInfo;
    }

    @Override
    public int insert(Grade record) {
        return gradeMapper.insert(record);
    }

    @Override
    public int insertSelective(Grade record) {
        return gradeMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Short gid) {
        return gradeMapper.deleteByPrimaryKey(gid);
    }

    @Override
    public Grade selectByPrimaryKey(Short gid) {
        return gradeMapper.selectByPrimaryKey(gid);
    }

    @Override  //删除多个年级

    public void delMore() {
        //同时删除两个年级
        //  删除16
        gradeMapper.deleteByPrimaryKey(new Short("13"));

         int i=10,j=0;
         i=i/j;   //引发异常

        //  删除17
        gradeMapper.deleteByPrimaryKey(new Short("17"));

    }

    @Override
    public int updateByPrimaryKeySelective(Grade record) {
        return gradeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Grade record) {
        return gradeMapper.updateByPrimaryKey(record);
    }

}
