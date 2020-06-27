package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Category;
import com.mindtree.entity.PropertyStatus;
import com.mindtree.entity.Zone;
import com.mindtree.model.ReportModel;

public interface TaxService 
{
	public List<ReportModel> getReport() throws Exception;
	public List<Zone> getZones() throws Exception;
	public List<Category> getCategories() throws Exception;
	public List<PropertyStatus> getStatuses() throws Exception;
	public boolean updateTax(double paidTax, int zoneId, int statusId) throws Exception;
	double getUav(int categoryId, int zoneId, int statusId) throws Exception;
}
