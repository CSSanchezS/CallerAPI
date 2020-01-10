package callerApi.model.domain;


import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class Car {
	private int idCar;
	private String name;
	private String version;
	private String model;
	
	}
