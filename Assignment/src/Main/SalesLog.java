package Main;
import java.util.ArrayList;

public class SalesLog {
	ArrayList<Order> array;
	
	
	public SalesLog(ArrayList<Order> logs) {
		array = logs;
	}
	
	public void printReport(int month) {
		System.out.println("SALES REVENUE REPORT\n-----------------\n");
		for(Order o: array) {
			if(o.getMonth() == month) {
				Staff s = o.getServer();
				System.out.println(s.getTitle() + s.getName() + " took order at table number " + o.getTableNumber() + ". The final bill was $" + o.getTotal());
			}
		}
	}
	
	public void addToLog(Order order) {
		array.add(order);
	}
	
	public ArrayList<Order> getArray(){
		return array;
	}
}
