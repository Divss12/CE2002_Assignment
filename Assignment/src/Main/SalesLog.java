/**
* @author Divyansh
* @version 1.0
* @since 10th November 2021
*/
package Main;
import java.util.ArrayList;

public class SalesLog {
	ArrayList<Order> array;
	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	/**
	 * Constructor for SalesLog
	 * @param logs
	 */
	public SalesLog(ArrayList<Order> logs) {
		array = logs;
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
		System.out.println("-------------------------------------");
		System.out.println("|       SALES REVENUE REPORT        |");
		System.out.println("|-----------------------------------|");
		System.out.println(out + " ".repeat(36 - out.length()) + "|");
		System.out.println("|-----------------------------------|");
		System.out.println("|   | Date | Staff Name    | Total  |");
		System.out.println("|---|------|---------------|--------|");
		
		int i = 0;
		String idx, day, name, total;
		for(Order o: array) {
			if(o.getMonth() == month) {
				idx = Integer.toString(i);
				day = Integer.toString(o.getDay());
				name = o.getServer().getName();
				total = Double.toString(o.getTotal());
				
				if(day.length() == 1) {
					day = "0" + day;
				}
				
				System.out.println("| " + idx + " ".repeat(2 - idx.length()) + "| " + day + " ".repeat(3) + "| " + name + " ".repeat(14 - name.length()) + "| $" + total + " ".repeat(6 - total.length()) + "|");
				
						
				i++;
			}
		}
		System.out.println("-------------------------------------");
	}
	
	/**
	 * adds Order object to order ArrayList
	 * @param order
	 */
	public void addToLog(Order order) {
		array.add(order);
	}
	
}
