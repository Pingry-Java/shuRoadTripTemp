import java.util.Scanner;
public class RoadTrip
{
	
	public static void main(String[] args)
	{
		//features - a help page, random breakdowns, loading cargo that you are tasked with bringing to another gas station that you sell for money. Ask user for spare tire.
		System.out.println("Welcome to Road Trip! Which vehicle would you like to use? ");
		System.out.println("Vehicles - " + "\n" + "Bus " + "\n" + "Truck" + "\n" + "Motorcycle" + "\n" +  "Car");
		
		Scanner keyboard = new Scanner(System.in);
		String userVehicle;
		
		userVehicle = keyboard.nextLine();
		
		System.out.println("Great Choice!");
		Vehicle user;
		if (userVehicle.equals("Motorcycle"))
			user = new Motorcycle();
		else if (userVehicle.equals("Truck"))
			user = new Truck();
		else if (userVehicle.equals("Bus"))
			user = new Bus();
		else
			user = new Car();
		
		double carWeight = user.getWeight();
		System.out.println("Before you start your trip, there's a few things you might want to know about your Vehicle. " + "\n" + "It can hold up to " + user.getFuelCapacity() + " gallons of fuel at a time. You start with a full tank.");
		System.out.println("Your vehicle can store up to " + user.getCargoCapacity() + " lbs of cargo and it currently holds " + user.getCargo() + " lbs.");
		System.out.println("To refuel your vehicle, there will be gas stations. At gas stations, you will be able to recieve assignments to deliver cargo. You can decline the offers. If you accept and suceed, you will be paid. You can also buy food to feed your passengers.");
		System.out.println("However, the heavier the vehicle and its cargo is, the more fuel it will use. Also, the faster you travel, the more fuel you will use. Right now, it would take " + user.getEngine().fuelRequired(200, carWeight, 50) + " gallons if you were to travel to the next gas station (200 miles) at 50 mph.");
		//System.out.println("You can access this information at any time by typing help in the command line.");
		//Todo - make above possible
		System.out.println("Your journey starts now! Sucessfully get to your destination! Don't run out of fuel! ");
		
		System.out.println("Would you like to buy a spare tire ($50)? There is always a chance of your vehicle having issues! ");
		
		if (keyboard.nextLine().equals("yes")||keyboard.nextLine().equals("Yes"));
		{
			user.addCargo(15);
			user.setTires(5);
			user.pay(50);
			System.out.println("You have purchased a spare tire. This has increased your cargo by 15 lbs, and you have paid $50");
		}
		
		boolean gameOver = false;
		Passenger ps1 = new Passenger("Passenger 1");
		Passenger ps2 = new Passenger("Passenger 2");
		Passenger ps3 = new Passenger("Passenger 3");
		Passenger player = new Passenger("Player");
		/*
		while (gameOver != true)
		{
			
		}
		*/
		user.drive();
		gasStop(user);
		System.out.println(user.getFuel());
		System.out.println(user.balance());
		
	}
	public static void gasStop(Vehicle user)
	{
		Scanner keyboard = new Scanner(System.in);
		boolean stay = true;
		double price = Math.random() * (4 - 2 + 1) + 2;
		double cargoWeight = Math.random() * (75 - 50 + 1) + 25;
		int deliveryStop = (int) Math.random() * (10 - (int)(user.getForwardProgress()/200) + 1 + 1 ) + 25;
		//questionable line above
		double deliveryPayment = Math.round(Math.random() * (350 - 100 + 1) + 250);	
		System.out.println("Welcome to the Gas Station!");
		while (stay)
		{
			System.out.println("What would you like to do? (1-3) ");
			System.out.println("1. Buy Gas");
			System.out.println("2. Buy Food");
			System.out.println("3. Deliver Cargo");
			
			if(keyboard.nextInt() == 1)
			{
				System.out.println("Gas Tank - " + user.getFuel() + "/" + user.getFuelCapacity());
				System.out.println("How much gas would you like to buy? The price is $" + price);
				buyGas(keyboard.nextInt(), price, user);
			}
			else if (keyboard.nextInt() == 2)
			{
				System.out.println("Welcome to the food shop! What would you like? ");
				System.out.println("1. Pizza [20 Food Points] ($15) " + "\n" + "2. Burger [25 Food Points] ($20)" + "\n" + "3. Cookie [5 Food Points, 5 Happiness] ($5)" + "4. Salad [30 Food Points, -2 Happiness] ($20)");	
				buyFood(keyboard.nextInt(), user);
			}
			else if(keyboard.nextInt() == 3)
			{
				System.out.println("Please deliver " + cargoWeight + " lbs of cargo to gas stop number " + deliveryStop + " (you are at stop " + (int)(user.getForwardProgress()/200) + ") for $" + deliveryPayment);
				System.out.println("Do you accept? (y/n) ");
				if (keyboard.nextLine().equals("y"))
				{
					deliverCargo(user, cargoWeight, deliveryPayment, deliveryStop);
				}
			}
			else
				System.out.println("Sorry, that is not one of the options.");
			System.out.println("Would you like to leave the gas station? ");
			if (keyboard.nextLine().equals("yes")||keyboard.nextLine().equals("Yes"))
				stay = false;
			
		}
		
	}
	public static void buyGas(double gallons, double price, Vehicle user)
	{
		//Todo - Add a feature to back out of buying gas. Also something may be buggy about refund.
		
		double remainder = 0;
		if((user.getFuel() + gallons) > user.getFuelCapacity())
		{
			user.pay(gallons * price);
			remainder = user.getFuel() + gallons - user.getFuelCapacity();
			user.addFuel(gallons - remainder);//questionable math
			System.out.println("That amount is too much. Your tank has been filled and $" + remainder*price + " have been refunded.");
			user.payment(remainder*price);
			user.addFuel(remainder);
		}
		else
		{
			user.pay(gallons * price);
			user.addFuel(gallons);
		}
		
	}
	public static void buyFood(int food, Vehicle user)
	{
		Scanner keyboard = new Scanner(System.in);
		int quantity = 0;
		System.out.println("How many would you like? ");
		quantity = keyboard.nextInt();
		if (food == 1)
		{
			user.pay(15 * quantity);
			//todo - feeding system, maybe it increases weight but i don't think that is needed. 
		}
		else if (food == 2)
		{
			user.pay(20 * quantity);
			
		}
		else if (food == 3)
		{
			user.pay(5*quantity);
			
		}
		else if (food == 4)
		{
			user.pay(20*quantity);
			
		}
	}
	public static void deliverCargo(Vehicle user, double weight, double price, int stop)
	{
		System.out.println(weight + " lbs of cargo have been added to your vehicle.");
		user.addCargo(weight);
		System.out.println("Good luck!");
		//todo - add a check method to make sure it is delivered.
	}
	
}