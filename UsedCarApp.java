import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Tim Johnson Grand Circus 11/3/17 Lab 10
 *
 */
public class UsedCarApp {
	/**
	 * Application will 1. display at least 6 cars (at least 3 new, 3 old) 2. let
	 * user select one of the cars 3. re-display information for car selected 4. ask
	 * user if they want to buy the car, if yes, remove the car 5. re-display the
	 * list
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Car> carInventory = new ArrayList<Car>();
		Scanner sc = new Scanner(System.in);
		
		int userSelection = 0;
		int carCounter = 1;
		boolean repeat = true;
		double inventoryValue = 0.0;

		// initialize the number of new and used cars to begin with
		int numberOfCarsOfEachType = 1;

		// add cars
		for (int i = 0; i < numberOfCarsOfEachType; i++) {
			carInventory.add(new Car(" NewCarMake_" + (i + 1), "New Model_" + (i + 1), 2017, 10000.0));
			carInventory.add(new UsedCar(" UsedCarMake_" + (i + 1), "Used Model_" + (i + 1), 1986, 3000.0, 500 + i * 10,
					false, false));
		}

		// calculate inventory value
		for (Car car : carInventory) {
			inventoryValue += car.getPrice();
		}

		while (repeat) {
			
			printInventoryConsole(carInventory, carCounter);

			// user makes selection
			userSelection = Validator.getInt(sc, "\nWhich car would you like to purchase? (Enter number) ", 1,
					carInventory.size() + 1);

			// confirm user selection
			if (userSelection <= carInventory.size()) {
				System.out.println(userSelection + "." + carInventory.get((userSelection - 1)) + "\n");

				// remove selection from list
				carInventory.remove((userSelection - 1));

				// determine if there are any cars left, exit if there are none
				if (carInventory.size() == 0) {
					System.out.println("\n**************************************");
					System.out.printf(
							"Woo! We just made $%.0f!!!! Time to retire! \n\n$$$ \"We in da money! We in da money!\" $$$ \n\n :-) \n\n :-D \n\n \"Dolla dolla bills, y'all!\"",
							inventoryValue);
					repeat = false;
				}

			} else { // if user selects a number greater than the amount of cars, exit program
				System.out.println("\n**************************************");
				System.out.println("\n\"Well thanks for stopping by. Please take a business card in case you have any questions.\"");
				repeat = false;
			}
		}

		sc.close();
	}

	/**
	 *Print the console: header, inventory, exit choice
	 * 
	 * @param carInventory
	 * @param carCounter
	 */
	private static void printInventoryConsole(ArrayList<Car> carInventory, int carCounter) {

		// print inventory header
		System.out.printf("%-20s   %-20s %-20s %-20s %-20s %-20s %-20s", "Make", "Model", "Year", "Price", "Mileage",
				"Water Damage?", "Accidents?");
		System.out.printf("\n%-20s   %-20s %-20s %-20s %-20s %-20s %-20s", "==================", "==============",
				"==============", "==============", "==============", "==============", "==============");

		// print car inventory
		System.out.println();
		for (Car car : carInventory) {
			System.out.println(carCounter + "." + car.toString());
			carCounter++;
		}

		// print exit prompt
		System.out.println("\n" + "Press " + carCounter + " to quit.");
		System.out.println();
	}
}
