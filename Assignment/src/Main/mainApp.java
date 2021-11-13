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
		TableList tList = new TableList(tableList);
		
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
	    	rList.checkExpiration(tList.getArray());
	    	
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
					break;
					
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
							pMenu.createPromotionPackage(menu.getArray());
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
												"\n 3. Remove item from Order" +
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
					rList.createReservation(tList.getArray());
					break;
				case 7: //Check/Remove reservation
					rList.checkExpiration(tList.getArray()); // Check if reservation has expired
					rList.editReservation(tList.getArray());
					break;
				case 8: //Change table availability to occupied
					//For walk in
					tList.changeAvailability();
					break;
				case 9: // Check table availability
					tList.checkAvailability();
					break;
				case 10: //print order invoice
					System.out.println("Enter the Table no.:");
					int index = ordersList.findOrder(scan.nextInt());
					Order out = ordersList.printInvoice(index);
					tList.freeTable(out.getTableNumber());
					log.addToLog(out);
					break;
				case 11: //print sales revenue report
					System.out.println("Enter which month you want to view the report for: ");
					int month1 = scan.nextInt() - 1;
					log.printReport(month1);
					break;
				case 12:
					int idx = 1;
					System.out.println("Staff List\n-----------------------------------------------");
					System.out.println("  | Name          | Gender | ID | Job Title");
					System.out.println("--|---------------|--------|----|--------------");
					String n, sname, gender, id, title;
					for (Staff staff:staffList) {
						n = Integer.toString(idx);
						sname = staff.getName();
						gender = staff.getGender();
						id = Integer.toString(staff.getID());
						title = staff.getTitle();
						
						
						System.out.println(n + " ".repeat(2 - n.length()) + "| " + sname + " ".repeat(14 - sname.length()) + "| " + gender + "      | " + id + " ".repeat(3 - id.length()) + "| " + title);
						idx++;
					}
					System.out.println("-----------------------------------------------\n");
					break;
				default:	//Exit
					System.out.println("Restaurant reservation app terminated.");
					break;
			}
			//code to save entire array
			menuFile.WriteMenuToFile(menu.getArray(), menuPath);
			tableFile.WriteTablesToFile(tList.getArray(), tablePath);
			reservationFile.WriteReservationsToFile(rList.getArray(), reservationPath);
			promoFile.writePromoMenu(pMenu.getArray(), promoPath);
			logFile.writeLogs(log.getArray(), logPath);

			
		}while(choice>0 && choice <13);
		scan.close();
	}
}
