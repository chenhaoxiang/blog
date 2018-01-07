package cn.chenhaoxiang;

import cn.chenhaoxiang.entity.People;
import cn.chenhaoxiang.service.PeopleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2018/1/7.
 * Time: 下午 3:52.
 * Explain:
 */
@RunWith(SpringRunner.class)//表示在测试环境中跑
@SpringBootTest//表示将启动整个spring 的工程
public class PeopleServiceTest {
    @Autowired
    private PeopleService peopleService;
    @Test
    public void findOneTest(){
        People people = peopleService.findOne(7);
        //使用断言
        Assert.assertEquals(new Integer(20),people.getAge());
    }
}
