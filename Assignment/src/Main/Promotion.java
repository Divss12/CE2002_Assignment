/**
* @author Zavier
* @version 1.0
* @since 5th November 2021
*/
package Main;
import java.util.ArrayList;
import java.util.Scanner;

public class Promotion implements Item{
    protected ArrayList<MenuItem> array;
	private String name;
	private String description;
	private double price;
	Scanner sc = new Scanner(System.in);
    
	/**
	 * Constructor for Promotion
	 * @param n
	 * @param d
	 * @param p
	 */
    public Promotion(String n, String d, double p) {
        this.name = n;
        this.description = d;
        this.price = p;
        this.array = new ArrayList<MenuItem>();
    }
//////////////////////////////////////// MUTATORS ////////////////////////////////////////
    /**
     * 
     * @return name
     */
    @Override
    public String getName() {
    	return this.name;
    }
    
    /**
     * 
     * @return price
     */
    @Override
    public double getPrice() {
    	return this.price;
    }
    /**
     * 
     *  @return description
     */
    @Override
    public String getDescription() {
    	return this.description;
    }
    
    /**
     * 
     * @param set name as name
     */
    @Override
    public void setName(String name) {
    	this.name = name;
    }
    
    /**
     * 
     * @param set description as desc
     */
    @Override
    public void setDescription(String desc) {
    	this.description = desc;
    }
    
    /**
     * 
     * @param set price as price
     */
    @Override
    public void setPrice(double price) {
    	this.price = price;
    }
//////////////////////////////////////// END MUTATORS ////////////////////////////////////////
    /**
     * Adds MenuItem to Promotion array
     * @param item
     */
    public void addItemToPromotion(MenuItem item){
        this.array.add(item);
    }

    /**
     * Updates package name, description or price
     */
    public void updateInfo() {
    	System.out.println("[1] Update package name");
    	System.out.println("[2] Update package description");
    	System.out.println("[3] Update package price\nPress any button to exit without updating");
    	int c = sc.nextInt();
		sc.nextLine(); // Clear buffer
    	switch(c) {
    	case 1:
    		System.out.println("Enter new package name:");
    		sc.nextLine(); // Clear input buffer
    		String n = sc.nextLine();
    		System.out.println("Package name updated from " + this.name + " to " + n);
    		this.name = n;
    		break;
    	case 2:
    		System.out.println("Enter new package description:");
    		String d = sc.nextLine();
    		System.out.println("Package description updated from " + this.description + " to " + d);
    		this.description = d;
    		break;
    	case 3:
    		System.out.println("Enter new package price:");
    		double p = sc.nextDouble();
    		sc.nextLine(); // Clear buffer
    		System.out.println("Package price updated from " + this.price + " to " + p);
    		this.price = p;
    		break;
    	default:
    		System.out.println("Cancelling update...");
    		break;
    	}
    }
    
    /**
     * 
     * @return String formatted for promos.txt
     */
    public String convertToString() {
    	String out = this.name + "/" + this.description + "/" + Double.toString(this.price);
    	for(MenuItem m : array) {
    		out = out + "/" + m.getName();
    	}
    	return out;
    }
    
}