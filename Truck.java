public class Truck extends Vehicle
{
	static {
	fuelCapacity = 120;
	cargoCapacity = 2000;
	baseWeight = 10000; }

	public Truck(int passengers)
	{
		 
		super(new Engine(8, 250), 120, passengers, 6, 2000, 18, 2, 10000);
	}
}