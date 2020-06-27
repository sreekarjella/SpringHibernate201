package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Report")
public class Report 
{
	@Id
	private int id;
	
	@OneToOne
	private PropertyStatus status;
	
	@OneToOne
	private Zone zone;
	
	@Column(name="Total_Tax_Collected")
	private double total_tax;
	
	public Report()
	{
		
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public PropertyStatus getStatus() 
	{
		return status;
	}

	public void setStatus(PropertyStatus status) 
	{
		this.status = status;
	}

	public Zone getZone() 
	{
		return zone;
	}

	public void setZone(Zone zone) 
	{
		this.zone = zone;
	}

	public double getTotal_tax() 
	{
		return total_tax;
	}

	public void setTotal_tax(double total_tax) 
	{
		this.total_tax = total_tax;
	}
}
