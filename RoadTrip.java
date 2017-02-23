import java.util.Scanner;
import java.util.ArrayList;
public class RoadTrip
{
	
	public static void main(String[] args)
	{
		//features - a help page, random breakdowns, loading cargo that you are tasked with bringing to another gas station that you sell for money. Ask user for spare tire.
		//Pretty big bug - I'm pretty sure if the numbers are negative then it gives the user money, takes away cargo, etc. Need to make sure that doesn't happen.
		//Another pretty big bug - Right now there are no checks on whether or not the user has exceeded the cargo limit. deliverCargo itself is just broken. 
		//Last big bug - The whole cargo delivery thing is broken af. I don't think it's required, it was something I wanted to try. We can just remove it. 
		//TODO - Fix bugs, implement main game (driving mechanics, travelling, car's breaking down, maybe even passengers dying), make sure requirements are met. I know some of them are not. One example is the chose # of passengers. One possible way is to make a 2D arr.
		//There's more bugs/todos scattered below.
		System.out.println("Welcome to Road Trip! Which vehicle would you like to use? ");
		System.out.println("Vehicles - " + "\n" + "Bus " + "\n" + "Truck" + "\n" + "Motorcycle" + "\n" +  "Car");
		
		Scanner keyboard = new Scanner(System.in);
		String userVehicle;
		String input;
		
		userVehicle = keyboard.nextLine();
		System.out.println("Please enter the number of people.");
		int numPeople = keyboard.nextInt();
		keyboard.nextLine();
		Passenger[] myPassengers = new Passenger[numPeople];
		System.out.println("Would you like to name your passengers? y/n");
		String nameYN = keyboard.nextLine();
		if (nameYN.equals("y"))
		{
			for (int i = 0; i < numPeople; i++)
			{
				System.out.println("Enter name: ");
				myPassengers[i] = new Passenger(keyboard.nextLine());
			}
		}
		if (nameYN.equals("n"))
		{
			for (int i = 0; i < numPeople; i++)
				myPassengers[i] = new Passenger("" + i);
		}
		Vehicle user;
		if (userVehicle.equals("Motorcycle"))
			user = new Motorcycle(myPassengers);
		else if (userVehicle.equals("Truck"))
			user = new Truck(myPassengers);
		else if (userVehicle.equals("Bus"))
		{
			user = new Bus(myPassengers);
			System.out.println("You have picked Bus.");
		}
		else if(userVehicle.equals("Car"))
			user = new Car(myPassengers);
		else
		{
			user = new Car(myPassengers);
			System.out.println("That option was not detected. You have been given a car.");
		}
		System.out.println("Enter Space to Continue.");
		while (!keyboard.nextLine().equals(" "))
		{
			System.out.println("Enter Space to Continue.");
		}
		System.out.println("\n"+"\n");
		
		double carWeight = user.getWeight();
		System.out.println("Before you start your trip, there's a few things you might want to know about your Vehicle. " + "\n" + "It can hold up to " + user.getFuelCapacity() + " gallons of fuel at a time. You start with a full tank.");
		System.out.println("Your vehicle can store up to " + user.getCargoCapacity() + " lbs of cargo and it currently holds " + user.getCargo() + " lbs.");
		System.out.println("Enter Space to Continue.");
		while (!keyboard.nextLine().equals(" "))
		{
			System.out.println("Enter Space to Continue.");
		}
		System.out.println("\n"+"\n");
		System.out.println("To refuel your vehicle, there will be gas stations. At gas stations, you will be able to recieve assignments to deliver cargo. You can decline the offers. If you accept and succeed, you will be paid. You can also buy food to feed your passengers.");
		System.out.println("However, the heavier the vehicle and its cargo is, the more fuel it will use. Also, the faster you travel, the more fuel you will use. Right now, it would take " + user.getEngine().fuelRequired(200, carWeight, 50) + " gallons if you were to travel to the next gas station (200 miles) at 50 mph.");
		//System.out.println("You can access this information at any time by typing help in the command line.");
		//Todo - make above possible
		System.out.println("Your journey starts now! Sucessfully get to your destination! Good Luck! ");
		
		System.out.println("To start, we will be giving you a spare tire and $50 will be charged. This tire also will take up some cargo space (15 lbs)");
		user.addCargo(15);
		user.setTires(5);
		user.pay(50);
			
		System.out.println("We will also give you some food to start out. This will allow you to feed your passengers.");
		Food pizza = new Pizza();
		Food salad = new Salad();
		Food cookie = new Cookie();
		Food burger = new Burger();
		
		ArrayList<Food> foods = new ArrayList<Food>();
		foods.add(pizza);
		foods.add(burger);
		foods.add(cookie);
		foods.add(salad);
		
		
		Passenger ps1 = new Passenger("Passenger 1");
		Passenger ps2 = new Passenger("Passenger 2");
		Passenger ps3 = new Passenger("Passenger 3");
		Passenger player = new Passenger("Player");
	
		while (!user.isStranded())
		{
			gasStop(user, myPassengers, foods);
			System.out.println("Is there a set distance you'd like to drive? y/n");
			input = keyboard.nextLine();
			while (input.equals("y"))
			{
				System.out.println("How far would you like to drive?");
				double distance = (double) keyboard.nextInt();
				keyboard.nextLine();
				user.drive(distance);
				user.ifStranded();
				user.ifWin();
				System.out.println("'y' to drive a specific distance again. 'n' to drive to the next stop.");
				input = keyboard.nextLine();
			}
			user.drive();
			user.ifStranded();
			user.ifWin();
		}
		
		
		
	}
	public static void gasStop(Vehicle user, Passenger[] ps, ArrayList<Food> foods)
	{
		Scanner keyboard = new Scanner(System.in);
		boolean stay = true;
		double price = Math.random() * (4 - 2 + 1) + 2;
		double cargoWeight = Math.random() * (75 - 50 + 1) + 25;
		int deliveryStop = (int) Math.random() * (10 - (int)(user.getForwardProgress()/200) + 1 + 1 ) + (int)(user.getForwardProgress()/200);
		//Needs Fixing. 
		double deliveryPayment = Math.round(Math.random() * (350 - 100 + 1) + 250);	
		System.out.println("Welcome to the Gas Station!");
		String input2;
		while (stay)
		{
			System.out.println("What would you like to do? (1-7) ");
			System.out.println("1. Buy Gas");
			System.out.println("2. Buy Food");
			System.out.println("3. Deliver Cargo");
			System.out.println("4. Check on your statistics (Balance, cargo weight, etc.)");
			System.out.println("5. Buy spare tires");
			System.out.println("6. Check on the conditions of passengers");
			System.out.println("7. Exit");
			int input = keyboard.nextInt();
			if(input == 1)
			{
				System.out.println("Gas Tank - " + user.getFuel() + "/" + user.getFuelCapacity());
				System.out.println("How much gas would you like to buy? The price is $" + price);
				buyGas(keyboard.nextInt(), price, user);
			}
			else if (input == 2)
			{
				System.out.println("Welcome to the food shop! What would you like? ");
				System.out.println("1. Pizza [20 Food Points] ($15) " + "\n" + "2. Burger [25 Food Points] ($20)" + "\n" + "3. Cookie [5 Food Points] ($5)" + "\n" + "4. Salad [30 Food Points] ($20)");	
				buyFood(keyboard.nextInt(), user, ps, foods);
			}
			else if(input == 3)
			{
				System.out.println("Please deliver " + cargoWeight + " lbs of cargo to gas stop number " + deliveryStop + " (you are at stop " + (int)(user.getForwardProgress()/200) + ") for $" + deliveryPayment);
				System.out.println("Do you accept? (y/n) ");
				if (keyboard.nextLine().equals("y"))
				{
					deliverCargo(user, cargoWeight, deliveryPayment, deliveryStop);
				}
			}
			else if(input == 4)
			{
				System.out.println("Which would you like to check?");
				System.out.println("1. Balance" + "\n" + "2. Fuel and Fuel Efficency" + "\n" + "3. Cargo carried" + "\n" + "4. Food");
				input = keyboard.nextInt();
				if (input == 1)
				{
					System.out.println("Your Balance - $" + user.balance());
				}
				else if(input == 2)
				{
					System.out.println("Gas Tank - " + user.getFuel() + "/" + user.getFuelCapacity());
					System.out.println("To travel to the next gas station (200 miles) travelling at 50 mph, you will need " + user.getEngine().fuelRequired(200, user.totalWeight(), 50));
				}
				else if(input == 3)
				{
					System.out.println("Cargo - " + user.getCargo());
				}
				else if(input == 4)
				{
					System.out.println("null");
				}
				else
					System.out.println("Sorry, that is not one of the options.");
			}
			else if(input == 5)
			{
				System.out.println("How many spare tires would you like? ($50, 15 lbs)");
				input = keyboard.nextInt();
				user.pay(50*input);
				user.addCargo(15*input);
				user.addTires(input);
				System.out.println("Thank you!");
			}
			else if(input == 6)
			{
				//not comeplete, needs the choose how many passengers feature to be working, and the drive stuff to have a correlation with food.
				//Also, its pretty annoying to have to pass all of the arguements in, so hopefully that can be fixed.
				//ps1.feed();
				passCheck(ps);
			}
			else if(input == 7)
			{
				stay = false;
			}
			else
				System.out.println("Sorry, that is not one of the options.");
		
			
		}
		
	}
	public static void buyGas(double gallons, double price, Vehicle user)
	{
		//Todo - Add a feature to back out of buying gas. 
		
		double remainder = 0;
		if((user.getFuel() + gallons) > user.getFuelCapacity())
		{
			user.pay(gallons * price);
			remainder = user.getFuel() + gallons - user.getFuelCapacity();
			user.addFuel(gallons - remainder);//questionable math
			System.out.println("That amount is too much. Your tank has been filled and $" + remainder*price + " have been refunded.");
			user.payment(remainder*price);
			//user.addFuel(remainder);
		}
		else
		{
			user.pay(gallons * price);
			user.addFuel(gallons);
		}
		
	}
	public static void buyFood(int food, Vehicle user, Passenger[] ps, ArrayList<Food> foods)
	{
		Scanner keyboard = new Scanner(System.in);
		//int quantity = 0;
		//System.out.println("How many would you like? ");
		//quantity = keyboard.nextInt();
		if (food == 1)
		{
			user.pay(15);
			for(int i = 0; i < ps.length; i++)
				ps[i].feed(foods.get(0));
		}
		else if (food == 2)
		{
			user.pay(20);
			for(int i = 0; i < ps.length; i++)
				ps[i].feed(foods.get(1));
		}
		else if (food == 3)
		{
			user.pay(5);
			for(int i = 0; i < ps.length; i++)
				ps[i].feed(foods.get(2));
			
		}
		else if (food == 4)
		{
			user.pay(20);
			for(int i = 0; i < ps.length; i++)
				ps[i].feed(foods.get(3));
			
		}
	}
	public static void deliverCargo(Vehicle user, double weight, double price, int stop)
	{
		System.out.println(weight + " lbs of cargo have been added to your vehicle.");
		user.addCargo(weight);
		System.out.println("Good luck!");
		//todo - add a check method to make sure it is delivered.
	}
	
	public static void passCheck(Passenger[] ps)
	{
		System.out.println("Food Bar - " + ps[0].getFoodBar() + "/500");
		System.out.println("Status of passengers - ");
		if(ps[0].getIsDead() == false)
			System.out.print(ps[0].getName() + " is still alive.");
		else
			System.out.println("There's a bug! You should not be on this page because your passengers are dead!");
		
	}
	
}