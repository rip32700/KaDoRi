package com.hsp.kadori.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.hsp.kadori.dao.FriendshipDao;
import com.hsp.kadori.dao.GroupDao;
import com.hsp.kadori.dao.GroupMemberDao;
import com.hsp.kadori.dao.PostDao;
import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.dao.impl.FriendshipDaoImpl;
import com.hsp.kadori.dao.impl.GroupDaoImpl;
import com.hsp.kadori.dao.impl.GroupMemberDaoImpl;
import com.hsp.kadori.dao.impl.PostDaoImpl;
import com.hsp.kadori.dao.impl.UserDaoImpl;
import com.hsp.kadori.service.FriendsService;
import com.hsp.kadori.service.GroupMemberService;
import com.hsp.kadori.service.GroupService;
import com.hsp.kadori.service.PostService;
import com.hsp.kadori.service.UserService;
import com.hsp.kadori.service.impl.FriendsServiceImpl;
import com.hsp.kadori.service.impl.GroupMemberServiceImpl;
import com.hsp.kadori.service.impl.GroupServiceImpl;
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
	
	@Bean PostDao postDao() {
		return new PostDaoImpl();
	}
	
	@Bean GroupMemberDao groupMemberDao() {
		return new GroupMemberDaoImpl();
	}
	
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public GroupDao groupDao() {
		return new GroupDaoImpl();
	}

	@Bean
	public FriendshipDao friendshipDao() {
		return new FriendshipDaoImpl();
	}
	
	@Bean
	public PostService postService() {
		return new PostServiceImpl();
	}
	
	@Bean
	public GroupMemberService groupMemberService() {
		return new GroupMemberServiceImpl();
	}
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}
	
	@Bean
	public FriendsService friendsService() {
		return new FriendsServiceImpl();
	}
	
	@Bean
	public GroupService groupService() {
		return new GroupServiceImpl();
	}
	
	@Bean
	public HttpEntity<String> httpEntity() {
		String plainCreds = "ADMIN:admin";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic "+base64Creds);
		
		return new HttpEntity<String>(headers);
	}
	
	@Bean
	public HttpHeaders httpHeaders() {
		String plainCreds = "ADMIN:admin";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic "+base64Creds);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		return headers;
	}
}
