package Main;
import java.util.ArrayList;
import java.util.Scanner;

public class Promotion{
    protected ArrayList<MenuItem> array;
	private String name;
	private String description;
	private double price;
	Scanner sc = new Scanner(System.in);
    
    public Promotion(String n, String d, double p) {
        this.name = n;
        this.description = d;
        this.price = p;
        this.array = new ArrayList<MenuItem>();
    }
    
    public String getName() {
    	return this.name;
    }
    
    public double getPrice() {
    	return this.price;
    }

    public void addItemToPromotion(MenuItem item){
        this.array.add(item);
    }

    public void updateInfo() {
    	System.out.println("[1] Update package name");
    	System.out.println("[2] Update package description");
    	System.out.println("[3] Update package price\nPress any button to exit without updating");
    	int c = sc.nextInt();
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
    		System.out.println("Package price updated from " + this.price + " to " + p);
    		this.price = p;
    		break;
    	default:
    		System.out.println("Cancelling update...");
    		break;
    	}
    }
    
    public String convertToString() {
    	String out = this.name + "\t" + this.description + "\t" + Double.toString(this.price);
    	for(MenuItem m : array) {
    		out = out + "\t" + m.getName();
    	}
    	return out;
    }
    
}