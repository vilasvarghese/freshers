#The wrong way without IOC
public class Car{
	private battery;
	public Car(){
		batter = new Battery();
	}
	
	public void changeBattery(Battery b){
		battery = b;
	}
}

#Done with IOC
public class Car{
	private battery;
	public Car(){
		batter = BatteryFactory.createBattery();
	}
	
	public void changeBattery(Battery b){
		battery = b;
	}
}

