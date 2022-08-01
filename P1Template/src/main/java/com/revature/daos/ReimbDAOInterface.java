package com.revature.daos;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.models.Reimb;

public interface ReimbDAOInterface {

	
	public ArrayList<Reimb> getAllReimb();
	
	public ArrayList<Reimb> getReimbByUserId(int reimb_author_fk);
	
	public boolean createNewReimb(Reimb newReimb);
	
	public boolean approveReimb(int reimbStatus, int userID);
	
	public ArrayList<Reimb> getPendingReimbs();
	
	public ArrayList<Reimb> getApprovedReimbs();
}
