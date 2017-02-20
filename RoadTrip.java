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
		System.out.println("Before you start your trip, there's a few things you might want to know about your Vehicle. " + "\n" + "It can hold up to " + user.getFuelCapacity() + "gallons of fuel at a time. You start with a full tank.");
		System.out.println("Your vehicle can store up to " + user.getCargoCapacity() + " lbs of cargo and it currently holds " + user.getCargo() + " lbs.");
		System.out.println("To refuel your vehicle, there will be gas stations. At gas stations, you will be able to recieve assignments to deliver cargo. You can decline the offers. If you accept and suceed, you will be paid.");
		System.out.println("However, the heavier the vehicle and its cargo is, the more fuel it will use. Also, the faster you travel, the more fuel you will use. Right now, it would take " + user.getEngine().fuelRequired(200, carWeight, 50) + " gallons if you were to travel to the next gas station (200 miles) at 50 mph.");
		System.out.println("You can access this information at any time by typing help in the command line.");
		
		System.out.println("Your journey starts now! Sucessfully get to your destination! Don't run out of fuel! ");
		
		System.out.println("Would you like to buy a spare tire ($50)? There is always a chance of your vehicle having issues! ");
		
		if (keyboard.nextLine().equals("yes"));
		{
			user.addCargo(15);
			user.setTires(5);
			user.pay(50);
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
		System.out.println("Welcome to the Gas Station!");
		while (stay)
		{
			System.out.println("What would you like to do? (1-3) ");
			System.out.println("1. Buy Gas");
			System.out.println("2. Buy Food");
			System.out.println("3. Look for a job");
			
			if(keyboard.nextInt() == 1)
			{
				System.out.println("Gas Tank - " + user.getFuel() + "/" + user.getFuelCapacity());
				System.out.println("How much gas would you like to buy? The price is $" + price);
				buyGas(keyboard.nextInt(), price, user);
			}
			stay = false;
		}
		
	}
	public static void buyGas(int gallons, double price, Vehicle user)
	{
		user.pay((double)gallons * price);
		user.addFuel(gallons);
	}
	
}