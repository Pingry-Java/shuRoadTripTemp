public class Car extends Vehicle
{



	public Car(int passengers)
	{
		super( new Engine(6, 90), 16, passengers, 6, 250, 4, 1, 4000); 
		
	}
}