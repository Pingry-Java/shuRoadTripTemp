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
		
	}
	
	public setSpeed()
	{
	
	}
	
	public void drive()
	{
	
	}
	
	public void drive(double minDistance)
	{
	
	}
	
	public double totalWeight()
	{
	
	}
}