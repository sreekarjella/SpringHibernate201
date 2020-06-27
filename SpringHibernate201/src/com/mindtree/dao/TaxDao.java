package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Category;
import com.mindtree.entity.PropertyStatus;
import com.mindtree.entity.Report;
import com.mindtree.entity.Zone;

public interface TaxDao 
{
	public List<Report> getReport() throws Exception;
	public List<Zone> getZones() throws Exception;
	public List<Category> getCategories() throws Exception;
	public List<PropertyStatus> getStatuses() throws Exception;
	public boolean updateReport(double paidTax, int zoneId, int statusId) throws Exception;
	double getUav(int categoryId, int zoneId, int statusId) throws Exception;
}
