package Main;
import java.util.Scanner;
import java.util.ArrayList;

public class mainApp {
	
	public static void main(String[] args){
		int choice;
		Scanner scan = new Scanner(System.in);

		ArrayList<MenuItem> menu = new ArrayList<MenuItem>;

		//code to read saved menuItems from a file

		ArrayList<Order> orderList = new ArrayList<Order>;
		//code to read saved orders from a file

		ArrayList<Table> tableList = new ArrayList<Table>;
		//code to read saved tables from a file

		ArrayList<Reservation> reservationList = new ArrayList<Table>;
		//code to read saved reservations from a file

		ArrayList<Staff> staffList = new ArrayList<Staff>;
		//code to read saved staff from a file

		while(true){
			System.out.println("Enter your choice: " +
									"\n 1. Create/Update/Remove menu item" +
									"\n 2. Create/Update/Remove promotion" +
									"\n 3. Create Order" +
									"\n 4. View Order" +
									"\n 5. Add/Remove item to/from Order" +
									"\n 6. Create Reservation" +
									"\n 7. Check/Remove Reservation" +
									"\n 8. Change Table availability" +
									"\n 9. Check Table availability" +
									"\n 10. Print order invoice" +
									"\n 11. Print sale revenue report by period" + 
									"\n 12. Exit");

			choice = scan.nextInt();

			switch(choice){
				case 1: //Create/Update/Remove menu item
					System.out.println("Enter your choice:" +
										"\n 1. Create a new menu item" +
										"\n 2. Update an existing menu item" +
										"\n 3. Remove a menu item" +
										"\n 4. Cancel"); 
					int c1 = scan.nextInt();
					switch(c1){
						case 1: 
							menu.createNewItem();
							break;
						case 2: 
							menu.updateItem();
							break;
						case 3: 
							menu.removeItem();
							break;
						case 4:
							break;
						default:
							break;
					}
					break;
					
				case 2: //Create/Update/Remove promotion
					System.out.println("Enter your choice:" +
										"\n 1. Create a new menu item" +
										"\n 2. Update an existing menu item" +
										"\n 3. Remove a menu item" +
										"\n 4. Cancel"); 
					int c2 = scan.nextInt();
					switch(c2){
						case 1:
							menu.createNewPromotion();
							break;
						case 2: 
							menu.updatePromotion();
							break;
						case 3: 
							menu.removePromotion();
							break;
						case 4:
							break;
						default:
							break;
					}
					break;

				case 3: //Create order
					System.out.println("Enter Table no.");
					int tableNumber = scan.nextInt();
					int time = 0; //add code to get time from Calendar class
					System.out.println("Enter Staff ID: ");
					int staffID = scan.nextInt();
					Staff staff;
					for(Staff s : staffList){
						if(s.getID() == staffID){
							staff = s;
							break;
						}
					}
					Order order = new Order(tableNumber, time, staff);
					orderList.add(order);
					break;
				case 4: //View order
					System.out.println("Enter the Table no.:");
					int tableNumber = scan.nextInt();
					for(Order o : orderList){
						if(o.getTableNumber() == tableNumber){
							o.viewOrder();
							break;
						}
					}
					break;
				case 5: //Add/remove item from order
					System.out.println("Enter the Table no.:");
					int tableNumber = scan.nextInt();

					for(Order order : orderList){
						if(order.getTableNumber() == tableNumber){
							System.out.println("Enter your choice:" +
												"\n 1. Add to Order" +
												"\n 2. Remove from Order" +
												"\n 3. Cancel");
							int c3 = scan.nextInt();
							switch(c3){
								case 1:
									System.out.println("Enter dish name: ")
									String name = scan.nextLine();
									MenuItem item;
									for(MenuItem m : menu){
										if(m.getName().equals(name)){
											item = m;
											break;
										}
									}
									System.out.println("Enter Quantity: ");
									int quantity = scan.nextInt();

									order.addToOrder(item, quantity);
									break;
								case 2:
									System.out.println("Enter the index of the item to remove (to remove latest enter -1): ")
									int index = scan.nextInt();
									order.removeFromOrder(index);
									break;
								case 3:
									break;
								default:
									break;
							}
							break;
						}
					}
					break;
				case 6: //Create reservation
					reservations.createNewReservation();
					break;
				case 7: //Check/Remove reservation
					reservations.checkReservation();
					break;
				case 8: //Change table availability
					System.out.println("Enter table no.: ");
					int tableNumber = scan.nextInt();
					System.out.println("Change availability to?" +
										"\n 1. Available" +
										"\n 2. Not Available")
					Boolean newBool = (Boolean) scan.nextInt() - 1;
					
					tableList.get(tableNumber).changeAvailability(newBool);
					
					break;
				case 9: // Check table availibility
					System.out.println("Enter table no.: ");
					int tableNumber = scan.nextInt();
					if(tableList.get(tableNumber).checkAvailability()){
						System.out.println("Currently Available");
					}
					else{
						System.out.println("Currently Unavailable");
					}
					break;
				case 10: //print order invoice
					System.out.println("Enter the Table no.:");
					int tableNumber = scan.nextInt();
					int i = -1;
					for(Order o : orderList){
						i++;
						if(o.getTableNumber() == tableNumber){
							o.printInvoice();
							break;
						}
 					}
					orderList.remove(-1);
					break;
				case 11: //print sales revenue report
					//need to discuss the implementation of this as well
					break;
				case 12: //Exit
					break;
				default:
					break;
			}
		}
		//scan.close();
	}
}



