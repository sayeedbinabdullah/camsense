package com.graphity.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.graphity.model.AdminProduct;
import com.graphity.model.Type;
import com.graphity.model.Provider;
import com.graphity.model.MemberDetail;
import com.graphity.model.Cart;

import java.util.Properties;

@Configuration
@ComponentScan("com.graphity")
@EnableTransactionManagement

public class AppContConfig {

	@Bean(name = "h2DataSource")
	public DataSource getH2DataSource()
	{
		System.out.println("getH2DataSource() started...");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/CamsenseBack");

		dataSource.setUsername("imran");
		dataSource.setPassword("imran");

	
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		System.out.println("getHibernateProperties() started...");
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.setProperty("hibernate.hbm2ddl.auto", "update");
    	
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
    }
    

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource DataSource)
	{
		System.out.println("getSessionFactory() started...");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(DataSource);
		System.out.println("session....."+sessionBuilder);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(MemberDetail.class);
		sessionBuilder.addAnnotatedClass(Type.class);
		sessionBuilder.addAnnotatedClass(Provider.class);
		sessionBuilder.addAnnotatedClass(AdminProduct.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		return sessionBuilder.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)	
	{
		System.out.println("getTransactionManager() started..."+sessionFactory);
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("........"+transactionManager);
		return transactionManager;
	}
	
	
}
