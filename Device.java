// MP2, Kyle Hinsey, CIS 340, TTh 3:00
public class Device {

	// Fields 
	private boolean availability;
	private String name;
	private String sku;
	
	// constructor
	public Device() {
		// initialize 
		availability = true;
		name = "";
		sku = "";
	} // end constructor
	
	// constructor
	public Device(boolean availability, String name, String sku) {
		// initialize
		this.availability = availability;
		this.name = name;
		this.sku = sku;
	} // end constructor
	
	// constructor
	public Device(String name, String sku) {
		// initialize
		availability = true;
		this.name = name;
		this.sku = sku;
	} // end constructor

	// getter
	public boolean getAvailability() {
		// return value 
		return availability;
	} // end method
	
	// getter
	public String getName() {
		// return value
		return name;
	} // end method
	
	// getter 
	public String getSku() {
		// return value
		return sku;
	} // end method
	
	// setter 
	public void setAvailability(boolean availability) {
		// set value
		this.availability = availability;
	} // end method
	
	//setter
	public void setName(String name) {
		// set value
		this.name = name;
	} // end method
	
	// setter
	public void setSku(String sku) {
		// set value
		this.sku = sku;
	} // end method
	
} // end class

