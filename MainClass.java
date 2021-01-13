// MP2, Kyle Hinsey, CIS 340, TTh 3:00

public class MainClass {

	public static void main(String[] args) {
		// declared variables
		LibrarySystem newLibrarySystem = new LibrarySystem();
		// call method
		newLibrarySystem.loadLibrarySystem();
		// close scanner
		newLibrarySystem.scanner.close();
	} // end main

} // end class
