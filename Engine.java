public class Engine
{
	private int cylinders;
	
	public Engine()
	{
		this(6);
	}
	
	public Engine(int cyl)
	{
		this.cylinders = cyl;
	}
	
	public int getCylinders()
	{
		return cylinders;
	}
	
	public double fuelRequired(double distance, double weight, double speed)
	{
		return 6.67 * Math.pow(10, -11) * distance * weight * speed * speed;
	}
}