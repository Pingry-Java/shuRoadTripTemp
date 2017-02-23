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
	public void feed(Food food)
	{
		
		if (food.getQuantity() > 0)
		{
			foodBar = foodBar + food.getHungerValue();
			food.removeQuantity(1);
		}
		if (foodBar > 100)
			foodBar = 100;
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
	
}