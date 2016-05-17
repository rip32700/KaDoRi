package com.hsp.kadori.dao.impl;


import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.web.client.RestTemplate;

import com.hsp.kadori.authentication.RestTemplateFactory;
import com.hsp.kadori.dao.UserDao;
import com.hsp.kadori.domain.User;
import com.hsp.kadori.service.impl.MyUserDetailsService;

import scala.annotation.meta.setter;


public class UserDaoImpl implements UserDao {

	private static final String USER_URI_V1 = "http://localhost:8181/user/";
    private RestTemplate restTemplate = new RestTemplate();
    
    @Inject
    private MyUserDetailsService userDetailsService;
	
	@Inject
	JdbcOperations jdbcOperations;
	
	@Override
	public User findUserById(Long userId) {
		return restTemplate.getForObject(USER_URI_V1 + "/{userId}", User.class, userId);
	}

	@Override
	public List<User> findAllUsers() {
		RestTemplateFactory factory = new RestTemplateFactory();
		try {
			factory.afterPropertiesSet();
			restTemplate = factory.getObject();
			ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
			
			if(requestFactory instanceof HttpComponentsClientHttpRequestFactory) {
				HttpComponentsClientHttpRequestFactory requestFactory2 = (HttpComponentsClientHttpRequestFactory) requestFactory;
				HttpClient httpClient2 = requestFactory2.getHttpClient();
				DefaultHttpClient httpClient = (DefaultHttpClient) requestFactory2.getHttpClient();
				HttpHost host = new HttpHost("localhost", 8383, "http");
				httpClient.getCredentialsProvider().setCredentials(new AuthScope(host), new UsernamePasswordCredentials("kaa3333", "123test"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		String plainCreds = "kaa3333:123test";
//		byte[] plainCredsBytes = plainCreds.getBytes();
//		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
//		String base64Creds = new String(base64CredsBytes);
//		HttpHeaders headers = new HttpHeaders();
////		headers.add("Authorization", "Bascic "+base64Creds);
//		
//		
//		byte[] encodedAuth = Base64.encodeBase64(plainCreds.getBytes(Charset.forName("US-ASCII")) );
//		String authHeader = "Basic " + new String( encodedAuth );
//		headers.set("Authorization", authHeader);
//		HttpEntity<HttpHeaders> request = new HttpEntity<HttpHeaders>(headers);
		
		
		ResponseEntity<User[]> respone = restTemplate.exchange(USER_URI_V1 + "/all", HttpMethod.GET, null, User[].class);
		User[] userArray = respone.getBody();
//		User[] userArray = restTemplate.getForObject(USER_URI_V1 + "/all", User[].class);
		List<User> userList = Arrays.asList(userArray);
		return userList;
	}

	@Override
	public User save(User user) {
		/*URI uri = */ restTemplate.postForLocation(USER_URI_V1, user);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		List<User> userList = findAllUsers();
		for(User user : userList) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByUsername(String username) {
		List<User> userList = findAllUsers();
		for(User user : userList) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

}
