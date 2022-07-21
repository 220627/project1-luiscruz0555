package com.revature.models;

public class Reimb {
	
	private int reimb_id;
	private double reimb_amount;
	private String reimb_submitted;
	private String reimb_resolved;
	private String reimb_description;
	private int reimb_author_fk;
	private int reimb_resolver_fk;
	private int reimb_status_id_fk;
	private int reimb_type_id_fk;
	
	
	
	public Reimb() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Reimb(int reimb_id, double reimb_amount, String reimb_submitted, String reimb_resolved,
			String reimb_description, int reimb_author_fk, int reimb_resolver_fk, int reimb_status_id_fk,
			int reimb_type_id_fk) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author_fk = reimb_author_fk;
		this.reimb_resolver_fk = reimb_resolver_fk;
		this.reimb_status_id_fk = reimb_status_id_fk;
		this.reimb_type_id_fk = reimb_type_id_fk;
	}



	public Reimb(double reimb_amount, String reimb_submitted, String reimb_resolved, String reimb_description,
			int reimb_author_fk, int reimb_resolver_fk, int reimb_status_id_fk, int reimb_type_id_fk) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author_fk = reimb_author_fk;
		this.reimb_resolver_fk = reimb_resolver_fk;
		this.reimb_status_id_fk = reimb_status_id_fk;
		this.reimb_type_id_fk = reimb_type_id_fk;
	}



	@Override
	public String toString() {
		return "Reimb [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted=" + reimb_submitted
				+ ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_author_fk=" + reimb_author_fk + ", reimb_resolver_fk=" + reimb_resolver_fk
				+ ", reimb_status_id_fk=" + reimb_status_id_fk + ", reimb_type_id_fk=" + reimb_type_id_fk + "]";
	}



	public int getReimb_id() {
		return reimb_id;
	}



	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}



	public double getReimb_amount() {
		return reimb_amount;
	}



	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}



	public String getReimb_submitted() {
		return reimb_submitted;
	}



	public void setReimb_submitted(String reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}



	public String getReimb_resolved() {
		return reimb_resolved;
	}



	public void setReimb_resolved(String reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}



	public String getReimb_description() {
		return reimb_description;
	}



	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}



	public int getReimb_author_fk() {
		return reimb_author_fk;
	}



	public void setReimb_author_fk(int reimb_author_fk) {
		this.reimb_author_fk = reimb_author_fk;
	}



	public int getReimb_resolver_fk() {
		return reimb_resolver_fk;
	}



	public void setReimb_resolver_fk(int reimb_resolver_fk) {
		this.reimb_resolver_fk = reimb_resolver_fk;
	}



	public int getReimb_status_id_fk() {
		return reimb_status_id_fk;
	}



	public void setReimb_status_id_fk(int reimb_status_id_fk) {
		this.reimb_status_id_fk = reimb_status_id_fk;
	}



	public int getReimb_type_id_fk() {
		return reimb_type_id_fk;
	}



	public void setReimb_type_id_fk(int reimb_type_id_fk) {
		this.reimb_type_id_fk = reimb_type_id_fk;
	}
	
	

}
