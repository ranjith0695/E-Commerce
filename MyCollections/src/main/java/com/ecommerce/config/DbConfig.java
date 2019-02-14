package com.ecommerce.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecommerce.model.CartProduct;
import com.ecommerce.model.Category;
import com.ecommerce.model.OrderInfo;
import com.ecommerce.model.Product;
import com.ecommerce.model.Supplier;
import com.ecommerce.model.User;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecommerce")
public class DbConfig 
{
	@Bean(name="datasource")
public DataSource getH2DataSource()
{
	DriverManagerDataSource datasource=new DriverManagerDataSource();
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUrl("jdbc:h2:tcp://localhost/~/project");
	datasource.setUsername("dteja");
	datasource.setPassword("dt");
	System.out.println("datasource created");
	return datasource;
	
}
	
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateprop=new Properties();
		 hibernateprop.put("hibernate.hbm2ddl.auto", "update");
		 hibernateprop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		 LocalSessionFactoryBuilder buildfactory=new LocalSessionFactoryBuilder(getH2DataSource());
		buildfactory.addProperties(hibernateprop);
		buildfactory.addAnnotatedClass(Category.class);
		buildfactory.addAnnotatedClass(Supplier.class);
		buildfactory.addAnnotatedClass(Product.class);
		buildfactory.addAnnotatedClass(User.class);
		buildfactory.addAnnotatedClass(CartProduct.class);
		buildfactory.addAnnotatedClass(OrderInfo.class);
		System.out.println("Session Factory Created");
		return buildfactory.buildSessionFactory();
	}
	@Bean(name="hibernateTransactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionfactory) 
	{
		System.out.println("Hibernate Transaction Manager objet created");
		return new HibernateTransactionManager(sessionfactory);
	}
}
