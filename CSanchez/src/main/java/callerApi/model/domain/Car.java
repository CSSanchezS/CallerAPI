package callerApi.model.domain;


import lombok.Data;

@Data
public class Car {
	private int idCar;
	private String name;
	private String version;
	private String model;
	
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int IdCar) {
		this.idCar = IdCar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
