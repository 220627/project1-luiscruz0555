package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.ReimbDAO;
import com.revature.models.Reimb;

import io.javalin.http.Handler;

public class ReimbController {
	
	ReimbDAO rDAO = new ReimbDAO();
	
	public Handler createReimbHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Reimb newReimb = gson.fromJson(body, Reimb.class);
		
		
		if(rDAO.createNewReimb(newReimb)) {
			ctx.status(202);
		}else {
			ctx.status(406);
		}
			
	};

}
