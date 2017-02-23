public class Passenger
{
	private int foodBar;
	private boolean isDead;
	private int happiness;
	private String name;
	public Passenger()
	{
		foodBar = 400;
		happiness = 100;
		isDead = false;
		this.name = "Miro";
	}
	public Passenger(String name)
	{
		foodBar = 400;
		happiness = 100;
		isDead = false;
		this.name = name;
	}
	public void feed(Food food)
	{
		foodBar = foodBar + food.getHungerValue();
		if (foodBar > 500)
			foodBar = 400;
	}
	public String getName()
	{
		return name;
	}
	public int getFoodBar()
	{
		return foodBar;
	}
	public boolean getDead()
	{
		if (this.isDead)
			return true;
		return false;
	}
	public void eat(int remove)
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