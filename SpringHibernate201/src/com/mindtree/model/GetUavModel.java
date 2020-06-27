package com.mindtree.model;

import javax.validation.constraints.Min;

public class GetUavModel 
{
	@Min(value=1, message="Zone ID should be greater than 1.")
	private int zoneId;
	
	@Min(value=1, message="Status ID should be greater than 1.")
	private int statusId;
	
	@Min(value=1, message="Category ID should be greater than 1.")
	private int categoryId;
	
	public int getZoneId() 
	{
		return zoneId;
	}
	public void setZoneId(int zoneId) 
	{
		this.zoneId = zoneId;
	}
	public int getStatusId() 
	{
		return statusId;
	}
	public void setStatusId(int statusId) 
	{
		this.statusId = statusId;
	}
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}
}
