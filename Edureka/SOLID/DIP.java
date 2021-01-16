##############
#Refer end classes for DIP.
###############
#The wrong way without IOC
public class Car{
	private battery;
	public Car(){
		batter = new Battery();
		//I need to create a Battery
	}
	
	public void changeBattery(Battery b){
		battery = b;
	}
}

#Done with IOC
public class Car{
	private Battery battery;
	public Car(){
		//Battery is obtained from a factory.
		batter = BatteryFactory.createBattery();
	}
	
	public void changeBattery(Battery b){
		//I can again buy from a factory and pass it.
		//Further I can decide which factory to buy from
		//I can configure this from a file (gettting it from a store)
		battery = b;
	}
	
	public void startCar(){
		battery.ignite();
	}
}

public class Battery{
	public void ignite(){
	}
}

#Above code can be a violation of DIP if we are not depending on Abstraction (Abstact class or Interface.
#If Battery is a class.
#

public interface Battery{
	public void ignite(){
	}
}

public class ExiteBattery implements Battery{
	public void ignite(){
	}
}

public class Car{
	private Battery battery;
	public Car(BatteryFactory factory){
		batter = factory.createBattery();
	}
	
	public void changeBattery(Battery b){
		battery = b;
	}
	
	public void startCar(){
		battery.ignite();
	}
}

/*
Alternatively the BatteryFactory can be a configuration in the xml file.
*/
