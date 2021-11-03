package Main;
import java.util.Scanner;

public class MenuItem{
	private String name;
	private String description;
	private double price;
	private int choice;
	private int changes;	// Counter for the number of time item is updated in updateItem
	Scanner sc = new Scanner(System.in);
	
	public MenuItem(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	//////////////////////////////////////// MUTATORS ////////////////////////////////////////
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
//////////////////////////////////////// END MUTATORS ////////////////////////////////////////
	
	public MenuItem createNewItem(String name, String description, double price){
    	MenuItem item = new MenuItem(name, description, price);
    	return item;
    }

    public void updateItem(){
    	// Ask for the change
    	// Update the file
    	changes = 0;
    	do {
	    	System.out.println("Choose which field you want to change\n----------------------------");
	    	System.out.println("[1] Item name");
	    	System.out.println("[2] Item description");
	    	System.out.println("[3] Item price");
	    	System.out.println("Press any button to exit.");
    		choice = sc.nextInt();
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
	    		this.price = p;	// Update MenuItem price
		    	changes++;
	    		break;
	    	default:
	    		break;
	    	}
    	}while((choice >= 1) && (choice <= 3));
    	
    }
    public String convertToString() {	//name \n $p \n description
    	StringBuilder s = new StringBuilder();
    	s.append(this.name);
    	String p=String.valueOf(price);
    	s.append("\n");
    	s.append("$");
    	s.append(p);
    	return s+"\n"+description;
    }

}
