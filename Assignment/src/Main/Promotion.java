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

    public void addItemToPromotion(MenuItem item){
        this.array.add(item);
    }

    public void updateInfo() {
    	System.out.println("[1] Update item name");
    	System.out.println("[2] Update item description");
    	System.out.println("[3] Update item price\nPress any button to exit without updating");
    	int c = sc.nextInt();
    	switch(c) {
    	case 1:
    		System.out.println("Enter new item name:");
    		String n = sc.nextLine();
    		this.name = n;

    		break;
    	case 2:
    		System.out.println("Enter new item description:");
    		String d = sc.nextLine();
    		this.description = d;
    		System.out.println("Item description updated.");
    		break;
    	case 3:
    		System.out.println("Enter new item description:");
    		double p = sc.nextDouble();
    		this.price = p;
    		System.out.println("Item price updated.");
    		break;
    	default:
    		System.out.println("Cancelling update...");
    		break;
    	}
    }
    
}