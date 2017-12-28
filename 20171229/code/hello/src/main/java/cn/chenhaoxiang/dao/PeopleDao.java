package cn.chenhaoxiang.dao;

import cn.chenhaoxiang.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/12/28.
 * Time: 下午 10:44.
 * Explain:
 */
public interface PeopleDao extends JpaRepository<People,Integer>{//实体类，id的类型

}
