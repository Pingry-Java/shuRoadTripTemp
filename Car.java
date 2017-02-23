public class Car extends Vehicle
{
	private Engine myEngine;
	private double weight;
	
	public Car()
	{
		myEngine = new Engine();
	}
	public Car(Passenger[] arr)
	{
		super(arr);
	}
	
}