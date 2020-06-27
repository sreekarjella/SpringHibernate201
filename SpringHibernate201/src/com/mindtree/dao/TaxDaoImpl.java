package com.mindtree.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Category;
import com.mindtree.entity.PropertyStatus;
import com.mindtree.entity.Report;
import com.mindtree.entity.Zone;

@Repository
public class TaxDaoImpl implements TaxDao 
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Report> getReport() throws Exception 
	{
		List<Report> report = new ArrayList<Report>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query<Report> query = session.createQuery("From Report",Report.class);
			report = query.getResultList();
		}
		catch(HibernateException ex) 
		{
			throw new Exception("Could not get connected to database. Try again later.");
		}
		catch (Exception ex) 
		{
			throw new Exception("Some error ocurred. Try again later.");
		}
		return report;
	}

	@Override
	public List<Zone> getZones() throws Exception 
	{
		List<Zone> zones = new ArrayList<Zone>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query<Zone> query = session.createQuery("From Zone",Zone.class);
			zones = query.getResultList();
		}
		catch(HibernateException ex) 
		{
			throw new Exception("Could not get connected to database. Try again later.");
		}
		catch (Exception ex) 
		{
			throw new Exception("Some error ocurred. Try again later.");
		}
		return zones;
	}

	@Override
	public List<Category> getCategories() throws Exception 
	{
		List<Category> categories = new ArrayList<Category>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query<Category> query = session.createQuery("From Category",Category.class);
			categories = query.getResultList();
		}
		catch(HibernateException ex) 
		{
			throw new Exception("Could not get connected to database. Try again later.");
		}
		catch (Exception ex) 
		{
			throw new Exception("Some error ocurred. Try again later.");
		}
		return categories;
	}

	@Override
	public List<PropertyStatus> getStatuses() throws Exception 
	{
		List<PropertyStatus> statuses = new ArrayList<PropertyStatus>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query<PropertyStatus> query = session.createQuery("From PropertyStatus",PropertyStatus.class);
			statuses = query.getResultList();
		}
		catch(HibernateException ex) 
		{
			throw new Exception("Could not get connected to database. Try again later.");
		}
		catch (Exception ex) 
		{
			throw new Exception("Some error ocurred. Try again later.");
		}
		return statuses;
	}

	@SuppressWarnings("deprecation")
	@Override
	public double getUav(int categoryId, int zoneId, int statusId) throws Exception 
	{
		double uav = 0;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			String q = "select u.uav from Uav u join u.category c join u.status ps join u.zone z where c.categoryId=:cat_id and ps.statusId=:stat_id and z.zoneId=:zone_id";
			Query<Double> query = session.createQuery(q,Double.class);
			query.setInteger("cat_id",1);
			query.setInteger("stat_id",1);
			query.setInteger("zone_id",1);
			uav = query.getSingleResult();
		}
		catch(HibernateException ex) 
		{
			throw new Exception("Could not get connected to database. Try again later.");
		}
		catch (Exception ex) 
		{
			throw new Exception("Some error ocurred. Try again later.");
		}
		return uav;
	}

	@SuppressWarnings({"rawtypes" })
	@Override
	public boolean updateReport(double paidTax, int zoneId, int statusId) throws Exception 
	{
		boolean flag = false;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			String q = "select r.total_tax from Report r join r.status ps join r.zone z where ps.statusId=:stat_id and z.zoneId=:zone_id";
			Query<Double> query = session.createQuery(q,Double.class);
			query.setParameter("stat_id",statusId);
			query.setParameter("zone_id",zoneId);
			double tax = query.getSingleResult();
			tax += paidTax;
			String q1 = "update Report r set r.total_tax=:tax where r.status.statusId=:statusId and r.zone.zoneId=:zoneId";
			Query query1 = session.createQuery(q1);
			query1.setParameter("tax", tax);
			query1.setParameter("statusId",statusId);
			query1.setParameter("zoneId",zoneId);
			query1.executeUpdate();
			flag = true;
		}
		catch(HibernateException ex) 
		{
			flag = false;
			throw new Exception("Could not get connected to database. Try again later.");
		}
		catch (Exception ex) 
		{
			flag = false;
			throw new Exception("Some error ocurred. Try again later.");
		}
		return flag;
	}

}
