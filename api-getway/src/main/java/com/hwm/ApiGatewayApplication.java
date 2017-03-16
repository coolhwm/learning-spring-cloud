package com.hwm;

import com.hwm.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//整合只是，方便配置
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

	@Bean
	AccessFilter accessFilter(){
		return new AccessFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
