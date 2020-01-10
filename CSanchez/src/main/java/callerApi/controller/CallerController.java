package callerApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import callerApi.model.domain.Car;
import callerApi.service.CallerService;


@RestController
@RequestMapping("/Caller")
public class CallerController {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CallerService callerService;
	
			
	@GetMapping(value = "/CallMessage")
	public String callAMessageFromOtherAPI() {
		final String uri = "http://localhost:8181/API1/messageToAPI";
		return restTemplate.getForObject(uri, String.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/TakeCars")
	public Car[] takeCarsFromOtherAPI() {
		final String uri = "http://localhost:8181/API1/cars";
		return restTemplate.getForObject(uri,Car[].class);
	}
	
	//method to save car
	@PostMapping(value = "/saveCar",consumes = "application/json", produces = "application/json")
	public void saveCars(@RequestBody Car car){
		final String uri = "http://localhost:8181/API1/car";
		restTemplate.postForObject(uri, car, String.class);
		
	}

}
