package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

/**
 * Date:2018/5/26
 * Desc:
 */
public class StudentMapperTest {

    private StudentMapper studentMapper;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        studentMapper = sqlSession.getMapper(StudentMapper.class);

    }

    @Test
    public void queryStudents() {
        List<Student> list = studentMapper.queryStudents();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void queryStudentsByPage() {
        //设置分页,查询第二页,第二条
        PageHelper.startPage(3,2);
        List<Student> list = studentMapper.queryStudents();
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        for (Student user : pageInfo.getList()) {
            System.out.println(user);
        }
        System.out.println(" 总共 " + pageInfo.getTotal() + "  条数据；当前第 " +
                pageInfo.getPageNum()
                + "  页；总共 " + pageInfo.getPages() + "  页；。");
    }
}