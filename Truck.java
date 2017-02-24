public class Truck extends Vehicle
{
	static {
	fuelCapacity = 120;
	cargoCapacity = 2000;
	baseWeight = 32000; }

	public Truck(int passengers)
	{
		 
		super(new Engine(2, 250), 120, passengers, 6, 2000, 18, 2, 32000);
	}
}