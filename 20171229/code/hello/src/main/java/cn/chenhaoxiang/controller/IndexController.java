package cn.chenhaoxiang.controller;

import cn.chenhaoxiang.dao.PeopleDao;
import cn.chenhaoxiang.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/12/28.
 * Time: 下午 9:20.
 * Explain:
 */
@RestController
public class IndexController {

    @Autowired
    private PeopleDao peopleDao;//因为逻辑相对简单，直接在Controller调用dao了，实际开发中请勿这样

    /**
     * 获取所有的人的数据
     * @return
     */
    @GetMapping(value = "peoples")
    public List<People> getPeople(){
        return peopleDao.findAll();//一句SQL都没写，很方便
    }

    @GetMapping
    public String peopleAdd(){

    }

}
