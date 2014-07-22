package com.template.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.template.bean.User;
import com.template.dao.UserDAO;


public class UserDAOImpl extends SqlSessionDaoSupport  implements UserDAO{
	 public User queryUserById(int id) {
	 return
	 (User)this.getSqlSession().selectOne("com.template.usermapper.queryUserByID",
	 id);
	 }
}