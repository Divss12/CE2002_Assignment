/**
* @author Divyansh
* @version 1.0
* @since 7th November 2021
*/
package Main;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class OrdersList {
	private ArrayList<Order> array;
	
	public OrdersList() {
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
	 * Prints a list of order for a table
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
				flag = 1;
				break;
			}
		}
		if (flag==1) {
			array.get(tableNumber-1).viewPromoOrder();
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
	
	public void removeFromOrder(int index) {
		System.out.println("Enter index of item to remove (-1 for latest)");
		Scanner scan = new Scanner(System.in);
		int ind = scan.nextInt();
		scan.nextLine(); //Clear input buffer
		array.get(index).removeFromOrder(ind);
	}
	
	/**
	 * Initializes a new order
	 * @param staffList
	 */
	public void createOrder(ArrayList<Staff> staffList) {
		
		System.out.println("Enter Table no.");
		Scanner scan = new Scanner(System.in);
		int tableNumber3 = scan.nextInt();
		scan.nextLine(); //Clear input buffer
		GregorianCalendar time = new GregorianCalendar(); //add code to get time from Calendar class
		System.out.println("Enter Staff ID: ");
		int staffID = scan.nextInt();
		scan.nextLine(); // Clear input buffer
		Staff staff = null;	// Initializing staff
		for(Staff s : staffList){
			if(s.getID() == staffID){
				staff = s;
				System.out.println("Staff found");
				break;
			}
		}
		Order order = new Order(tableNumber3, time, staff);
		array.add(order);
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
