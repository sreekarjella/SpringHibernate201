package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dao.TaxDao;
import com.mindtree.entity.Category;
import com.mindtree.entity.PropertyStatus;
import com.mindtree.entity.Report;
import com.mindtree.entity.Zone;
import com.mindtree.model.ReportModel;

@Service
public class TaxServiceImpl implements TaxService 
{
	@Autowired
	TaxDao taxDao;
	
	@Override
	@Transactional
	public List<ReportModel> getReport() throws Exception 
	{
		List<Report> reports = new ArrayList<Report>();
		List<ReportModel> reportModels = new ArrayList<ReportModel>();
		try
		{
			reports = taxDao.getReport();
			for(Report r : reports)
			{
				ReportModel rm = new ReportModel();
				rm.setStatusName(r.getStatus().getStatusName());
				rm.setTotalTax(r.getTotal_tax());
				rm.setZoneName(r.getZone().getZoneName());
				reportModels.add(rm);
			}
			return reportModels;
		}
		catch(Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Zone> getZones() throws Exception 
	{
		try
		{
			return taxDao.getZones();
		}
		catch(Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Category> getCategories() throws Exception 
	{
		try
		{
			return taxDao.getCategories();
		}
		catch(Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<PropertyStatus> getStatuses() throws Exception 
	{
		try
		{
			return taxDao.getStatuses();
		}
		catch(Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean updateTax(double paidTax, int zoneId, int statusId) throws Exception 
	{
		try
		{
			return taxDao.updateReport(paidTax, zoneId, statusId);
		}
		catch(Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public double getUav(int categoryId, int zoneId, int statusId) throws Exception 
	{
		try
		{
			return taxDao.getUav(categoryId, zoneId, statusId);
		}
		catch(Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
	}

}
