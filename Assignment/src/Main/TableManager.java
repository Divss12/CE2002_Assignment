/**
 * @author Divyansh
 * @version 1.0
 * @since 12th November 2021
 */
package Main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class TableManager {
	private ArrayList<Table> array;
	private FileManager file;
	
	/**
	 * Constructor for TableList
	 * @param tList
	 */
	public TableManager(String path) {
		array = new ArrayList<Table>();
		file = new FileManager(path);
	}
	
	/**
	 * Asks for table number and tries to change it to occupied for the slot corresponding to the current time
	 */
	public void changeAvailability() {
		System.out.println("Enter table no.: ");
		Scanner scan = new Scanner(System.in);
		int tableNumber = scan.nextInt();
		scan.nextLine(); // clear input buffer
		if (tableNumber>=array.size()) {
			System.out.println("Table does not exist.");
			return;
		}
		if(array.get(tableNumber).occupy()) {
			System.out.println("Table " + Integer.toString(tableNumber) + " is occupied");
		}
		else {
			System.out.println("Table could not be occupied");
		}
		
	}
	
	/**
	 * Asks for table number and prints the availability
	 */
	public int checkAvailability() {
		System.out.println("Enter table no.: ");
		Scanner scan = new Scanner(System.in);
		int tableNumber = scan.nextInt();
		scan.nextLine(); // clear input buffer
		if (tableNumber>=array.size()) {
			System.out.println("Table does not exist.");
			return 0;
		}
		if(array.get(tableNumber).checkAvailability()){
			System.out.println("Currently Unavailable");
			return 0;
		}
		else{
			System.out.println("Currently Available");
			return 1;
		}
	}
	
	/**
	 * frees table timeSlot[] for the appropriate time
	 * @param tableNumber
	 */
	public void freeTable(int tableNumber) {
		GregorianCalendar now = new GregorianCalendar();
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
		if (hourOfDay >= 10 && hourOfDay < 22) {
			array.get(tableNumber).freeTimeSlot((dayOfWeek-1)*12 + (hourOfDay-10));
		}
	}
	
	/**
	 * Writes to file
	 * @param path
	 */
	public void writeToFile( String path) {
		file.WriteTablesToFile(array, path);
	}
	
	/**
	 * Reads from file
	 */
	public void readFromFile() {
		file.readTablesFromFile(array);
	}
	
	/**
	 * returns the ArrayList
	 * @return ArrayList<Table> containing all tables
	 */
	public ArrayList<Table> getArray(){
		return array;
	}
	
	

}
