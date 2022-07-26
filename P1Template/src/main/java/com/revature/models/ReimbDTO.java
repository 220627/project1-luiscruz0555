package com.revature.models;

public class ReimbDTO {
	
	private int reimb_status_id_fk;
	private int reimb_id;
	
	
	public ReimbDTO(int reimb_status_id_fk, int reimb_id) {
		super();
		this.reimb_status_id_fk = reimb_status_id_fk;
		this.reimb_id = reimb_id;
	}


	@Override
	public String toString() {
		return "ReimbDTO [reimb_status_id_fk=" + reimb_status_id_fk + ", reimb_id=" + reimb_id + "]";
	}


	public int getReimb_status_id_fk() {
		return reimb_status_id_fk;
	}


	public void setReimb_status_id_fk(int reimb_status_id_fk) {
		this.reimb_status_id_fk = reimb_status_id_fk;
	}


	public int getReimb_id() {
		return reimb_id;
	}


	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	
	

}
