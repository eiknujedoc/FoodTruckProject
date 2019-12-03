package FoodTruck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodTruckRating {
//	You will create a separate class with a main method that starts the program. 
//	It will have an array to store up to five FoodTruck objects.
//	The main method of this class is the only static method in the entire project.

	static Scanner kb = new Scanner(System.in);
	private static FoodTruck[] vendors = new FoodTruck[5];
	private static boolean running = true;
	private static int vendorId;
	private static double highestVendorRating;
	private Object vendorString;

	public static void main(String[] args) {
		FoodTruckRating ftr = new FoodTruckRating();
		ftr.addVendortoContest(kb);
		ftr.menu();

	}

	public int menu() {
		System.out.println(" GUT TRUCK THROW DOWN ");
		System.out.println("----------------------");
		System.out.println("| 1. ADD VENDOR      |");
		System.out.println("| 2. LIST VENDORS    |");
		System.out.println("| 3. VIEW AVG RATING |");
		System.out.println("| 4. DISPLAY HIGHEST |");
		System.out.println("|    VENDOR RATING   |");
		System.out.println("| 5.  EXIT PROGRAM   |");
		System.out.println("----------------------");

		int userSelection = kb.nextInt();
		switch (userSelection) {
		case 1:
			addVendortoContest(kb);
			break;
		case 2:
			listAllVendors();
			break;
		case 3:
			getAvgVendorRating(vendorString, null);
			break;
		case 4:
			getHighestVendorRating(null);
			break;
		case 5:
			exit();
		default:
		}
		return userSelection;
	}

	public void exit() {

		Runtime.getRuntime().exit(0);
	}

	private void listAllVendors() {
		for (int i = 0; i < vendors.length; i++) {
			System.out.println("Entrant no. " + vendors[i].getIdNumber());
			System.out.print(vendors[i].getName());
			System.out.print(" serving " + vendors[i].getFoodType());
			System.out.println(" and is rated " + vendors[i].getVendorRating() + " out of 5 stars.");
		}
		System.out.println("---------------------------------------");
		return;
	}

	private double getHighestVendorRating(FoodTruck gutTruck) {
		highestVendorRating = vendors[0].getVendorRating();
		String highestRatedVendor = vendors[0].getName();
		for (int i = 0; i < vendors.length; i++) {
			if (vendors[i].getVendorRating() > highestVendorRating) {
				highestVendorRating = vendors[i].getVendorRating();
				highestRatedVendor = vendors[i].getName();
			}
		}
		System.out.println(
				"The highest rated vendor is " + highestRatedVendor + " with a rating of " + highestVendorRating);
		System.out.println("------------------------------");
		menu();
		return highestVendorRating;

	}

//User Story #1
//
//The user is prompted to input the name, food type, and rating for up to five food trucks. For each set of input, a FoodTruck object is created, its fields set to the user's input, and it is added to the array. The truck id is not input by the user, but instead assigned automatically in the FoodTruck constructor from a static field that is incremented as each truck is created.
//User Story #2
//
//If the user inputs quit for the food truck name, input ends immediately and the program continues.
//User Story #3
//
//After input is complete, the user sees a menu from which they can choose to:
//
//    List all existing food trucks.
//    See the average rating of food trucks.
//    Display the highest-rated food truck.
//    Quit the program.
//
//User Story #4
//
//After choosing a menu item, the user sees the menu again and can choose another item until the choose to quit.

	private double getAvgVendorRating(Object ftr, FoodTruck gutTruck) {
		double sum = 0;
		double count = 0;
		for (int i = 0; i < vendors.length; i++) {
			if(vendors[i]==null) {
				break;
			}
			sum += vendors[i].getVendorRating();
			count++;
			}
		double avgVendorRating = (sum / count);
		System.out.println("The average Food Truck rating is " + avgVendorRating);
		System.out.println("-----------------------------------------");
		menu();
		return avgVendorRating;
	}

	public void addVendortoContest(Scanner kb) {

		do {
			FoodTruck gutTruck = new FoodTruck();
			System.out.println("Vendor Name:_");
			String keyword = kb.next();
			if (keyword.equalsIgnoreCase("add")) {
				continue;
			}

			if (keyword.equalsIgnoreCase("quit")) {
				menu();
				break;
			} else {
				gutTruck.setName(keyword);
			}
			vendorId++;
			gutTruck.setIdNumber(vendorId);
			System.out.println("Vendor Food Type:_");
			gutTruck.setFoodType(kb.next());
			System.out.println("Vendor Rating:_");
			gutTruck.setVendorRating(kb.nextDouble());
			for (int i = 0; i < vendors.length; i++) {
				if (vendors[i] == null) {
					vendors[i] = gutTruck;
					break;
				}
			}
			System.out.println(gutTruck.getName() + " SUCCESSFULLY ADDED TO THE CONTEST.");
			System.out.println((gutTruck.getName() + " is assigned contest ID: " + gutTruck.getIdNumber()));
			System.out.println();
			System.out.println("----------------------------");

		} while (running = true);
		return;
	}

}