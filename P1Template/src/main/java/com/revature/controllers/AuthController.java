package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.AuthService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.javalin.http.Handler;

public class AuthController {
	
	public static Logger log = LogManager.getLogger();
	
	AuthService as = new AuthService();
	
	public static HttpSession sessManager;
	
	public static HttpSession sessEmp;
	
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		
		User user = as.login(lDTO.getUsername(), lDTO.getPassword());
		
		if(user!= null) {
		if(user.getRole_id_fk() == 1 || user.getRole_id_fk() == 2) {
			
			log.info("Manager logged in");
			
			sessManager = ctx.req.getSession();
			
			String userJSON = gson.toJson(user);
			
			ctx.result(userJSON);
			ctx.status(202);
			
		}else if(user.getRole_id_fk() == 3 || user.getRole_id_fk() == 4){
			
			log.info("Employee Logged in");
			
			sessEmp = ctx.req.getSession();
			String empJSON = gson.toJson(user);
			
			ctx.result(empJSON);
			ctx.status(202);
		}else {
			log.warn("User failed to log in");
			ctx.status(401);
		}
		}
		
	};

}
