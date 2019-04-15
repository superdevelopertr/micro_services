package com.vpp.positionapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class PositionController {

	@Autowired
	private LoadBalancerClient eurekaClient;
	
	@GetMapping("/truck/{vehicleName}")
	public Position getLastLocation(@PathVariable String vehicleName){
		RestTemplate client = new RestTemplate();
		
//		List<ServiceInstance> services = eurekaClient.getInstances("POSITION-RECIEVER-APP");
//		if(services.size()==0){
//			throw new RuntimeException("service is not avaiable");
//		}
//		ServiceInstance service =services.get(0);

		
		ServiceInstance service = eurekaClient.choose("POSITION-RECIEVER-APP");
		if(service==null){
			throw new RuntimeException("service is not avaiable");
		}
		
		System.out.println(service.getUri());
		
		Position pos= client.getForObject(service.getUri()+"/vehicles/"+vehicleName, Position.class);

		System.out.println(pos); 
		
		return pos;
	}
}
