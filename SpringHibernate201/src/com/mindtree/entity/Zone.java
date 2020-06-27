package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Zone")
public class Zone 
{
	@Id
	@Column(name="Zone_Id")
	private int zoneId;
	
	@Column(name="Zone_Name")
	private String zoneName;
	
	public Zone()
	{
		
	}

	public int getZoneId() 
	{
		return zoneId;
	}

	public void setZoneId(int zoneId) 
	{
		this.zoneId = zoneId;
	}

	public String getZoneName() 
	{
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
}
