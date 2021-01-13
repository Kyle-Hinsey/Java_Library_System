// MP2, Kyle Hinsey, CIS 340, TTh 3:00

// imports
import java.util.Scanner;
import java.util.ArrayList;

public class LibrarySystem {
	
	// fields
	public Scanner scanner = new Scanner(System.in);
	public ArrayList<Device> deviceList = new ArrayList<>();
	
	// add device
	private void addDevice() {
		// variables
		String sku;
		String name;
		Device tmpDevice;
		// header 
		System.out.println("\n\t\t\tLibrary Device Checkout System - Add New Device\n");
		// Enter sku and name
		System.out.print("SKU: ");
		sku = scanner.nextLine().toUpperCase();
		System.out.print("Name: ");
		name = scanner.nextLine();
		// construct device
		tmpDevice = new Device(name, sku);
		// add device to list
		deviceList.add(tmpDevice);
		// device added message
		System.out.printf("Added %s to the catalog.\n\n", name);
	} // end method
	
	// check in devices
	private void checkIn() {
		// variables 
		int counter = 1; // starts at one because there needs to be at least one device
		int deviceNumber;
		//Header
		System.out.println("\n\t\t\tLibrary Device Checkout System - Check In Device\n");
		// header
		System.out.printf("%-2s %-8s %-40s\n", "#", "SKU", "Name" );
		// for each list through device
		for (Device d : deviceList) {
			// check availability
			if (d.getAvailability() == false) {
				System.out.printf("%-2d %-8s %-40s\n", counter, d.getSku(), d.getName());
			} // end if
			//increment counter
			counter++;
		} // end for each
		// enter device number
		System.out.print("Enter device number: ");
		deviceNumber = Integer.parseInt(scanner.nextLine()) - 1;
		deviceList.get(deviceNumber).setAvailability(true);
		// checked in
		System.out.println("Device checked in.");
	} // end method
	
	private void checkOut() {
		// variables 
		int counter = 1; // starts at one because there needs to be at least one device
		int deviceNumber;
		//Header
		System.out.println("\n\t\t\tLibrary Device Checkout System - Check Out Device\n");
		// header
		System.out.printf("%-2s %-8s %-40s\n", "#", "SKU", "Name" );
		// for each list through device
		for (Device d : deviceList) {
			// check availability
			if (d.getAvailability() == true) {
				System.out.printf("%-2d %-8s %-40s\n", counter, d.getSku(), d.getName());
			} // end if
			//increment counter
			counter++;
		} // end for each
		// enter device number
		System.out.print("Enter device number: ");
		deviceNumber = Integer.parseInt(scanner.nextLine()) - 1;
		deviceList.get(deviceNumber).setAvailability(false);
		// checked out
		System.out.println("Device checked out.");
	} // end method
	
	// change device attributes
	private void editDevice() {
		// variables 
		int counter = 1; // starts at one because there needs to be at least one device
		String availability;
		int deviceNumber;
		//Header
		System.out.println("\n\t\t\tLibrary Device Checkout System - Edit Device\n");
		// header
		System.out.printf("%-2s %-8s %-40s\n", "#", "SKU", "Name" );
		// for each list through device
		for (Device d : deviceList) {
			// check availability
			if (d.getAvailability() == false) {
				availability = "Checked Out";
			} // end if
			else {
				availability = "Available";
			} // end else
			System.out.printf("%-2d %-8s %-40s %-12s\n", counter, d.getSku(), d.getName(), availability);
			//increment counter
			counter++;
		} // end for each
		// user selects device 
		System.out.printf("\nEnter device number to edit (1-%d): ", counter - 1);
		deviceNumber = Integer.parseInt(scanner.nextLine()) - 1;
		//Change sku and name
		System.out.print("SKU: ");
		deviceList.get(deviceNumber).setSku(scanner.nextLine());
		System.out.print("Name: ");
		deviceList.get(deviceNumber).setName(scanner.nextLine());
		// information updated
		System.out.println("\nDevice information has been updated.");
	} // end method
	
	// list all devices
	private void listDevice() {
		// variables 
		int counter = 1; // starts at one because there needs to be at least one device
		String availability;
		//Header
		System.out.println("\n\t\t\tLibrary Device Checkout System - List Device\n");
		// header
		System.out.printf("%-2s %-8s %-40s\n", "#", "SKU", "Name" );
		// for each list through device
		for (Device d : deviceList) {
			// check availability
			if (d.getAvailability() == false) {
				availability = "Checked Out";
			} // end if
			else {
				availability = "Available";
			} // end else
			System.out.printf("%-2d %-8s %-40s %-12s\n", counter, d.getSku(), d.getName(), availability);
			//increment counter
			counter++;
		} // end for each
	} // end method
	
	// primary method that shows options for system
	public void loadLibrarySystem() {
		// declared variables
		int input = 0;
		do {
			// Header 
			System.out.println("\n\t\t\tLibrary Device Checkout System\n");
			// Options 
			System.out.println("1. List Device by Title\n2. Add New Devices\n3. Edit Device Information\n4. Search by Device Name\n5. Check Out Devices\n6. Check In Devices\n7. Exit");
			// ask user for input
			input = readInteger("\nSelect menu options 1-7: ");
			// switch on user input
			switch(input) {
			case 1:
				listDevice();
				break;
			case 2:
				addDevice();
				break;
			case 3:
				editDevice();
				break;
			case 4:
				searchDevices();
				break;
			case 5:
				checkOut();
				break;
			case 6:
				checkIn();
				break;
			default:
				System.exit(0);
				break;
			} // end switch
		} while(input != 7);
	} // end method
	
	// search devices by name
	private void searchDevices() {
		// variables 
		int counter = 1; // starts at one because there needs to be at least one device
		String deviceContains = "";
		//Header
		System.out.println("\n\t\t\tLibrary Device Checkout System - Search\n");
		// enter search criteria 
		System.out.print("Enter device to search for: ");
		deviceContains = scanner.nextLine();
		// show listings
		System.out.printf("\nListings for '%s'\n", deviceContains);
		// header
		System.out.printf("%-2s %-8s %-40s\n", "#", "SKU", "Name" );
		// for each list through device
		for (Device d : deviceList) {
			// check availability
			if (d.getName().toLowerCase().contains(deviceContains.toLowerCase())) {
				System.out.printf("%-2d %-8s %-40s\n", counter, d.getSku(), d.getName());
			} // end if
			//increment counter
			counter++;
		} // end for each
	} // end method
	
	public int readInteger(String displayString) {
		// variables
		int numberOfErrors = 0;
		int number = 0;
		boolean repeatInput = false;
		// try to see if correct input
		do {
			try {
			System.out.print(displayString);
			number = Integer.parseInt(scanner.nextLine());
			repeatInput = false;
			}// end try
			catch(NumberFormatException e) {
				// if statement if user has made 2 errors already
				if(numberOfErrors == 2) {
					System.out.println("There are problems entering data, press enter to exit.");
					scanner.nextLine();
					System.exit(0);
				} // end if
				// if user has made less than 2 errors
				System.out.println("The input must be numeric");
				repeatInput = true;
				numberOfErrors++;
			} // end catch
		} while(repeatInput == true);
		//return value
		return number;
	} // end method
		
} // end class










