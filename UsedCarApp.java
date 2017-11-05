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

		/*
		 * int numberOfNewCarsForSale = 3; int numberOfUsedCarsForSale = 3;
		 */

		int numberOfCarsOfEachType = 3;

		// add cars
		for (int i = 0; i < numberOfCarsOfEachType; i++) {
			carInventory.add(new Car(" NewCarMake_" + (i + 1), "New Model_" + (i+1), 2017, 10000.0));
			carInventory.add(
					new UsedCar(" UsedCarMake_" + (i + 1), "Used Model_" + (i+1), 1986, 10000.0, 500 + i * 10, false, false));
		}


		printInventory(carInventory, carCounter);

		//user makes selection
		userSelection = Validator.getInt(sc, "\nWhich car would you like to purchase? (Enter number) ", 1, (numberOfCarsOfEachType * 2));

		//confirm user selection
		System.out.println(userSelection + "." + carInventory.get((userSelection-1)));
		
		//remove selection from list
		carInventory.remove((userSelection-1));
		
		//reprint inventory
		System.out.println();
		printInventory(carInventory, carCounter);
		
		sc.close();
	}

	/**
	 * @param carInventory
	 * @param carCounter
	 */
	private static void printInventory(ArrayList<Car> carInventory, int carCounter) {
		System.out.printf("%-20s   %-20s %-20s %-20s %-20s %-20s %-20s", "Make", "Model", "Year", "Price", "Mileage", 
				"Water Damage?", "Accidents?");
		System.out.printf("\n%-20s   %-20s %-20s %-20s %-20s %-20s %-20s", "==================", "==============", "==============", "==============", "==============", 
				"==============", "==============");
		System.out.println();
		for (Car car : carInventory) {
			System.out.println(carCounter + "." + car.toString());
			carCounter++;
		}
		System.out.println();
	}
}
