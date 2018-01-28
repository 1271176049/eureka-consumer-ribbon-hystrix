package com.example.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.web.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DcController {

	@Autowired
	LoadBalancerClient loadBalancerClient;
	@Autowired
	ConsumerService consumerService;

	@GetMapping("/consumer")
	public String dc() {
		return consumerService.consumer();
	}

}