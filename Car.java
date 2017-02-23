public class Car extends Vehicle
{
	private Engine myEngine = new Engine();
	private double weight;
	
	public Car()
	{
		this(new Engine());
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