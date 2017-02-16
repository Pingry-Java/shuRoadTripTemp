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
	

	public int getWeight() {
		return weight; 
	}
	public double fuelRequired(double distance, double weight, double speed)
	{
		return 6.67 * Math.pow(10, -11) * distance * weight * speed * speed;
	}
}