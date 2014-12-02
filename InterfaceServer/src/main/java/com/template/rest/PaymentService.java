package com.template.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
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
//		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("my_key", "value");
//		result=jsonObj.toJSONString();
		return Response.status(200).entity(result+"---------"+queryUserById.getUsername()).build();
	}
	@GET
	@Path("/getJsonTest")
	@Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
	public Response getJsonTest() {
		String result="";
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("my_key", "value");
		jsonObj.put("my_key2", "测试中文");
		result=jsonObj.toJSONString();
		Response response = Response.status(200).entity(result).build();
		return response;
	}
 
}