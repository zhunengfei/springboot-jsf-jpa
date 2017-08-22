package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BookingRepositoryImpl implements CustomBookingRepository{

	@PersistenceContext EntityManager em ;
	
	@Override
	public String customQuery(Integer id) {
		return em.find(Booking.class, id).getName();
	}

}
