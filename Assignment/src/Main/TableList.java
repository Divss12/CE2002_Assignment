/**
 * @author Divyansh
 * @version 1.0
 * @since 12th November 2021
 */
package Main;
import java.util.ArrayList;
import java.util.Scanner;

public class TableList {
	ArrayList<Table> array;
	
	/**
	 * Constructor for TableList
	 * @param tList
	 */
	public TableList(ArrayList<Table> tList) {
		array = tList;
	}
	
	/**
	 * Asks for table number and tries to change it to occupied for the slot corresponding to the current time
	 */
	public void changeAvailability() {
		System.out.println("Enter table no.: ");
		Scanner scan = new Scanner(System.in);
		int tableNumber = scan.nextInt();
		scan.nextLine(); // clear input buffer
		if(array.get(tableNumber).occupy()) {
			System.out.println("Table " + Integer.toString(tableNumber) + "Occupied");
		}
		else {
			System.out.println("Table could not be occupied");
		}
		
	}
	
	/**
	 * Asks for table number and prints the availability
	 */
	public void checkAvailability() {
		System.out.println("Enter table no.: ");
		Scanner scan = new Scanner(System.in);
		int tableNumber = scan.nextInt();
		scan.nextLine(); // clear input buffer
		if(array.get(tableNumber).checkAvailability()){
			System.out.println("Currently Available");
		}
		else{
			System.out.println("Currently Unavailable");
		}
	}
	
	/**
	 * returns the ArrayList
	 * @return ArrayList<Table> containing all tables
	 */
	public ArrayList<Table> getArray(){
		return array;
	}
	
	

}
