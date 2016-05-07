package com.hsp.kadori.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.dao.impl.UserDaoImpl;
import com.hsp.kadori.service.PostService;
import com.hsp.kadori.service.UserService;
import com.hsp.kadori.service.impl.MyUserDetailsService;
import com.hsp.kadori.service.impl.PostServiceImpl;
import com.hsp.kadori.service.impl.UserServiceImpl;

@Configuration
public class RootConfig {

	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/KaDoRi?user=root&password=password");
		return ds;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public PostService postService() {
		return new PostServiceImpl();
	}
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}
	
}
