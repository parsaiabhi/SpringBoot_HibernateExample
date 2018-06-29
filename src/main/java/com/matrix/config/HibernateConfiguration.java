package com.matrix.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class HibernateConfiguration {

	
	@Value("${db.driver}")
	private String DRIVER;
	
	@Value("${db.url}")
	private String URL;
	
	@Value("${db.username}")
	private String USER_NAME;
	
	@Value("${db.password}")
	private String PASSWORD;
	
	
	@Value("${hibernate.show_sql}")
	private String SHOW_SQL;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL_AUTO;
	
	@Value("${hibernate.dialect}")
	private String DIALECT;
	
	@Value("${entitymanager.packagesToScan}")
	private String PACKAGES_TO_SCAN;
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(DRIVER);
		ds.setUrl(URL);
		ds.setUsername(USER_NAME);
		ds.setPassword(PASSWORD);
		
		return ds;
		
	}
	@Bean
	public LocalSessionFactoryBean getSessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
		
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.put("hibernateshow_sql", SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto",HBM2DDL_AUTO);
		hibernateProperties.put("hibernate.dialect",DIALECT);
		
		sessionFactory.setHibernateProperties(hibernateProperties);
		
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager getHTManager(){
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		
		txMgr.setSessionFactory(getSessionFactory().getObject());
		return txMgr;
		
	}
	
	
	
	
	
}
