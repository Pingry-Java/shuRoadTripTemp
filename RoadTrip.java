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
		System.out.println("");
		Scanner keyboard = new Scanner(System.in);
		String userVehicle;
		String input;
		
		userVehicle = keyboard.nextLine();

		while ( !userVehicle.equals("Motorcycle") & !userVehicle.equals("Truck") & !userVehicle.equals("Bus") & !userVehicle.equals("Car") ) {

			System.out.println("Not a valid vehicle. Please try again: ");
			userVehicle = keyboard.nextLine();

		}
		
		


		System.out.println("Please enter the number of people. (At least 1)");
		int numPeople = keyboard.nextInt();
		keyboard.nextLine();

		Vehicle user;


		if (userVehicle.equals("Motorcycle")) 
		{
			System.out.println("You have picked Motorcycle"); 
			while (numPeople > 2 )  
			{
				System.out.println("Sorry that is not a valid amount of people for that vehicle. Please see: (Car: Max 6, Bus: Max 30, Motocycle: Max 2, Truck: Max 6). Enter new number: ");
				numPeople = keyboard.nextInt();
				keyboard.nextLine();
			}	
			user = new Motorcycle(numPeople);
		}
		else if (userVehicle.equals("Truck")) 
		{
			System.out.println("You have picked Truck."); 
			while (numPeople > 6 )  
			{
			System.out.println("Sorry that is not a valid amount of people for that vehicle. Please see: (Car: Max 6, Bus: Max 30, Motocycle: Max 2, Truck: Max 6). Enter new number: ");
			numPeople = keyboard.nextInt();
			keyboard.nextLine();
			}
			user = new Truck(numPeople);
		}	
		else if (userVehicle.equals("Bus"))
		{
			System.out.println("You have picked Bus.");
			while (numPeople > 30)
			{
				System.out.println("Sorry that is not a valid amount of people for that vehicle. Please see: (Car: Max 6, Bus: Max 30, Motocycle: Max 2, Truck: Max 6). Enter new number: ");
				numPeople = keyboard.nextInt();
				keyboard.nextLine();
			}
			user = new Bus(numPeople);
		
		}
		else {
			System.out.println("You have picked Car."); 
			while (numPeople > 6)
			{
				System.out.println("Sorry that is not a valid amount of people for that vehicle. Please see: (Car: Max 6, Bus: Max 30, Motocycle: Max 2, Truck: Max 6). Enter new number: ");
				numPeople = keyboard.nextInt();
				keyboard.nextLine();
			}
			user = new Car(numPeople); 
		
		}



		System.out.println(numPeople);
		System.out.println("Would you like to name your passengers? y/n");
		String nameYN = keyboard.nextLine();
		if (nameYN.equals("y"))
		{
			for (int i = 0; i < numPeople; i++)
			{
				System.out.println("Enter name: ");
				user.passArr[i] = new Passenger(keyboard.nextLine());
			}
		}
		else
		{
			for (int i = 0; i < numPeople; i++)
				user.passArr[i] = new Passenger();
		}
		



		user.setPass(user.passArr);


		System.out.println("Enter Space to Continue.");
		while (!keyboard.nextLine().equals(" "))
		{
			System.out.println("Enter Space to Continue.");
		}
		System.out.println("\n"+"\n");
		
		System.out.println("How to win -  \nGet to the final destination by stopping at gas stops and refilling. \nYou will have passengers to take along. The more passengers, the harder. \nIf a passenger dies, you will lose points, but not lose the game. \nYou will lose if your balance hits zero, or you run out of gas, or if your tire pops and you have no spares.");
		
		double carWeight = user.getWeight();
		System.out.println("Before you start your trip, there's a few things you might want to know about your Vehicle. " + "\n" + "It can hold up to " + user.getFuelCapacity() + " gallons of fuel at a time. You start with a full tank.");
		System.out.println("Your vehicle can store up to " + user.getCargoCapacity() + " lbs of cargo and it currently holds " + user.getCargo() + " lbs of cargo.");
		System.out.println("Enter Space to Continue.");
		while (!keyboard.nextLine().equals(" "))
		{
			System.out.println("Enter Space to Continue.");
		}
		System.out.println("\n"+"\n");
		System.out.println("To refuel your vehicle, there will be gas stations. At gas stations, you will be able to recieve assignments to deliver cargo. You can decline the offers. If you accept and succeed, you will be paid. You can also buy food to feed your passengers.");
		System.out.println("However, the heavier the vehicle and its cargo is, the more fuel it will use. Also, the faster you travel, the more fuel you will use. Right now, it would take " + user.getEngine().fuelRequired(user.distanceToNextStop(), user.totalWeight(), 50) + " gallons if you were to travel to the next gas station (200 miles) at 50 mph.");
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
		
	
		double distance;
		double speed;
		double score;
		double travelTime = 0;
		int alive = 0;
		while (!user.isStranded())
		{
			gasStop(user, user.passArr, foods);
			System.out.println("Is there a set distance you'd like to drive? y/n");
			input = keyboard.nextLine();
			if (input.equals("y"))
			{
				while(input.equals("y"))
				{
					System.out.println("How far would you like to drive?");
					distance = keyboard.nextDouble();
					keyboard.nextLine();
					System.out.println("How fast would you like to drive?");
					speed =  keyboard.nextDouble();
					keyboard.nextLine();
					user.setSpeed(speed);
					user.drive(distance);
					removeFood(user.passArr, distance,speed);
					travelTime = travelTime + (distance/speed);
					for (int i = 0; i < user.passArr.length; i++)
					{
						user.passArr[i].check();
						if (user.passArr[i].getIsDead() == false)
							alive++;
					}
					score = ((1/travelTime) + (alive + 1)) * 150 - (user.balance() * 0.001);
					user.ifStranded();
					user.ifWin(score);
					System.out.println("'y' to drive a specific distance again. 'n' to drive to the next stop. You MUST end on a stop.");
					input = keyboard.nextLine();
				}
			}
			
		
			System.out.println("How fast would you like to drive?");
			speed =  keyboard.nextDouble();
			keyboard.nextLine();
			user.setSpeed(speed);
			user.drive();
			removeFood(user.passArr, user.distanceToNextStop(),speed);
			travelTime = travelTime + (user.distanceToNextStop()/speed);
			
			
			for (int i = 0; i < user.passArr.length; i++)
			{
				user.passArr[i].check();
				if (user.passArr[i].getIsDead() == false)
					alive++;
			}
			score = ((1/travelTime) + (alive + 1)) * 150 - (user.balance() * 0.001);
			user.ifStranded();
			
			user.ifWin(score);
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
		System.out.println("You are at gas station number " + Math.round(user.getForwardProgress()/200));
		String input2;
		while (stay)
		{
			System.out.println("What would you like to do? (1-6) ");
			System.out.println("1. Buy Gas");
			System.out.println("2. Buy Food");
			System.out.println("3. Check on your statistics (Balance, cargo weight, etc.)");
			System.out.println("4. Buy spare tires");
			System.out.println("5. Check on the conditions of passengers");
			System.out.println("6. Exit and continue travelling");
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
				System.out.println("Which would you like to check?");
				System.out.println("1. Balance" + "\n" + "2. Fuel and Fuel Efficency" + "\n" + "3. Cargo carried");
				input = keyboard.nextInt();
				if (input == 1)
				{
					System.out.println("Your Balance - $" + user.balance());
				}
				else if(input == 2)
				{
					System.out.println("Gas Tank - " + user.getFuel() + "/" + user.getFuelCapacity());
					System.out.println("To travel to the next gas station (200 miles) travelling at 50 mph, you will need " + user.getEngine().fuelRequired(user.distanceToNextStop(), user.totalWeight(), 50));
				}
				else if(input == 3)
				{
					System.out.println("Cargo - " + user.getCargo());
				}
				
				else
					System.out.println("Sorry, that is not one of the options.");
			}
			else if(input == 4)
			{
				System.out.println("How many spare tires would you like? ($50, 15 lbs)");
				input = keyboard.nextInt();
				user.pay(50*input);
				user.addCargo(15*input);
				user.addTires(input);
				System.out.println("Thank you!");
			}
			else if(input == 5)
			{
				//not comeplete, needs the choose how many passengers feature to be working, and the drive stuff to have a correlation with food.
				//Also, its pretty annoying to have to pass all of the arguements in, so hopefully that can be fixed.
				//ps1.feed();
				passCheck(ps);
			}
			else if(input == 6)
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
		int quantity = 0;
		int toFeed = 0;
		System.out.println("How many would you like? ");
		quantity = keyboard.nextInt();
		if (food == 1)
		{
			user.pay(15*quantity);
			for (int i = 0; i < ps.length; i++)
				System.out.println(i+1 + ". " + ps[i].getName());
			for(int z = 0; z < quantity; z++)
			{
				System.out.println("Who would you like to feed? Refer to the list above (1 - " + ps.length + "). Remaining - " + (quantity-z));
				toFeed = keyboard.nextInt();
				ps[toFeed-1].feed(foods.get(0));
			}
		}
		else if (food == 2)
		{
			user.pay(20*quantity);
			for (int i = 0; i < ps.length; i++)
				System.out.println(i+1 + ". " + ps[i].getName());
			for(int z = 0; z < quantity; z++)
			{
				System.out.println("Who would you like to feed? Refer to the list above (1 - " + ps.length + "). Remaining - " + (quantity-z));
				toFeed = keyboard.nextInt();
				ps[toFeed-1].feed(foods.get(1));
			}
		}
		else if (food == 3)
		{
			user.pay(5*quantity);
			for (int i = 0; i < ps.length; i++)
				System.out.println(i+1 + ". " + ps[i].getName());
			for(int z = 0; z < quantity; z++)
			{
				System.out.println("Who would you like to feed? Refer to the list above (1 - " + ps.length + "). Remaining - " + (quantity-z));
				toFeed = keyboard.nextInt();
				ps[toFeed-1].feed(foods.get(2));
			}
		}
		else if (food == 4)
		{
			user.pay(20*quantity);
			for (int i = 0; i < ps.length; i++)
				System.out.println(i+1 + ". " + ps[i].getName());
			for(int z = 0; z < quantity; z++)
			{
				System.out.println("Who would you like to feed? Refer to the list above (1 - " + ps.length + "). Remaining - " + (quantity-z));
				toFeed = keyboard.nextInt();
				ps[toFeed-1].feed(foods.get(3));
			}
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
		for (int i = 0; i < ps.length; i++) {
		ps[i].check();
		System.out.println("Food Bar of " + "Passenger " + (i + 1) + ", " + ps[i].getName() + " " + ps[i].getFoodBar() + "/500");
		if(ps[i].getIsDead() == false)
			System.out.println("Status: Alive" ); 
		else
			System.out.println("Status: Dead");
		}

	}
	public static void removeFood(Passenger[] ps, double distance, double speed)
	{
		for (int i = 0; i < ps.length; i++)
		{
			ps[i].eat(distance,speed);
		}
	}
	
	
}