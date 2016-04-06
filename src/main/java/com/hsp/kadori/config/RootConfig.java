package com.hsp.kadori.config;

//import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.dao.impl.UserDaoImpl;

@Configuration
public class RootConfig {

	/*
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/Twittr?user=root&password=password");
		//ds.setUsername("root");
		//ds.setUsername("password");
		return ds;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	*/
	
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
}
