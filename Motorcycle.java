public class Motorcycle extends Vehicle
{
	
	public Motorcycle(int passengers)
	{
		super(new Engine(2, 50), 5, passengers, 2, 250, 4, 1, 4000);
	}
}