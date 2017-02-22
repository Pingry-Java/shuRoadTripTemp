public class Vehicle
{
	private static double fuelCapacity = 16.0;
	private static int seats = 4;
	private static double cargoCapacity = 500;
	private static int wheels = 4;
	private static double baseWeight = 4000.0;
	
	private int milesToDestination = 2893;
	private double money;
	private double fuel;
	private int passengers;
	private double cargo;
	private int tires;
	private double odometer;
	private double forwardProgress;
	private Engine engine = new Engine();
	private double speed;
	private double weight;
	
	/**
	* Represents the mile markers for all the gas stops along the way
	*/
	private static int[] gasStops;
	
	// This thing is called a static initializer
	static
	{
		gasStops = new int[15];
		gasStops[0] = 0;
		for (int i = 1; i < gasStops.length; i++)
			gasStops[i] = gasStops[i - 1] + 200;
	}
	
	public Vehicle()
	{
		this.money = 2000;
		this.fuel = 16.0;
		this.passengers = 4;
		this.cargo = 250.0;
		this.tires = 5;
		this.odometer = 0.0;
		this.forwardProgress = 0.0;
		
		weight = baseWeight + (passengers * 150) + cargo + engine.getWeight();
	}
	
	public Vehicle(Engine e)
	{
		this.engine = e;
		this.money = 2000;
		this.fuel = 16.0;
		this.passengers = 4;
		this.cargo = 250.0;
		this.tires = 4;
		this.odometer = 0.0;
		this.forwardProgress = 0.0;
		
		weight = baseWeight + (passengers * 150) + cargo + engine.getWeight();
	}
	
	private double distanceToNextStop()
	{
		return ((forwardProgress/200) - (int)(forwardProgress/200)) * 200;
	}
	
	public double getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	
	public void drive()
	{
		fuel -= engine.fuelRequired(this.distanceToNextStop(), this.totalWeight(), this.getSpeed());
		milesToDestination -= this.distanceToNextStop();
		forwardProgress += this.distanceToNextStop();
	}
	
	public void drive(double minDistance)
	{
		fuel -= engine.fuelRequired(minDistance, this.totalWeight(), this.getSpeed());
		milesToDestination -= minDistance;
		forwardProgress += minDistance;
	}
	
	public double totalWeight()
	{
		return baseWeight + (passengers * 150) + cargo;
	}
	
	//beginning of accessors
	public double getWeight()
	{
		return weight;
	}
	public double getFuelCapacity()
	{
		return fuelCapacity;
	}
	public double getCargo()
	{
		return cargo;
	}
	public void addCargo(double cargoChange)
	{
		cargo = cargo + cargoChange;
	}
	public double getFuel()
	{
		return fuel;
	}
	public double getCargoCapacity()
	{
		return cargoCapacity;
	}
	public Engine getEngine()
	{
		return engine;
	}
	public void setTires(int tires)
	{
		this.tires = tires;
	}
	public void pay(double money)
	{
		this.money = this.money - money;
	}
	public void payment(double money)
	{
		this.money = this.money + money;
	}
	public void addFuel(double amount)
	{
		fuel = fuel + amount;
	}
	public double balance()
	{
		return money;
	}
	public double getForwardProgress()
	{
		return forwardProgress;
	}
	public void addTires(int tires)
	{
		this.tires = this.tires + tires;
	}
}