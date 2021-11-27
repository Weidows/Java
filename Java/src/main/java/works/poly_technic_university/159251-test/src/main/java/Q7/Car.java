package Q7;

/**
 * Q7
 * @author add name here
 * @id add ID here
 */

import java.time.LocalDateTime;

public class Car {

	private String type, model, manufacturer;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void madeBy(Object engineer, String model, LocalDateTime time) {

	}

	public int setYear(int year) {
		return year;
	}
}