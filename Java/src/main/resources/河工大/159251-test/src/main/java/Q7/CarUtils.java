package Q7;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Q7
 * @author add name here
 * @id add ID here
 */


public class CarUtils {

    private static Object engineer;
	static Object designer;
	static int year;

	
    private static CarUtils car;
    
    public static void main(String[] args) throws Exception{
    		car =new CarUtils();
            Car car1=car.produceCar(null,"Mitsubishi","Pajero","Sport", 2021);
            Car car2=car.produceCar();            
            
            HashSet<String> colorsOption1 =new HashSet<>();
            ArrayList<String> colorOption2=new ArrayList<>();
            car.Paint(colorsOption1,colorOption2);
            car.Paint(colorsOption1,colorOption2);
    }


    public Car produceCar(HashSet<String> colors){
        return this.produceCar(colors,null,null,null,0);
    }

    //a method to produce a car. It takes a set of colors and return a car, and throws a NullPointerException
    public Car produceCar(HashSet<String> colors, String manufacturer, String model, String type, int year) throws NullPointerException{
    	Car car=new Car();
        car.setManufacturer(manufacturer);;
        car.setModel(model);
        car.setType(type);
        engineer =new String("Bob");
        car.setYear(year);
        car.madeBy(engineer, car.getModel(), LocalDateTime.now());
        printCarInfo(car);

        return car;
    }
    
    //a method to produce another car. It takes no argument and return a car, and throws NullPointerException
    public Car produceCar() throws  NullPointerException{
    	Car car=new Car();
        car.setManufacturer("Nissan");;
        car.setModel("Murano");
        car.setType("SUV");
        car.setYear(2022);
        engineer =new String("Sarah");
        car.madeBy(engineer, car.getModel(), LocalDateTime.now());
        printCarInfo(car);
        return car;
    }
    
    //display car info
    private void printCarInfo(Car car) {
		System.out.println("car \""+  car.getManufacturer() +" "+ car.getModel() +"\" has been created");
	}
    
    // check if the car is a new model. Anything from 2015 is considered new
    public Boolean isNew(int year){
		 if(year < 0 ) {
			 System.out.println("new car");
			 return true;
		} else 
			return false;
	 }

    
    //the method gets the car model from the Car class. 
    public String getModel() throws RuntimeException{
        return car.getModel();
    }

    //the method sets paint colors for a new car using a set (hashset) of colors 
	public void Paint(HashSet<String> colors, ArrayList<String> additionalColors){
	    Object key_designer= CarUtils.designer;
	
	    for(String color: colors){
	    	if(isNew(CarUtils.year))
	        	produceCar(colors);
	        }
	}
}