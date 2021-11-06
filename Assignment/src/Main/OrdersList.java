package Main;
import java.util.ArrayList;
import java.util.Scanner;

public class OrdersList {
	private ArrayList<Order> array;
	
	public OrdersList() {
		this.array = new ArrayList<Order>();
	}
	
	public int findOrder(int tableNumber) {
		int index = 0;
		for(Order o : array) {
			if(o.getTableNumber() == tableNumber) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public void viewOrder() {
		System.out.println("Enter the Table no.:");
		Scanner scan = new Scanner(System.in);
		int tableNumber = scan.nextInt();
		for(Order o : array){
			if(o.getTableNumber() == tableNumber){
				o.viewOrder();
				break;
			}
		}
	}
	
	public void addToOrder(ArrayList<MenuItem> menu, int index) {
		System.out.println("Enter dish name: ");
		Scanner scan = new Scanner(System.in);
		scan.nextLine(); //Clear input buffer
		String name = scan.nextLine();
		for(MenuItem m : menu){
			if(m.getName().equals(name)){
				System.out.println("Enter Quantity: ");
				int quantity = scan.nextInt();
				(array.get(index)).addToOrder(m, quantity);
				break;
			}
		}
	}
	
	public void addPromoToOrder(ArrayList<Promotion> promoMenu, int index) {
		System.out.println("Enter package name: ");
		Scanner scan = new Scanner(System.in);
		scan.nextLine(); // Clear input buffer
		String name = scan.nextLine();
		for(Promotion p : promoMenu) {
			if(p.getName().equals(name)) {
				System.out.println("Enter Quantity");
				(array.get(index)).orderPromoItem(p, scan.nextInt());
				break;
			}
		}
	}
	
	public void removeFromOrder(int index) {
		System.out.println("Enter index of item to remove (-1 for latest)");
		Scanner scan = new Scanner(System.in);
		int ind = scan.nextInt();
		array.get(index).removeFromOrder(ind);
	}
	
	public void createOrder(ArrayList<Staff> staffList) {
		
		System.out.println("Enter Table no.");
		Scanner scan = new Scanner(System.in);
		int tableNumber3 = scan.nextInt();
		int time = 0; //add code to get time from Calendar class
		System.out.println("Enter Staff ID: ");
		int staffID = scan.nextInt();
		Staff staff = null;	// Initializing staff
		for(Staff s : staffList){
			if(s.getID() == staffID){
				staff = s;
				break;
			}
		}
		Order order = new Order(tableNumber3, time, staff);
		array.add(order);
	}
	
	public void printInvoice(int index) {
		System.out.println("Is the customer a member? (Y/N)");
		Scanner scan = new Scanner(System.in);
		Boolean isMember = false;
		if(scan.nextLine().equals("Y")) {
			isMember = true;
		}
		
		array.get(index).printInvoice(isMember);
		
		array.remove(index);
	}
}
