package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Property_Status")
public class PropertyStatus 
{
	@Id
	@Column(name="Status_Id")
	private int statusId;
	
	@Column(name="Status_Name")
	private String statusName;
	
	public PropertyStatus()
	{
		
	}

	public int getStatusId() 
	{
		return statusId;
	}

	public void setStatusId(int statusId) 
	{
		this.statusId = statusId;
	}

	public String getStatusName() 
	{
		return statusName;
	}

	public void setStatusName(String statusName) 
	{
		this.statusName = statusName;
	}
}
