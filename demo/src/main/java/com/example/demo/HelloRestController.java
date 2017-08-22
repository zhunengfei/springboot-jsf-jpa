package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.Response;

@RestController
public class HelloRestController {
	
	@RequestMapping(path="/hello",method=RequestMethod.GET)
	public String hello(){
		return "hello world" ;
	}
	
	@Autowired private HelloService service ;
	@Autowired private BookingRepository dao ;
	
	@RequestMapping(path="/findOne/{id}",method=RequestMethod.GET)
	public Booking findOne(@PathVariable("id") Integer id){
		return service.queryOne(id) ;
	}
	
	
	@RequestMapping(path="/findNameLike/{name}",method=RequestMethod.GET)
	public List<Booking> findNameLike(@PathVariable("name") String name){
		return service.queryNameLike(name) ;
	}
	
	@RequestMapping(path="/nativeFindOne/{id}",method=RequestMethod.GET)
	public String nativeQueryNameById(@PathVariable("id") Integer id){
		return dao.nativeQueryNameById(id) ;
	}
	
	
	@RequestMapping(path="/customQuery/{id}",method=RequestMethod.GET)
	public String customQueryById(@PathVariable("id") Integer id){
		return dao.customQuery(id) ;
	}
	
	
}
