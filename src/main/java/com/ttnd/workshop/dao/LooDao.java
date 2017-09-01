package com.ttnd.workshop.dao;

import java.util.List;

import com.ttnd.workshop.entities.Loo;

public interface LooDao {
	Integer save(Loo loo);

	List<Loo> get();

	void update(Loo loo);

	Loo findByID(Integer id);

	void delete(Loo loo);

	public void setRating(int id,int rating);

}
