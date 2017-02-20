public class Passenger
{
	private int foodBar;
	private boolean isDead;
	private int happiness;
	private String name;
	public Passenger(String name)
	{
		foodBar = 100;
		happiness = 100;
		isDead = false;
		this.name = name;
	}
	public void feed(int food)
	{
		foodBar = foodBar + food;
		if (foodBar > 100)
			foodBar = 100;
	}
	public String getName()
	{
		return name;
	}
	
}