/**
* @author Divyansh
* @version 1.0
* @since 7th November 2021
*/
package Main;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class OrderManager {
	private ArrayList<Order> array;
	
	/**
	 * Constructor for OrdersList
	 */
	public OrderManager() {
		this.array = new ArrayList<Order>();
	}
	
	/**
	 * @param tableNumber
	 * @return the index of an order from the table with tableNumber
	 */
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
	
	/**
	 * Prints a list of orders for a table
	 */
	public void viewOrder() {
		int flag = 0;
		System.out.println("Enter the Table no.:");
		Scanner scan = new Scanner(System.in);
		int tableNumber = scan.nextInt();
		scan.nextLine(); //Clear input buffer
		for(Order o : array){
			if(o.getTableNumber() == tableNumber){
				o.viewOrder();
				o.viewPromoOrder();
				flag = 1;
				break;
			}
		}
		if (flag==0) {
			System.out.println("This table does not have an order attached to it");
		}
	}
	
	/**
	 * Adds MenuItem objects to order ArrayList
	 * @param menu
	 * @param index
	 */
	public void addToOrder(ArrayList<MenuItem> menu, int index) {
		System.out.println("Enter dish name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		for(MenuItem m : menu){
			if(m.getName().equals(name)){
				System.out.println("Enter Quantity: ");
				int quantity = scan.nextInt();
				scan.nextLine(); // Clear input buffer
				(array.get(index)).addToOrder(m, quantity);
				break;
			}
		}
	}
	
	/**
	 * Removes an Order from the order ArrayList
	 * @param index
	 */
	public void removeFromOrder(int index) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What type of item do you want to remvove?" +
								"\n 1. Menu Item" +
								"\n 2. Promotion Item");
		int choice = scan.nextInt();
		scan.nextLine(); //clear input buffer
		
		System.out.println("Enter index of item to remove (-1 for latest)");
		int ind = scan.nextInt();
		scan.nextLine(); //Clear input buffer
		
		if(choice == 1) {
			array.get(index).removeFromOrder(ind);
		}
		else {
			array.get(index).removePromoFromOrder(ind);
		}
	}
	
	/**
	 * Adds Promotion objects to order ArrayList
	 * @param promoMenu
	 * @param index
	 */
	public void addPromoToOrder(ArrayList<Promotion> promoMenu, int index) {
		System.out.println("Enter package name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		for(Promotion p : promoMenu) {
			if(p.getName().equals(name)) {
				System.out.println("Enter Quantity");
				(array.get(index)).orderPromoItem(p, scan.nextInt());
				scan.nextLine();	// Clear input buffer
				break;
			}
		}
	}
	
	/**
	 * Initializes a new order
	 * @param staffList
	 */
	public void createOrder(ArrayList<Staff> staffList, ArrayList<Table> tableList) {
		
		System.out.println("Enter Table no.");
		Scanner scan = new Scanner(System.in);
		int tableNumber3 = scan.nextInt();
		scan.nextLine(); //Clear input buffer
		if(tableNumber3>=tableList.size()) {
			System.out.println("Table does not exist.");
			return;
		}
		GregorianCalendar time = new GregorianCalendar(); //add code to get time from Calendar class
		System.out.println("Enter Staff ID: ");
		int staffID = scan.nextInt();
		scan.nextLine(); // Clear input buffer
		Staff staff = null;	// Initializing staff
		if (tableList.get(tableNumber3).occupy()) {
			for(Staff s : staffList){
				if(s.getID() == staffID){
					staff = s;
					System.out.println("Staff found");
					break;
				}
			}
			Order order = new Order(tableNumber3, time, staff);
			array.add(order);
		}else {
			System.out.println("Table " + tableNumber3 + " occupied.");
		}
	}
	
	/**
	 * Prints invoice for a table based on their order 
	 * @param index
	 */
	public Order printInvoice(int index) {
		System.out.println("Is the customer a member? (Y/N)");
		Scanner scan = new Scanner(System.in);
		Boolean isMember = false;
		if(scan.nextLine().equals("Y")) {
			isMember = true;
		}
		
		Order out = array.get(index);
		out.printInvoice(isMember);
		array.remove(index);
		return out;
	}
}
