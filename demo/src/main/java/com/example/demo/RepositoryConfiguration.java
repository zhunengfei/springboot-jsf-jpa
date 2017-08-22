package com.example.demo;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages="com.example.demo",
entityManagerFactoryRef="entityManagerFactory",
transactionManagerRef="transactionManager")
public class RepositoryConfiguration {

	
	@Autowired DataSource dataSource ;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){       
  	LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
  	em.setDataSource(dataSource);
  	em.setPackagesToScan(new String[] { "com.example.demo" });
  	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<String, Object>();
    properties.put("hibernate.show_sql", "true");
    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    em.setJpaPropertyMap(properties);
  	return em ;
  } 
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager ;
	}
	
}
