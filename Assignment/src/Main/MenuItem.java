/**
* @author Zavier
* @version 1.0
* @since 3rd November 2021
*/
package Main;
import java.util.Scanner;
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu
import java.io.FileNotFoundException;
import java.io.IOException;	// Handle errors when editing files

public class MenuItem{
	private String name;
	private String description;
	private double price;
	private int choice;

	Scanner sc = new Scanner(System.in);
	
	/**
	 * MenuItem constructor
	 * @param name
	 * @param description
	 * @param price
	 */
	public MenuItem(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	//////////////////////////////////////// MUTATORS ////////////////////////////////////////
	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * 
	 * @return price
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * 
	 * @param name to set name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param description to set description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @param price to set price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
//////////////////////////////////////// END MUTATORS ////////////////////////////////////////
	/**
	 * Initializes new MenuItem object
	 * @param name
	 * @param description
	 * @param price
	 * @return
	 */
	public MenuItem createNewItem(String name, String description, double price){
    	MenuItem item = new MenuItem(name, description, price);
    	return item;
    }

	/**
	 * Used to update parameters of MenuItem object
	 */
    public void updateItem(){
    	int changes = 0;	// Counter for the number of time item is updated in updateItem
    	do {
	    	System.out.println("Choose which field you want to change\n----------------------------");
	    	System.out.println("[1] Item name");
	    	System.out.println("[2] Item description");
	    	System.out.println("[3] Item price");
	    	System.out.println("[4] Exit.");
    		choice = sc.nextInt();
    		sc.nextLine(); //Clear input buffer
	    	switch(choice) {
	    	case 1:
	    		System.out.println("Enter new item name:");
	    		String n = sc.nextLine();
	    		this.name = n;	// Update MenuItem name
		    	changes++;
	    		break;
	    	case 2:
	    		System.out.println("Enter new item description:");
	    		String d = sc.nextLine();
	    		this.description = d;	// Update MenuItem description
		    	changes++;
	    		break;
	    	case 3:
	    		System.out.println("Enter new item price:");
	    		double p = sc.nextDouble();
	    		sc.nextLine(); //Clear input buffer
	    		this.price = p;	// Update MenuItem price
		    	changes++;
	    		break;
	    	default:
	    		break;
	    	}
    	}while((choice >= 1) && (choice <= 3));
    	
    }
    /**
     * 
     * @return String formatted for each menu item to be written to Menu.txt file
     */
    public String convertToString() {	//name \n $p \n description
    	return name + "\t" + description + "\t" + Double.toString(price);
    }

}
