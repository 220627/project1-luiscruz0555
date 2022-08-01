package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.ReimbDAO;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.javalin.http.Handler;

public class ReimbController {
	
	public static Logger log = LogManager.getLogger();
	
	ReimbDAO rDAO = new ReimbDAO();
	
	
	public Handler createReimbHandler = (ctx) -> {
		
		if(AuthController.sessEmp != null || AuthController.sessManager != null) {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Reimb newReimb = gson.fromJson(body, Reimb.class);
		
		
		if(rDAO.createNewReimb(newReimb)) {
			log.info("New reimbursement created.");
			ctx.status(202);
		}else {
			log.info("Reimbursement creation failed.");
			ctx.status(406);
		}}else {
			log.warn("User tried creating reimbursement but is not logged in.");
			ctx.result("You are not logged in.");
			ctx.status(401);
		}
			
	};
	
	
	public Handler getAllReimbs = (ctx) -> {
		
		if(AuthController.sessManager != null) {
		
		log.info("All reimbursements were pulled.");
		ArrayList<Reimb> allReimbs = rDAO.getAllReimb();
		
		Gson gson = new Gson();
		
		String JSONreimbs = gson.toJson(allReimbs);
		
		ctx.result(JSONreimbs);
		
		ctx.status(200);
		}else {
			log.warn("Reimbursements failed to pull. Login authentication might be false.");
			ctx.result("Access Denied.");
			ctx.status(401);
		}
		
	};
	
	
	public Handler approveReimb = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		ReimbDTO rDTO = gson.fromJson(body, ReimbDTO.class);
		
		
		
		if(rDAO.approveReimb(rDTO.getReimb_status_id_fk(), rDTO.getReimb_id())) {
			if(rDTO.getReimb_status_id_fk() == 2) {
			log.info("Reimbursement was approved");
			ctx.result("Reimbursement approved.");
			ctx.status(202);
		}else if(rDTO.getReimb_status_id_fk() == 3) {
			log.info("Reimbursement was denied");
			ctx.result("Reimbursement denied.");
			ctx.status(200);
		}
		}else {
			log.warn("Reimbursement approval failed");
			ctx.status(406);
		}
	};
	
	public Handler getReimbById = (ctx) -> {
		
		int user_id = Integer.parseInt(ctx.body());
		
		ArrayList<Reimb> reimbs = rDAO.getReimbByUserId(user_id);
		
		Gson gson = new Gson();
		
		String JSONreimbs = gson.toJson(reimbs);
		
		if (reimbs != null) {
			log.info("Employee reimbursement were pulled.");
			
			ctx.result(JSONreimbs);
			ctx.status(200);
			
		}else {
			log.warn("Employee reimbursement pull failed");
			ctx.status(406);
		}
		
	};
	
	public Handler getPendingReimbs = (ctx) -> {
		
		ArrayList<Reimb> pendReimbs = rDAO.getPendingReimbs();
		
		Gson gson = new Gson();
		
		String JSONreimbs = gson.toJson(pendReimbs);
		
		if(pendReimbs != null) {
			log.info("Pending reimbursements were pulled.");
			ctx.result(JSONreimbs);
			ctx.status(200);
		}else {
			log.warn("Pending reimbursement pull failed.");
			ctx.result("Reimb pull failed");
			ctx.status(406);
		}
		
	};
	
	public Handler getApprovedReimbs = (ctx) -> {
		
		ArrayList<Reimb> pendReimbs = rDAO.getApprovedReimbs();
		
		Gson gson = new Gson();
		
		String JSONreimbs = gson.toJson(pendReimbs);
		
		if(pendReimbs != null) {
			log.info("Approved reimbursements were pulled.");
			ctx.result(JSONreimbs);
			ctx.status(200);
		}else {
			log.warn("Approved reimbursements pull failed.");
			ctx.result("Reimb pull failed");
			ctx.status(406);
		}
		
	};

}
