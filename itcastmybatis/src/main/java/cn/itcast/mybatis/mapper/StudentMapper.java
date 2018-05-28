package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Student;

import java.util.List;

/**
 * Date:2018/5/25
 * Desc:
 */
public interface StudentMapper  {
    public List<Student> queryStudents();
}
