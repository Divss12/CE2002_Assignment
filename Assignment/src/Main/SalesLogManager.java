/**
* @author Divyansh
* @version 1.0
* @since 10th November 2021
*/
package Main;
import java.util.ArrayList;

public class SalesLogManager {
	private ArrayList<Order> array;
	private FileManager file;
	private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	/**
	 * Constructor for SalesLog
	 * @param logs
	 */
	public SalesLogManager(String path) {
		array = new ArrayList<Order>();
		file = new FileManager(path);
	}
	
	/**
	 * Reads from file
	 * @param staff
	 * @param menu
	 * @param promos
	 */
	public void readFromFile(ArrayList<Staff> staff, ArrayList<MenuItem> menu, ArrayList<Promotion> promos) {
		file.readLogsFromFile(array, staff, menu, promos);
	}
	
	/**
	 * 
	 * @return Order ArrayList
	 */
	public ArrayList<Order> getArray(){
		return array;
	}
	
	/**
	 * Prints the monthly sales report
	 * @param month
	 */
	public void printReport(int month) {
		String out = "| Month: " + months[month];
		System.out.println("----------------------------------------");
		System.out.println("|         SALES REVENUE REPORT          |");
		System.out.println("|---------------------------------------|");
		System.out.println(out + " ".repeat(40 - out.length()) + "|");
		System.out.println("|---------------------------------------|");
		System.out.println("|   | Date | Staff Name    | Total      |");
		System.out.println("|---|------|---------------|------------|");
		
		int i = 0;
		String idx, day, name, total;
		for(Order o: array) {
			if(o.getMonth() == month) {
				idx = Integer.toString(i);
				day = Integer.toString(o.getDay());
				name = o.getServer().getName();
				total = Double.toString(o.getTotal());
				
				int dec = total.length() - total.indexOf(".") - 1;
		    	if(dec > 2) {
		    		total = total.substring(0, total.length() - dec + 2);
		    	}
		    	else if (dec < 2) {
		    		total = total + "0".repeat(2 - dec);
		    	}
				
				if(day.length() == 1) {
					day = "0" + day;
				}
				
				//System.out.println(idx + name + total);
				System.out.println("| " + idx + " ".repeat(2 - idx.length()) + "| " + day + " ".repeat(3) + "| " + name + " ".repeat(14 - name.length()) + "| $" + total + " ".repeat(10 - total.length()) + "|");
				
						
				i++;
			}
		}
		System.out.println("-----------------------------------------");
	}
	
	/**
	 * Writes to file
	 */
	public void writeToFile(String path) {
		file.writeLogs(array, path);
	}
	
	/**
	 * adds Order object to order ArrayList
	 * @param order
	 */
	public void addToLog(Order order) {
		array.add(order);
	}
	
}
