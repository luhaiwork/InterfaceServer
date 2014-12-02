package com.template.transaction.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.template.bean.User;
import com.template.dao.UserDAO;
import com.template.transaction.TransactionBo;

public class TransactionBoImpl implements TransactionBo{
	@Autowired
	UserDAO userDao;
	public String save() {
		 
		User queryUserById = userDao.queryUserById(1);
		return "save:"+queryUserById.getId();
 
	}
}
