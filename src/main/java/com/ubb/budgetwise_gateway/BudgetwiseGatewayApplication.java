package com.ubb.budgetwise_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class BudgetwiseGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetwiseGatewayApplication.class, args);
	}

}
