public class Motorcycle extends Vehicle
{
	static {
	fuelCapacity = 5;
	cargoCapacity = 50;
	baseWeight = 800; }

	public Motorcycle(int passengers)
	{
		super(new Engine(6, 50), 5, passengers, 2, 250, 4, 1, 4000);
	}
}