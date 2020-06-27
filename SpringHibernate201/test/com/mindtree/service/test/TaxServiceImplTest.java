package com.mindtree.service.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.mindtree.dao.TaxDao;
import com.mindtree.entity.Category;
import com.mindtree.entity.PropertyStatus;
import com.mindtree.entity.Report;
import com.mindtree.entity.Uav;
import com.mindtree.entity.Zone;
import com.mindtree.service.TaxServiceImpl;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class TaxServiceImplTest extends TestCase
{
	@Mock
	private TaxDao taxDao;
	
	@InjectMocks
	private TaxServiceImpl taxService;
	
	@Spy
	private List<Zone> zones = new ArrayList<Zone>();
	
	@Spy
	private List<Category> cats = new ArrayList<Category>();
	
	@Spy
	private List<PropertyStatus> stats = new ArrayList<PropertyStatus>();
	
	@Spy
	private List<Report> reports = new ArrayList<Report>();
	
	@Spy
	private Double123 uav = new Double123();
	
	@Spy
	private Boolean123 result = new Boolean123();
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		zones = getZonesTest();
		cats = getCategoriesTest();
		stats = getStatusesTest();
		reports = getReportsTest();
		uav = getUavTest(1,1,1);
		result = updateReportTest(2000,1,1);
		boolean res = result.getValue();
		try 
		{
			when(taxDao.getZones()).thenReturn(zones);
			when(taxDao.getCategories()).thenReturn(cats);
			when(taxDao.getStatuses()).thenReturn(stats);
			when(taxDao.getReport()).thenReturn(reports);
			when(taxDao.getUav(1, 1, 1)).thenReturn(uav.getValue());
			when(taxDao.updateReport(2000.0, 1, 1)).thenReturn(res);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateReport()
	{
		try
		{
			assertTrue(taxService.updateTax(2000.0, 1, 1));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testGetUav()
	{
		try
		{
			assertEquals(5.0,taxService.getUav(1, 1, 1),0.0);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testGetZones()
	{
		try 
		{
			assertEquals(3,taxService.getZones().size());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetCategories()
	{
		try
		{
			assertEquals(3,taxService.getCategories().size());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testGetStauses()
	{
		try
		{
			assertEquals(2,taxService.getStatuses().size());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testGetReport()
	{
		try
		{
			assertEquals(6,taxService.getReport().size());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static Boolean123 updateReportTest(double paidTax, int zoneId, int statusId)
	{
		Boolean123 result = new Boolean123();
		result.setValue(false);
		List<Report> reports = new ArrayList<Report>();
		
		Zone z1 = new Zone();
		z1.setZoneId(1);
		z1.setZoneName("Zone A");
		
		Zone z2 = new Zone();
		z2.setZoneId(2);
		z2.setZoneName("Zone B");
		
		Zone z3 = new Zone();
		z3.setZoneId(3);
		z3.setZoneName("Zone C");
		
		PropertyStatus stat1 = new PropertyStatus();
		stat1.setStatusId(1);
		stat1.setStatusName("Tenanted");
		
		PropertyStatus stat2 = new PropertyStatus();
		stat2.setStatusId(2);
		stat2.setStatusName("Owner");
		
		Report r1 = new Report();
		r1.setId(1);
		r1.setZone(z1);
		r1.setStatus(stat1);
		r1.setTotal_tax(10044);
		
		Report r2 = new Report();
		r2.setId(2);
		r2.setZone(z1);
		r2.setStatus(stat2);
		r2.setTotal_tax(0);
		
		Report r3 = new Report();
		r3.setId(3);
		r3.setZone(z2);
		r3.setStatus(stat1);
		r3.setTotal_tax(10034);
		
		Report r4 = new Report();
		r4.setId(4);
		r4.setZone(z2);
		r4.setStatus(stat2);
		r4.setTotal_tax(13044);
		
		Report r5 = new Report();
		r5.setId(5);
		r5.setZone(z3);
		r5.setStatus(stat1);
		r5.setTotal_tax(40044);
		
		Report r6 = new Report();
		r6.setId(6);
		r6.setZone(z3);
		r6.setStatus(stat2);
		r6.setTotal_tax(60044);
		
		reports.add(r1);
		reports.add(r2);
		reports.add(r3);
		reports.add(r4);
		reports.add(r5);
		reports.add(r6);
		
		for(Report report : reports)
		{
			if((report.getZone().getZoneId()==zoneId)&&(report.getStatus().getStatusId()==statusId))
			{
				report.setTotal_tax(report.getTotal_tax() + paidTax);
				result.setValue(true);
			}
		}
		
		return result;
	}
	
	public static Double123 getUavTest(int categoryId, int zoneId, int statusId)
	{
		Double123 uav = new Double123();
		List<Uav> uavs = new ArrayList<Uav>();
		
		Zone z1 = new Zone();
		z1.setZoneId(1);
		z1.setZoneName("Zone A");
		
		Zone z2 = new Zone();
		z2.setZoneId(2);
		z2.setZoneName("Zone B");
		
		Zone z3 = new Zone();
		z3.setZoneId(3);
		z3.setZoneName("Zone C");
		
		Category cat1 = new Category();
		cat1.setCategoryId(1);
		cat1.setCatgoryDescription("RCC buildings");
		
		Category cat2 = new Category();
		cat2.setCategoryId(2);
		cat2.setCatgoryDescription("RCC buildings with cement or red-oxide flooring");
		
		Category cat3 = new Category();
		cat3.setCategoryId(3);
		cat3.setCatgoryDescription("Tiled/Sheet of all kinds");
		
		PropertyStatus stat1 = new PropertyStatus();
		stat1.setStatusId(1);
		stat1.setStatusName("Tenanted");
		
		PropertyStatus stat2 = new PropertyStatus();
		stat2.setStatusId(2);
		stat2.setStatusName("Owner");
		
		Uav u1 = new Uav();
		u1.setId(1);
		u1.setCategory(cat1);
		u1.setStatus(stat1);
		u1.setZone(z1);
		u1.setUav(5);
		
		Uav u2 = new Uav();
		u2.setId(2);
		u2.setCategory(cat1);
		u2.setStatus(stat1);
		u2.setZone(z2);
		u2.setUav(4);
		
		Uav u3 = new Uav();
		u3.setId(3);
		u3.setCategory(cat1);
		u3.setStatus(stat1);
		u3.setZone(z3);
		u3.setUav(3.6);
		
		Uav u4 = new Uav();
		u4.setId(4);
		u4.setCategory(cat1);
		u4.setStatus(stat2);
		u4.setZone(z1);
		u4.setUav(2.5);
		
		Uav u5 = new Uav();
		u5.setId(5);
		u5.setCategory(cat1);
		u5.setStatus(stat2);
		u5.setZone(z2);
		u5.setUav(2);
		
		Uav u6 = new Uav();
		u6.setId(6);
		u6.setCategory(cat1);
		u6.setStatus(stat2);
		u6.setZone(z3);
		u6.setUav(1.8);
		
		Uav u7 = new Uav();
		u7.setId(7);
		u7.setCategory(cat2);
		u7.setStatus(stat1);
		u7.setZone(z1);
		u7.setUav(4);
		
		Uav u8 = new Uav();
		u8.setId(8);
		u8.setCategory(cat2);
		u8.setStatus(stat1);
		u8.setZone(z2);
		u8.setUav(3.5);
		
		Uav u9 = new Uav();
		u9.setId(9);
		u9.setCategory(cat2);
		u9.setStatus(stat1);
		u9.setZone(z3);
		u9.setUav(3);
		
		Uav u10 = new Uav();
		u10.setId(10);
		u10.setCategory(cat2);
		u10.setStatus(stat2);
		u10.setZone(z1);
		u10.setUav(1.8);
		
		Uav u11 = new Uav();
		u11.setId(11);
		u11.setCategory(cat2);
		u11.setStatus(stat2);
		u11.setZone(z2);
		u11.setUav(1.6);
		
		Uav u12 = new Uav();
		u12.setId(12);
		u12.setCategory(cat2);
		u12.setStatus(stat2);
		u12.setZone(z3);
		u12.setUav(1.2);
		
		Uav u13 = new Uav();
		u13.setId(13);
		u13.setCategory(cat3);
		u13.setStatus(stat1);
		u13.setZone(z1);
		u13.setUav(3);
		
		Uav u14 = new Uav();
		u14.setId(14);
		u14.setCategory(cat3);
		u14.setStatus(stat1);
		u14.setZone(z2);
		u14.setUav(2.5);
		
		Uav u15 = new Uav();
		u15.setId(15);
		u15.setCategory(cat3);
		u15.setStatus(stat1);
		u15.setZone(z3);
		u15.setUav(2);
		
		Uav u16 = new Uav();
		u16.setId(16);
		u16.setCategory(cat3);
		u16.setStatus(stat2);
		u16.setZone(z1);
		u16.setUav(1.25);
		
		Uav u17 = new Uav();
		u17.setId(17);
		u17.setCategory(cat3);
		u17.setStatus(stat2);
		u17.setZone(z2);
		u17.setUav(1);
		
		Uav u18 = new Uav();
		u18.setId(18);
		u18.setCategory(cat3);
		u18.setStatus(stat2);
		u18.setZone(z3);
		u18.setUav(0.75);
		
		uavs.add(u1);
		uavs.add(u2);
		uavs.add(u3);
		uavs.add(u4);
		uavs.add(u5);
		uavs.add(u6);
		uavs.add(u7);
		uavs.add(u8);
		uavs.add(u9);
		uavs.add(u10);
		uavs.add(u11);
		uavs.add(u12);
		uavs.add(u13);
		uavs.add(u14);
		uavs.add(u15);
		uavs.add(u16);
		uavs.add(u17);
		uavs.add(u18);
		
		for(Uav u : uavs)
		{
			if((u.getCategory().getCategoryId()==categoryId)&&(u.getStatus().getStatusId()==statusId)&&(u.getZone().getZoneId()==zoneId))
			{
				uav.setValue(u.getUav());
			}
		}
		
		return uav;
	}
	
	public static List<Report> getReportsTest()
	{
		List<Report> reports = new ArrayList<Report>();
		
		Zone z1 = new Zone();
		z1.setZoneId(1);
		z1.setZoneName("Zone A");
		
		Zone z2 = new Zone();
		z2.setZoneId(2);
		z2.setZoneName("Zone B");
		
		Zone z3 = new Zone();
		z3.setZoneId(3);
		z3.setZoneName("Zone C");
		
		PropertyStatus stat1 = new PropertyStatus();
		stat1.setStatusId(1);
		stat1.setStatusName("Tenanted");
		
		PropertyStatus stat2 = new PropertyStatus();
		stat2.setStatusId(2);
		stat2.setStatusName("Owner");
		
		Report r1 = new Report();
		r1.setId(1);
		r1.setZone(z1);
		r1.setStatus(stat1);
		r1.setTotal_tax(10044);
		
		Report r2 = new Report();
		r2.setId(2);
		r2.setZone(z1);
		r2.setStatus(stat2);
		r2.setTotal_tax(0);
		
		Report r3 = new Report();
		r3.setId(3);
		r3.setZone(z2);
		r3.setStatus(stat1);
		r3.setTotal_tax(10034);
		
		Report r4 = new Report();
		r4.setId(4);
		r4.setZone(z2);
		r4.setStatus(stat2);
		r4.setTotal_tax(13044);
		
		Report r5 = new Report();
		r5.setId(5);
		r5.setZone(z3);
		r5.setStatus(stat1);
		r5.setTotal_tax(40044);
		
		Report r6 = new Report();
		r6.setId(6);
		r6.setZone(z3);
		r6.setStatus(stat2);
		r6.setTotal_tax(60044);
		
		reports.add(r1);
		reports.add(r2);
		reports.add(r3);
		reports.add(r4);
		reports.add(r5);
		reports.add(r6);
		
		return reports;
	}
	
	public static List<Zone> getZonesTest()
	{
		List<Zone> zones = new ArrayList<Zone>();
		
		Zone z1 = new Zone();
		z1.setZoneId(1);
		z1.setZoneName("Zone A");
		
		Zone z2 = new Zone();
		z2.setZoneId(2);
		z2.setZoneName("Zone B");
		
		Zone z3 = new Zone();
		z3.setZoneId(3);
		z3.setZoneName("Zone C");
		
		zones.add(z1);
		zones.add(z2);
		zones.add(z3);
		
		return zones;
	}
	
	public static List<Category> getCategoriesTest()
	{
		List<Category> cats = new ArrayList<Category>();
		
		Category cat1 = new Category();
		cat1.setCategoryId(1);
		cat1.setCatgoryDescription("RCC buildings");
		
		Category cat2 = new Category();
		cat2.setCategoryId(2);
		cat2.setCatgoryDescription("RCC buildings with cement or red-oxide flooring");
		
		Category cat3 = new Category();
		cat3.setCategoryId(3);
		cat3.setCatgoryDescription("Tiled/Sheet of all kinds");
		
		cats.add(cat1);
		cats.add(cat2);
		cats.add(cat3);
		
		return cats;
	}
	
	public static List<PropertyStatus> getStatusesTest()
	{
		List<PropertyStatus> stats = new ArrayList<PropertyStatus>();
		
		PropertyStatus stat1 = new PropertyStatus();
		stat1.setStatusId(1);
		stat1.setStatusName("Tenanted");
		
		PropertyStatus stat2 = new PropertyStatus();
		stat2.setStatusId(2);
		stat2.setStatusName("Owner");
		
		stats.add(stat1);
		stats.add(stat2);
		
		return stats;
	}
}
