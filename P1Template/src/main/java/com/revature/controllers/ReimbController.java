package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.ReimbDAO;
import com.revature.models.Reimb;

import io.javalin.http.Handler;

public class ReimbController {
	
	ReimbDAO rDAO = new ReimbDAO();
	
	
	public Handler createReimbHandler = (ctx) -> {
		
		if(AuthController.sessEmp != null || AuthController.sessManager != null) {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Reimb newReimb = gson.fromJson(body, Reimb.class);
		
		
		if(rDAO.createNewReimb(newReimb)) {
			ctx.status(202);
		}else {
			ctx.status(406);
		}}else {
			ctx.result("You are not logged in.");
			ctx.status(401);
		}
			
	};
	
	
	public Handler getAllReimbs = (ctx) -> {
		
		if(AuthController.sessManager != null) {
		
		ArrayList<Reimb> allReimbs = rDAO.getAllReimb();
		
		Gson gson = new Gson();
		
		String JSONreimbs = gson.toJson(allReimbs);
		
		ctx.result(JSONreimbs);
		
		ctx.status(200);
		}else {
			ctx.result("Access Denied.");
			ctx.status(401);
		}
		
	};

}
