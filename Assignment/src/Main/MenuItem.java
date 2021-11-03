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
    	int changes = 0;	// Counter for the number of time item is updated in updateItem
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
    	s.append("\t");
    	String p=String.valueOf(price);
    	s.append("$");
    	s.append(p);
    	s.append("\t");
    	return s+"\t"+description;
    }

    public void storeToFile(FileWriter file){	// Format: Name, description, price
    	String data = convertToString();
    	try {
    		file.write(data);
    		System.out.println("Successfully stored to file.");
    	}catch (IOException e) {
			System.out.println("An error occured while storing to file.");
			e.printStackTrace();
    	}
    }
}
