package com.hfut.edu.databasecoursedesignfoods;

import com.hfut.edu.databasecoursedesignfoods.common.MyEncrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseCourseDesignFoodsApplicationTests {

    @Test
    public void contextLoads() {
        String pwd = "1234asd";
        System.out.println(MyEncrypt.md5(pwd));
    }

}
