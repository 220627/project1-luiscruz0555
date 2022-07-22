package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {
	
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
			
			sessManager = ctx.req.getSession();
			
			String userJSON = gson.toJson(user);
			
			ctx.result(userJSON);
			ctx.status(202);
			
		}else if(user.getRole_id_fk() == 3 || user.getRole_id_fk() == 4){
			
			sessEmp = ctx.req.getSession();
			String empJSON = gson.toJson(user);
			
			ctx.result("Welcome " + empJSON);
			ctx.status(202);
		}else {
			ctx.status(401);
		}
		}
		
	};

}
