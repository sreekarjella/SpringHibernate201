package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Uav")
public class Uav 
{
	@Id
	private int id;
	
	@OneToOne
	private Category category;
	
	@OneToOne
	private PropertyStatus status;
	
	@OneToOne
	private Zone zone;
	
	@Column(name="UAV")
	private double uav;
	
	public Uav()
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

	public Category getCategory() 
	{
		return category;
	}

	public void setCategory(Category category) 
	{
		this.category = category;
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

	public double getUav() 
	{
		return uav;
	}

	public void setUav(double uav) 
	{
		this.uav = uav;
	}
}
