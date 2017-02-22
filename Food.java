public class Food
{
	private int hungerValue;
	private String name;
	private int quantity;
	public Food()
	{
		hungerValue = 100;
		name = "Super Food";
		quantity = 0;
	}
	public void setHungerV(int value)
	{
		hungerValue = value;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void addQuantity(int amount)
	{
		quantity = quantity + amount;
	}
	public void removeQuantity(int amount)
	{
		quantity = quantity - amount;
	}
	public int getHungerValue()
	{
		return hungerValue;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public String getName()
	{
		return name;
	}
}