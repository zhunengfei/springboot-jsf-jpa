package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Integer>,CustomBookingRepository{

	@Query("select b from Booking b where b.name like %?1%")
	public List<Booking> findNameLike(String name) ; 
	
	@Query(value="select name from booking where id=?1", nativeQuery = true)
	public String nativeQueryNameById(Integer id) ;
	
}
