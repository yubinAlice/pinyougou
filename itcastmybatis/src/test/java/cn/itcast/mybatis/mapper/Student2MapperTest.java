package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Student2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.InputStream;
import java.util.Date;

/**
 * Date:2018/5/26
 * Desc:
 */
public class Student2MapperTest {

    private Student2Mapper student2Mapper;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MapperHelper mapperHelper = new MapperHelper();
        //特殊配置
        Config config = new Config();
        mapperHelper.setConfig(config);
        //  注册自己项目中使用的通用 Mapper 接口，这里没有默认值，必须手动注册
        mapperHelper.registerMapper(Mapper.class);
        // 配置完成后，执行下面的操作
        mapperHelper.processConfiguration(sqlSession.getConfiguration());
        student2Mapper = sqlSession.getMapper(Student2Mapper.class);
    }
    @Test
    public void insertSelective() {
        Student2 s = new Student2();
        s.setAccount("itcast");
        s.setName(" 传智播客2");
        s.setGender(1);
        s.setCreateTime(new Date());
        student2Mapper.insertSelective(s);
    }
}