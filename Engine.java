public class Engine
{
	private int cylinders;
	private double weight; 
	
	public Engine()
	{
		this(6, 350);
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
		if((speed*weight) > (Math.pow(cylinders,4) * 500)) //gives a 129.6mph max to a 5000 truck 
		{
			return -1;
		}
		return 6.67 * Math.pow(10, -10) * distance * weight * speed * speed * cylinders; //magic numbers to tweak the formula
	//the only things that will affect it is distance, weight, speed^2
	}
}