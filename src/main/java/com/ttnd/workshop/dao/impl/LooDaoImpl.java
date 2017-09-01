package com.ttnd.workshop.dao.impl;
import com.ttnd.workshop.dao.*;
import com.ttnd.workshop.entities.Loo;
import com.ttnd.workshop.utils.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
public class LooDaoImpl implements LooDao {

	public Integer save(Loo loo) {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(loo);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + loo.toString());
		return loo.getId();
	}

	public List<Loo> get() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Loo> loos = session.createQuery("FROM Loo").list();
		session.close();
		System.out.println("Found " + loos.size() + " loos");
		return loos;
	}

	public void update(Loo loo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Loo em = (Loo) session.load(Loo.class, loo.getId());
		em.setArea(loo.getArea());
		em.setCity(loo.getCity());
		em.setState(loo.getState());
		em.setLocation(loo.getLocation());
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Successfully updated " + loo.toString());
	
	}
	
	public void setRating(int id,int rating) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Loo em = (Loo) session.load(Loo.class, id);
		em.setRating(em.getRating()+rating);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Successfully rated " + em.toString()+"--"+em.getRating());
	
	}

	public Loo findByID(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Loo e = (Loo) session.load(Loo.class, id);
		//session.close();
		return e;
	
	}

	
	
	public void delete(Loo loo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Loo em = (Loo) session.load(Loo.class, loo.getId());
		session.delete(em);
		session.getTransaction().commit();
		session.close();
		
	}

}
