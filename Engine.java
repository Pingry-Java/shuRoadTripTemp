public class Engine
{
	private int cylinders;
	private double weight; 
	
	public Engine()
	{
		this(16, 350);
	}
	
	public Engine(int cyl, double weight)
	{
		this.cylinders = cyl;
		this.weight = weight;
	}
	
	public int getCylinders()
	{
		return cylinders;
	}
	

	public double getWeight() {
		return weight; 
	}
	public double fuelRequired(double distance, double weight, double speed)
	{
		if((speed*weight) > (cylinders * 800))
		{
			return -1;
		}
		return 1.23 * Math.pow(10, -10) * distance * weight * speed * speed * cylinders;
	}
}