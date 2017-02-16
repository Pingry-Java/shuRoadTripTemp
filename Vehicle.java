public class Vehicle
{
	private static double fuelCapacity = 16.0;
	private static int seats = 4;
	private static double cargoCapacity = 500;
	private static int wheels = 4;
	private static double baseWeight = 4000.0;
	private static double speed = 0; //starts at 0 unless otherwise changed? 
	
	private int milesToDestination = 2893;
	private double money;
	private double fuel;
	private int passengers;
	private int passengersWeight;
	private double cargo;
	private int tires;
	private double odometer;
	private double forwardProgress;
	private Engine engine;
	
	
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
		Engine V6 = new Engine();
		this(V6);
	}
	
	public Vehicle(Engine e)
	{
		this.engine = e;
		this.money = 2000;
		this.fuel = 16.0;
		this.passengers = 4;
		this.passengersWeight = 520;
		this.cargo = 250.0;
		this.tires = 5;
		this.odometer = 0.0;
		this.forwardProgress = 0.0;
	}
	
	private distanceToNextStop()
	{
		return ((forwardProgress/200) - (int)(forwardProgress/200)) * 200;
	}
	

	public getSpeed()
	{
		return speed; 
	}
	
	public setSpeed(double speed)
	{
		this.speed = speed;
	}
	
	public void drive()
	{
		double fuelNeeded = engine.fuelRequired(this.distanceToNextStop, weight, speed);
		this.fuel -= fuelNeeded; 
		milestoDestination - this.distanceToNextStop; 
		forwardProgress += this.distanceToNextStop; 
	}
	
	public void drive(double minDistance)
	{	
		double fuelNeeded = engine.fuelRequired(minDistance, weight, speed);
		this.fuel -= fuelNeeded; 
		milestoDestination - minDistance; 
		forwardProgress += minDistance; }

	public boolean isStranded() {
		return (this.wheels < 4 || this.fuel <= 0 || this.money == 0);
	}

	public boolean arrived() {
		return (this.milestoDestination == 0);
	}

	public void fillGas() {
		this.fuel = fuelCapacity;
	}


	public double totalWeight(double baseWeight, int passengersWeight, double cargo, Engine engine )
 	{
		 return baseWeight + passengersWeight + Engine.getWeight() + cargo;
	}
}