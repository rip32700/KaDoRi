package com.hsp.kadori.authentication;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.client.RestTemplate;
import org.apache.http.HttpHost;

public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean  {
	private RestTemplate restTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		HttpHost host = new HttpHost("localhost", 8383, "http");
		restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactoryBasicAuth(host));
	}

	@Override
	public RestTemplate getObject() throws Exception {
		return restTemplate;
	}

	@Override
	public Class<RestTemplate> getObjectType() {
		return RestTemplate.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
}
