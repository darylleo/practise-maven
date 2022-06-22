package com.itheima.dao;

import com.itheima.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/9/10
 * @description 标题
 * @package com.itheima.dao
 */
// <User,Integer> User 指定JPA框架将来要操作的那个表 Integer指定主键的数据类型即可



public interface UserDao extends JpaRepository<User,Integer> {

}
