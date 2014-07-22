package com.template.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.template.bean.User;
import com.template.dao.UserDAO;
import com.template.transaction.TransactionBo;
 
@Component
@Path("/payment")
public class PaymentService {
	@Autowired
	UserDAO userDao;
	@Autowired
	TransactionBo transactionBo;
 
	@GET
	@Path("/mkyong")
	public Response savePayment() {
 
		String result = transactionBo.save();
		User queryUserById = userDao.queryUserById(1);
		return Response.status(200).entity(result+"---------"+queryUserById.getUsername()).build();
 
	}
 
}