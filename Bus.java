public class Bus extends Vehicle
{

	static {
	fuelCapacity = 60;
	cargoCapacity = 900;;
	baseWeight = 14400; }


	public Bus(int passengers)
	{
		super(new Engine(500, 200), 60, passengers, 30, 900, 4, 2, 14400);
		
	}


}