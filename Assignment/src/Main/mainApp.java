package Main;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class mainApp{
	
	public static void main(String[] args){
		int choice;
		Scanner scan = new Scanner(System.in);
		
		File file = new File(".");
		for(String fileNames : file.list()) System.out.println(fileNames);
		
		//path names
		String menuPath = ".\\Main\\menu.txt";
		String tablePath = ".\\Main\\tables.txt";
		String reservationPath = ".\\Main\\reservations.txt";
		String promoPath = ".\\Main\\promos.txt";
		
		EditFile menuFile = new EditFile(menuPath);	// Create a Menu File
		EditFile tableFile = new EditFile(tablePath); // Create a Table File
		EditFile reservationFile = new EditFile(reservationPath); // Create a Reservation File
		EditFile promoFile = new EditFile(promoPath); //Create a Promotions file

		Menu menu = new Menu();	// Creating new menu
		menuFile.readMenuFromFile(menu.getArray());	// Reading menu.txt and storing contents into menu arraylist

		OrdersList ordersList = new OrdersList();	

		ArrayList<Table> tableList = new ArrayList<Table>();	
		tableFile.readTablesFromFile(tableList);

		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();		
		reservationFile.readReservationsFromFile(reservationList);
		
		ArrayList<Promotion> promotionMenu = new ArrayList<Promotion>();
		promoFile.readPromotionsFromFile(promotionMenu, menu.getArray());

		ArrayList<Staff> staffList = new ArrayList<Staff>(); //code to read saved staff from a file
		do{
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
							menu.createMenuItem();
							break;
						case 2: 
							menu.updateMenuItem();
							// TODO: Remove MenuItems from RestMenu file
							break;
						case 3: 
							menu.removeItem();
							break;
						default:
							break;
					}
					for (int i=0;i<menu.getSize();i++) {
						//edit.WriteToFile(menu.get(i));	// Writing each menu item in the arraylist to RestMenu file
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
					switch(c2){
						case 1: // Create New Item
							System.out.println("Enter name of the Promotional Set Package:");
							scan.nextLine(); // Clear input buffer
							name = scan.nextLine();
							System.out.println("Enter the description of the Promotional Set Package");
							desc = scan.nextLine();
							System.out.println("Enter the price of the Promotional Set Package");
							price = scan.nextDouble();

							Promotion package1 = new Promotion(name, desc, price);
							PromotionMenu pMenu = new PromotionMenu(promotionMenu);
							pMenu.createPromotionPackage(menu.getArray(), package1);

							promotionMenu.add(package1);
							break;
						case 2: 
							boolean check;
							PromotionMenu pMenu1 = new PromotionMenu(promotionMenu);
							check = pMenu1.updatePromotionPackage(menu.getArray());
							if (!check) break;
							break;
						case 3:
							PromotionMenu pMenu2 = new PromotionMenu(promotionMenu);
							pMenu2.removePromotionPackage(menu.getArray());
						case 4:
							PromotionMenu pMenu3 = new PromotionMenu(promotionMenu);
							pMenu3.displayPromotionPackage(menu.getArray());
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
						case 2: //Add promo pkg to order
							ordersList.addPromoToOrder(promotionMenu, ind);
						case 3: //remove from order
							ordersList.removeFromOrder(ind);
							
					}
					break;
				case 6: //Create reservation
					System.out.println("Enter name for the reservation");
					name = scan.nextLine();
					System.out.println("Enter pax");
					int pax = scan.nextInt();
					System.out.println("Enter year");
					int year = scan.nextInt();
					System.out.println("Enter month (number)");
					int month = scan.nextInt() - 1;
					System.out.println("Enter day of month");
					int date = scan.nextInt();
					System.out.println("Enter hour");
					int hour = scan.nextInt();
					System.out.println("Enter minute");
					int minute = scan.nextInt();

					Reservation res = new Reservation(pax, name, year, month, date, hour, minute);

					//TODO: code to check if reservation is available**
					//if it is then execute the following code
					reservationList.add(res);
					break;
				case 7: //Check/Remove reservation
					System.out.println("Enter name");
					String name1 = scan.nextLine();
					int flag = 0;
					int counterr = 0;
					for(Reservation r: reservationList){
						if(r.getName().equals(name1)){
							flag = 1;
							r.printDetails();
							System.out.println("Remove Reservation (Y/N)?");
							String C = scan.nextLine();
							if(C.equals("Y")){
								reservationList.remove(counterr);
							}
						}
						counterr++;
					}
					if(flag == 0){
						System.out.println("Name not found");
					}
					break;
				case 8: //Change table availability
					int boolCheck;				
					boolean newBool;
					System.out.println("Enter table no.: ");
					int tableNumber8 = scan.nextInt();	// (Reason 1)
					System.out.println("Change availability to?" +
										"\n 1. Available" +
										"\n 2. Not Available");
					//Boolean newBool = (Boolean) scan.nextInt() - 1;
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
					ordersList.printInvoice(index);
					break;
				case 11: //print sales revenue report
					//need to discuss the implementation of this as well
					break;
				default:	//Exit
					System.out.println("Restaurant reservation app terminated.");
					break;
			}
			//code to save entire array
			menuFile.WriteMenuToFile(menu.getArray(), ".\\Main\\menu.txt");
			tableFile.WriteTablesToFile(tableList, tablePath);
			reservationFile.WriteReservationsToFile(reservationList, reservationPath);
			promoFile.WritePromoMenu(promotionMenu, promoPath);
			
			
			
		}while(choice>0 && choice <12);
		//scan.close();
	}
}
