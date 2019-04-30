package com.kevin.model;

import java.util.Date;

public class UserModel {
	private boolean isEmployee;
	private boolean isAffiliate;
	private Date joinDate;
	public boolean isEmployee() {
		return isEmployee;
	}
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	public boolean isAffiliate() {
		return isAffiliate;
	}
	public void setAffiliate(boolean isAffiliate) {
		this.isAffiliate = isAffiliate;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
}
