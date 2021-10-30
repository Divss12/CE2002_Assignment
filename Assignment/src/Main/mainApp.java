package Main;
import java.util.Scanner;

public class mainApp {
	
	public static void main(String[] args){
		int choice;
		Scanner scan = new Scanner(System.in);

		Menu menu = new Menu(); //???

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
						case 1: //To be implemented
							menu.createNewItem();
							break;
						case 2: //To be implemented
							menu.updateItem();
							break;
						case 3: //To be implemented
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
						case 1: //To be implemented
							menu.createNewPromotion();
							break;
						case 2: //To be implemented
							menu.updatePromotion();
							break;
						case 3: //To be implemented
							menu.removePromotion();
							break;
						case 4:
							break;
						default:
							break;
					}
					break;

				case 3: //Create order
					//exact implementation to be discussed 
					//should we have an array of current orders
					//or should we make a class containing current orders
					break;
				case 4: //View order
					//see case 3
					break;
				case 5: //Add/remove item from order
					//see case 3
					break;
				case 6: //Create reservation
					// same qn as for orders
					// should we have an array of current reservations
					// or should we make a class containing current reservations
					break;
				case 7: //Check/Remove reservation
					// see case 6
					break;
				case 8: //Change table availability
					// same qn
					break;
				case 9: // Check table availibility
					//
					break;
				case 10: //print order invoice
					//see case 3
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
	}
}



