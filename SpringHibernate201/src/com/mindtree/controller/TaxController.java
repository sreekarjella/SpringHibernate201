package com.mindtree.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.entity.Category;
import com.mindtree.entity.PropertyStatus;
import com.mindtree.entity.Zone;
import com.mindtree.model.GetUavModel;
import com.mindtree.model.PaidTax;
import com.mindtree.model.ReportModel;
import com.mindtree.service.TaxService;

@CrossOrigin
@Controller
public class TaxController 
{
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	TaxService taxService;
	
	@GetMapping("/report")
	public ResponseEntity<?> getReport()
	{
		try 
		{
			return new ResponseEntity<List<ReportModel>>(taxService.getReport(),HttpStatus.OK);
		} 
		catch (Exception ex) 
		{
			LOGGER.log(Level.SEVERE, "Some error occurred in getting report.");
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/zones")
	public ResponseEntity<?> getZones()
	{
		try
		{
			return new ResponseEntity<List<Zone>>(taxService.getZones(),HttpStatus.OK);
		}
		catch (Exception ex) 
		{
			LOGGER.log(Level.SEVERE, "Some error occurred in getting the zones.");
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/categories")
	public ResponseEntity<?> getCategories()
	{
		try
		{
			return new ResponseEntity<List<Category>>(taxService.getCategories(),HttpStatus.OK);
		}
		catch (Exception ex) 
		{
			LOGGER.log(Level.SEVERE, "Some error occurred in getting the categories.");
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/statuses")
	public ResponseEntity<?> getStatuses()
	{
		try
		{
			return new ResponseEntity<List<PropertyStatus>>(taxService.getStatuses(),HttpStatus.OK);
		}
		catch (Exception ex) 
		{
			LOGGER.log(Level.SEVERE, "Some error occurred in getting the statuses.");
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/tax")
	public ResponseEntity<?> saveTax(@Valid @RequestBody PaidTax pt)
	{
		try
		{
			return new ResponseEntity<Boolean>(taxService.updateTax(pt.getPaidTax(), pt.getZoneId(), pt.getStatusId()),HttpStatus.OK);
		}
		catch (Exception ex) 
		{
			LOGGER.log(Level.SEVERE, "Some error occurred in paying tax.");
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/uav")
	public ResponseEntity<?> getUav(@Valid @RequestBody GetUavModel u)
	{
		try
		{
			return new ResponseEntity<Double>(taxService.getUav(u.getCategoryId(), u.getZoneId(), u.getStatusId()),HttpStatus.OK);
		}
		catch (Exception ex) 
		{
			LOGGER.log(Level.SEVERE, "Some error occurred in getting UAV value.");
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
