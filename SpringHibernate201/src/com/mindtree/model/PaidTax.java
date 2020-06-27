package com.mindtree.model;

import javax.validation.constraints.Min;

public class PaidTax 
{
	@Min(value=0, message="Paid tax should not be negative.")
	private double paidTax;
	
	@Min(value=1, message="Zone ID should be greater than 1.")
	private int zoneId;
	
	@Min(value=1, message="Status ID should be greater than 1.")
	private int statusId;
	
	public double getPaidTax() {
		return paidTax;
	}
	public void setPaidTax(double paidTax) {
		this.paidTax = paidTax;
	}
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
}
