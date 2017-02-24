public class Passenger
{
	private double foodBar;
	private boolean isDead;
	private int happiness;
	private String name;
	public Passenger()
	{
		foodBar = 500;
		happiness = 100;
		isDead = false;
		this.name = "No Name Available";
	}
	public Passenger(String name)
	{
		foodBar = 500;
		happiness = 100;
		isDead = false;
		this.name = name;
	}
	public void feed(Food food)
	{
		foodBar = foodBar + food.getHungerValue();
		if (foodBar > 500)
			foodBar = 500;
	}
	public String getName()
	{
		return name;
	}
	public double getFoodBar()
	{
		return foodBar;
	}
	
	public void eat(double remove)
	{
		foodBar = foodBar - remove;
	}
	public void check()
	{
		if (foodBar <= 0)
		{
			isDead = true;
		}
	}
	public boolean getIsDead()
	{
		return isDead;
	}

	
}