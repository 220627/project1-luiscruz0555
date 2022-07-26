package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		
		try ( Connection conn = ConnectionUtil.getConnection()){
			
			System.out.println("CONNECTION SUCCESSFUL");
			
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		
		Javalin app = Javalin.create(
				
				
				config -> {
					
					config.enableCorsForAllOrigins();
					
				}
				
				).start(3002);
		
		
		
		AuthController ac = new AuthController();
		ReimbController rc = new ReimbController();
		
		
		app.get("/getReimbs", rc.getAllReimbs);
		app.post("/login", ac.loginHandler);
		app.post("/createReimb", rc.createReimbHandler);
		
		app.put("/approve", rc.approveReimb);
		
		//Welcome to P1! 
		
		//If you're reading this, you've successfully cloned your repo and imported the template
		
		//Do you coding in this project, and don't forget to save/push your progress with:
		//git add.
		//git commit -m"message"
		//git push
		
		//yes, you WILL need to push to your repo. The clients will want to see your project repos in your portfolios.
		
		//here's a dog to help you on your way. Have fun!
		
//               __
//          (___()'`;
//          /,    /`
//          \\"--\\
		
	}
	
}
