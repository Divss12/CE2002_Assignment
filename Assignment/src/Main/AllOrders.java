package Main;
import java.util.Scanner;


public class AllOrders {

	private Order[] array = new Order[128]; //128 shud be changed later
	private int numOrders;
	private Scanner scan = new Scanner(System.in);

	public AllOrders(){
		this.numOrders = 0;
	}

	public void createNewOrder(){
		//ask for details of order through print dialog
		int tableNumber;
		System.out.println("Enter the Table no.:");
		tableNumber = scan.nextInt();
		int time = 0; //get time from calendar class

		System.out.println("Enter Staff name:");
		//String staffName = 		//TODO




		//create object of order class
		//insert this object into the array
	}

	public void viewOrder(){
		//ask for which table no.
		//search through array for order from that table no.
		//print the details of the order
	}

	public void addToOrder(){
		//ask for which table no.
		//ask for which item and quantity
		//call the addToOrder method of the Order class
	}

	public void removeFromOrder(){
		//ask for which table no.
		//ask for which item to remove
		//probably call some method of the Order class (implement this method)
	}

	public void printInvoice(){
		//ask for which table no.
		//print details of order along with price of items also
	}
}
