package com.example.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@ManagedBean
@Component //取代ManagedBean 或可用 @ManagedBean
@SessionScoped
public class HelloFacesBean {

	@Autowired HelloService service ;
	
	public String getRole(){
		return service.sayHello() ;
//		return "role";
	}
	
}
