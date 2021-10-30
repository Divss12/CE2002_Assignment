package Main;

public class AllOrders {

	private Order[] array = new Order[128]; //128 shud be changed later
	private int numOrders;

	public AllOrders(){
		this.numOrders = 0;
	}

	public void createNewOrder(){
		//ask for details of order through print dialog
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
