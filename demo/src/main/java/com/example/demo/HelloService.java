package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired private BookingRepository dao ;
	
	public String sayHello(){
		return "hello";
	}
	
	public Booking queryOne(int id){
		return dao.findOne(id) ;
	}
	
	
	public List<Booking> queryNameLike(String name){
		return dao.findNameLike(name) ;
	}
	
	
}
