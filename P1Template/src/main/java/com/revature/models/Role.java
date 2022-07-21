package com.revature.models;

public class Role {
	
	private int role_id;
	private String role_name;
	private int role_salary;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Role(int role_id, String role_name, int role_salary) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_salary = role_salary;
	}


	public Role(String role_name, int role_salary) {
		super();
		this.role_name = role_name;
		this.role_salary = role_salary;
	}


	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_salary=" + role_salary + "]";
	}


	public int getRole_id() {
		return role_id;
	}


	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	public int getRole_salary() {
		return role_salary;
	}


	public void setRole_salary(int role_salary) {
		this.role_salary = role_salary;
	}
	
	

}
