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
	private int spares;
	private int origTires;
	private int passCap;
	private Passenger[] passArr;
	private double odometer;
	private double forwardProgress;
	private Engine engine = new Engine();
	private double speed;
	private double weight;
	private boolean stranded = false;
	
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
	
	
	public Vehicle(Engine e, double f , int passengers, int passCap, double cargo, int tires, int spares, double baseWeight)
	{
		this.engine = e;
		this.money = 2000;
		this.fuel = f;
		this.passengers = passengers;
		this.passCap = passCap;
		this.cargo = cargo;
		this.tires = tires;
		this.spares = spares;
		this.odometer = 0;
		this.forwardProgress = 0.0;
		this.passArr = new Passenger[passengers];
		
		weight = baseWeight + (passengers * 150) + cargo + engine.getWeight();
	}


	
	public double distanceToNextStop()
	{
		return 200 - forwardProgress%200;
	}
		public void setPass(Passenger[] arr)
	{
		passArr = arr;
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
		fuel = fuel - engine.fuelRequired(this.distanceToNextStop(), this.totalWeight(), this.getSpeed());
		milesToDestination -= this.distanceToNextStop();
		forwardProgress += this.distanceToNextStop();
	}
	
	public void drive(double minDistance)
	{
		setFuel(fuel - engine.fuelRequired(minDistance, this.totalWeight(), this.getSpeed()));
		milesToDestination -= minDistance;
		forwardProgress += minDistance;
	}
	
	public double totalWeight()
	{
		return baseWeight + (passengers * 150) + cargo;
	}
	
	//beginning of accessors
	public void setFuel(double amount)
	{
		fuel = amount;
	}
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
	public boolean isStranded()
	{
		if (this.stranded)
			return true;
		if (this.fuel <= 0)
			return true;
		if (tires<origTires)
			return true;
		for (Passenger p:passArr) {
			if (p.getIsDead())
				return true; //assuming you can't kill your passengers...
		}
		return false;
	}

	public boolean isStranded(boolean tf)//for passengers starving.
	{
		System.out.println("I starved to death");
		return tf;
	}

	
	public Passenger[] getPassengers()
	{
		return passArr;
	}
	public void ifWin()
	{
		if (this.forwardProgress >= this.milesToDestination)
		{
			System.out.println("You made it!!! \n Congratulations!!!");
			System.exit(0);
		}
		
	}
	public void ifStranded()
	{
		if (isStranded())
		{
			System.out.println("You were stranded...");
			System.exit(0);
		}
	}

}