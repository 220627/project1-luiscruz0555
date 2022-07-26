package com.revature.daos;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.models.Reimb;

public interface ReimbDAOInterface {

	
	public ArrayList<Reimb> getAllReimb();
	
	public boolean createNewReimb(Reimb newReimb);
	
	public boolean approveReimb(int reimbStatus, int userID);
	
}
