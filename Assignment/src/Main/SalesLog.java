package Main;
import java.util.ArrayList;

public class SalesLog {
	ArrayList<Order> array;
	
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
		System.out.println("SALES REVENUE REPORT\n-----------------\n");
		for(Order o: array) {
			if(o.getMonth() == month) {
				Staff s = o.getServer();
				System.out.println(s.getTitle() + " " + s.getName() + " took order at table number " + o.getTableNumber() + ". The final bill was $" + o.getTotal());
			}
		}
	}
	
	/**
	 * adds Order object to order ArrayList
	 * @param order
	 */
	public void addToLog(Order order) {
		array.add(order);
	}
	
}
