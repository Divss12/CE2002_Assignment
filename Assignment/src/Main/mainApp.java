/**
 * @author Divyansh
 * @version 1.0
 * @since 31st October 2021
 */
package Main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.io.File;

public class mainApp{
	
	public static void main(String[] args){
		/***
		 * @param choice
		 * User input for menu choice
		 */
		int choice;
		
		Scanner scan = new Scanner(System.in);
		
		File file = new File(".");
		for(String fileNames : file.list()) System.out.println(fileNames);
		
		
		//Assigning file paths for menu, tables, reservations, promos
		//Create the files at the assigned directory 
		String menuPath = ".\\Main\\menu.txt";
		String tablePath = ".\\Main\\tables.txt";
		String reservationPath = ".\\Main\\reservations.txt";
		String promoPath = ".\\Main\\promos.txt";
		String logPath = ".\\Main\\log.txt";
		String staffPath = ".\\Main\\staff.txt";
		EditFile menuFile = new EditFile(menuPath);
		EditFile tableFile = new EditFile(tablePath);
		EditFile reservationFile = new EditFile(reservationPath); 
		EditFile promoFile = new EditFile(promoPath); 
		EditFile logFile = new EditFile(logPath);

		EditFile staffFile = new EditFile(staffPath);
		
		//Create arrays for orders, reservations and promotions.
		//Then, read their respective files and store the data in the array.
		Menu menu = new Menu();	// Creating new menu
		menuFile.readMenuFromFile(menu.getArray());	// Reading menu.txt and storing contents into menu arraylist
		
		OrdersList ordersList = new OrdersList();	
		
		ArrayList<Table> tableList = new ArrayList<Table>();	
		tableFile.readTablesFromFile(tableList);
		
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();		
		reservationFile.readReservationsFromFile(reservationList);
		ReservationList rList = new ReservationList(reservationList);
		
		ArrayList<Promotion> promotionMenu = new ArrayList<Promotion>();
		promoFile.readPromotionsFromFile(promotionMenu, menu.getArray());

		//the pMenu object is used to perform actions on the promotionMenu array,
		//including update, add, remove and display.
		PromotionMenu pMenu = new PromotionMenu(promotionMenu);
		ArrayList<Staff> staffList = new ArrayList<Staff>(); 
		staffFile.readStaffFromFile(staffList);
		
		//Create a SalesLog object to log each transaction
		//Use logPath parameter to know which file to read/write
		ArrayList<Order> logArray = new ArrayList<Order>();
		logFile.readLogsFromFile(logArray, staffList, menu.getArray(), promotionMenu);
		SalesLog log = new SalesLog(logArray);
		
		do{
			
			///////////////////// Check if Reservation has expired /////////////////////
	    	GregorianCalendar now = new GregorianCalendar();	// Get current time
	    	GregorianCalendar old = new GregorianCalendar();
	    	for (int i=0;i<reservationList.size();i++) {
	    		old = reservationList.get(i).getTime();
	    		old.add(Calendar.HOUR_OF_DAY, 2);
	    		if (now.after(old)) {	// Remove reservation if more than 2h old
	    			System.out.println("WARNING!!! " + reservationList.get(i).getName() + "'s reservation expired.");
	    			reservationList.remove(i);
	    		}
	    	}
	    	
			System.out.println("Enter your choice: " +
									"\n 1. View/Create/Update/Remove menu item" +
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
									"\n 12. Print list of Staff" +
									"\n 13. Exit");

			choice = scan.nextInt();

			switch(choice){
				case 1: //Create/Update/Remove menu item
					System.out.println("Enter your choice:" +
										"\n 1. Create a new menu item" +
										"\n 2. Update an existing menu item" +
										"\n 3. Remove a menu item" +
										"\n 4. Display the menu" +
										"\n 5. Cancel"); 
					int c1 = scan.nextInt();
					switch(c1){
						case 1: 
							menu.createMenuItem();
							break;
						case 2: 
							menu.updateMenuItem();
							break;
						case 3: 
							menu.removeItem();
							break;
						case 4:
							menu.viewMenu();
						default:
							break;
					}
					
				case 2: //Create/Update/Remove promotion
					String name;
					String desc;
					double price;
					System.out.println("Enter your choice:" +
										"\n 1. Create a new promotion package" +
										"\n 2. Update an existing promotion package" +
										"\n 3. Remove a promotion package" +
										"\n 4. Display all promotion packages" +
										"\n 5. Cancel"); 
					int c2 = scan.nextInt();
					scan.nextLine(); // Clear input buffer

					switch(c2){

						case 1: // Create New Item
							System.out.println("Enter name of the Promotional Set Package:");
							name = scan.nextLine();
							System.out.println("Enter the description of the Promotional Set Package");
							desc = scan.nextLine();
							System.out.println("Enter the price of the Promotional Set Package");
							price = scan.nextDouble();

							int lastIdx = pMenu.createPromotionPackage(menu.getArray(), name, desc, price);
							System.out.println("Enter the number of items you want to add to the Promotional Set Package:");
							int numItems = scan.nextInt();
							scan.nextLine(); // Clear input buffer
							String name1;
							int flag = 0;
							for (int i=0;i<numItems;i++) {
								while(flag==0) {
									System.out.println("Enter name of item to be added:");
									name1 = scan.nextLine();
									for (MenuItem m:menu.getArray()) {
										if (m.getName().equals(name1)) {
											pMenu.addToPromoPackage(m, lastIdx);
											flag++;
											break;
										}
									}
									if (flag==0) {
										System.out.println("Item not found. Please enter again.");
									}
								}
							}
							break;
						case 2: 
							boolean check;
							check = pMenu.updatePromotionPackage(menu.getArray());
							if (!check) break;
							break;
						case 3:
							pMenu.removePromotionPackage(menu.getArray());
						case 4:
							pMenu.displayPromotionPackage();
							break;
						default:
							break;
					}
					break;

				case 3: //Create order
					ordersList.createOrder(staffList);
					break;
				case 4: //View order
					ordersList.viewOrder();
					break;
				case 5: //Add/remove item from order
					System.out.println("Enter Table Number:");
					int ind = ordersList.findOrder(scan.nextInt());
					if(ind == -1) {
						System.out.println("Not Found");
						break;
					}
					System.out.println("Enter your choice:" +
												"\n 1. Add to Order" +
												"\n 2. Add Promotional Package to Order" +
												"\n 3. Remove from Order" +
												"\n 4. Cancel");
					int c3 = scan.nextInt();
					switch(c3) {
						case 1: //Add to Order
							ordersList.addToOrder(menu.getArray(), ind);
							break;
						case 2: //Add promo pkg to order
							ordersList.addPromoToOrder(promotionMenu, ind);
							break;
						case 3: //remove from order
							ordersList.removeFromOrder(ind);
							break;
							
					}
					break;
				case 6: //Create reservation
					rList.createReservation(tableList);
					break;
				case 7: //Check/Remove reservation
					rList.editReservation();
					break;
				case 8: //Change table availability
					int boolCheck;				
					boolean newBool;
					System.out.println("Enter table no.: ");
					int tableNumber8 = scan.nextInt();
					System.out.println("Change availability to?" +
										"\n 1. Available" +
										"\n 2. Not Available");
					if ((boolCheck= scan.nextInt() - 1) > 0) {
						newBool = true;
					}else {
						newBool = false;
					}
					
					tableList.get(tableNumber8).changeAvailability(newBool);
					
					break;
				case 9: // Check table availibility
					System.out.println("Enter table no.: ");
					int tableNumber9 = scan.nextInt();	// (Reason 1)
					if(tableList.get(tableNumber9).checkAvailability()){
						System.out.println("Currently Available");
					}
					else{
						System.out.println("Currently Unavailable");
					}
					break;
				case 10: //print order invoice
					System.out.println("Enter the Table no.:");
					int index = ordersList.findOrder(scan.nextInt());
					Order out = ordersList.printInvoice(index);
					log.addToLog(out);
					break;
				case 11: //print sales revenue report
					System.out.println("Enter which month you want to view the report for: ");
					int month1 = scan.nextInt() - 1;
					log.printReport(month1);
					break;
				case 12:
					int idx = 1;	
					for (Staff staff:staffList) {
						System.out.println("[" + idx + "] Staff name:" + staff.getName() + ", " + staff.getGender());
						System.out.println("   ID:" + staff.getID() + ", Job Title: " + staff.getJobTitle());
						idx++;
					}
				default:	//Exit
					System.out.println("Restaurant reservation app terminated.");
					break;
			}
			//code to save entire array
			menuFile.WriteMenuToFile(menu.getArray(), ".\\Main\\menu.txt");
			tableFile.WriteTablesToFile(tableList, tablePath);
			reservationFile.WriteReservationsToFile(reservationList, reservationPath);
			promoFile.writePromoMenu(promotionMenu, promoPath);
			logFile.writeLogs(log.getArray(), logPath);

			
		}while(choice>0 && choice <13);
		scan.close();
	}
}
