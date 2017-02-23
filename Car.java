public class Car extends Vehicle
{
	private Engine myEngine;
	private double weight;
	
	public Car()
	{
		myEngine = new Engine();
		this(Engine e);
	}
	
	public Car(Engine e)
	{
		super(e);
	}
	
	public Car(Engine e, double f , int  passengers, double cargo, int tires, double baseWeight)
	{
		super(e, f, passengers, cargo, tires, baseWeight);
	}
	
	public Car(Passenger[] arr)
	{
		super(arr);
	}
	
}