/**
* @author Zavier
* @version 1.0
* @since 5th November 2021
* Manager class for Promotion package
*/
package Main;
import java.util.Scanner;
import java.util.ArrayList;

public class PromotionMenu {
	Scanner sc = new Scanner(System.in);
	ArrayList<Promotion> promoMenu;
	
	/**
	 * Constructor for PromotionMenu
	 * @param promoMenu
	 */
	public PromotionMenu(ArrayList<Promotion> promoMenu) {
		this.promoMenu = promoMenu;
	}

	/**
	 * 
	 * @return promoMenu ArrayList
	 */
	public ArrayList<Promotion> getArray(){
		return promoMenu;
	}
	
	/**
	 * Creates a new Promotion object and appends in to the menu ArrayList
	 * @param menu
	 * @param name
	 * @param desc
	 * @param price
	 * @return
	 */
	public void createPromotionPackage(ArrayList<MenuItem> menu) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name of the Promotional Set Package:");
		String name = scan.nextLine();
		System.out.println("Enter the description of the Promotional Set Package");
		String desc = scan.nextLine();
		System.out.println("Enter the price of the Promotional Set Package");
		double price = scan.nextDouble();
		scan.nextLine(); //clear input buffer
		
		Promotion item = new Promotion(name, desc, price);
		
		System.out.println("Enter the number of items you want to add to the Promotional Set Package:");
		int numItems = scan.nextInt();
		scan.nextLine(); // Clear input buffer
		String name1;
		int flag = 0;
		for (int i=0;i<numItems;i++) {
			while(flag==0) {
				System.out.println("Enter name of item to be added:");
				name1 = scan.nextLine();
				for (MenuItem m:menu) {
					if (m.getName().equals(name1)) {
						item.addItemToPromotion(m);
						flag++;
						break;
					}
				}
				if (flag==0) {
					System.out.println("Item not found. Please enter again.");
				}
			}
		}
		
		
		promoMenu.add(item);	//Add promo item to promoMenu arraylist
		//return promoMenu.size() - 1;
	}

	/**
	 * Appending a MenuItem object to the promoMenu ArrayList 
	 * @param item
	 * @param lastIdx
	 */
	public void addToPromoPackage(MenuItem item, int lastIdx) {
		promoMenu.get(lastIdx).addItemToPromotion(item);
	}

	/**
	 * Updates the parameters of a Promotion object in the promoMenu ArrayList 
	 * @param menu
	 * @return
	 */
	public boolean updatePromotionPackage(ArrayList<MenuItem> menu) {
		 	int pidx = 0;
	
		 	displayPromotionPackage();
			System.out.println("Enter the name of the package you want to modify:");
			String packageName = sc.nextLine();
	
			//sc.nextLine(); // Clear input buffer
			for (Promotion item:this.promoMenu) {
				if (packageName.equals(item.getName())) {
					break;
				}else {
					pidx++;	// Idx of package in promotionMenu
				}
			}
			if (pidx==promoMenu.size()) {	// Exit if idx out of bounds
				System.out.println("Promotion package not found.");
				return false;
			}
			System.out.println("Enter your choice:" +
					"\n 1. Remove an item from the package" +
					"\n 2. Add an item to the package" +
					"\n 3. Update the name/price/description of the package" +
					"\n 4. Cancel");
			int choice1234 = sc.nextInt();
			if (promoMenu.size()>0) {
			switch(choice1234){
				case 1: //remove an item from the package
					int ii = 0;	
					if (promoMenu.get(pidx).array.size()<1) {	// Break if array of menuitems is empty
						System.out.println("There are no items in the promotional package. Deleting the package...");
						promoMenu.remove(pidx); // Removing targetted empty promotion packages from promotionMenu
						break;
					}
					displayPackageContents(packageName);	// Displays package contents of packageName
					
					System.out.println("Enter the name of the item to be removed from the package:");
					sc.nextLine(); // Clear input buffer
					String itemName = sc.nextLine();
					for (MenuItem item:promoMenu.get(pidx).array) {
						if ((item.getName()).equals(itemName)) {
							break;
						}
						ii++;
					}
					if (ii==promoMenu.get(pidx).array.size()) {
						System.out.println("Item not in Promotion package " + promoMenu.get(pidx).getName());
						break;
					}
					System.out.println(promoMenu.get(pidx).array.get(ii).getName() + " removed from Promotion package " + promoMenu.get(ii).getName());
					promoMenu.get(pidx).array.remove(ii);
					break;
				case 2:
					System.out.println("Enter the name of the item you want to add to the package:");
					sc.nextLine(); // Clear input buffer
					String itemName2 = sc.nextLine();
					for (MenuItem m:menu) {
						if (m.getName().equals(itemName2)) {
							promoMenu.get(pidx).addItemToPromotion(m);
						}
					}
					break;
				case 3:
					promoMenu.get(pidx).updateInfo();
					break;
				default:
					break;
			} 
			}else {
				System.out.println("There are no packages to update.");
			}
		return true;
	 }
	
	/**
	 * Removes a Promotion object from the promoMenu ArrayList
	 * @param menu
	 */
	public void removePromotionPackage(ArrayList<MenuItem> menu) {
		int i = 0; // Idx counter for promotionMenu
	 	displayPromotionPackage();
		System.out.println("Enter name of package you want to remove:");
		String packageName = sc.nextLine();
		for (Promotion item:this.promoMenu) {
			if (packageName.equals(item.getName())) {
				this.promoMenu.remove(i);
				return;
			}else {
				i++;	// Idx of package in promotionMenu
			}
		}
		System.out.println(packageName + " does not exist.");
	}

	/**
	 * Prints a list of the name parameters of all Promotion objects in promoMenu ArrayList
	 */
	public void displayPromotionPackage() {
		int idx = 0;
		for (Promotion item:this.promoMenu) {
			System.out.println("[" + (idx+1) + "] " + item.getName());
			idx++;
		}
		System.out.println("-----------------------------------------------------");
	}
	
	/**
	 * Prints a list of all the parameters of all MenuItem objects stored in the array 
	 * parameter of a Promotion object  
	 * @param packageName
	 */
	public void displayPackageContents(String packageName) {
		int i = 0;
		for (Promotion p:promoMenu) {
			if (packageName.equals(p.getName())) {
				System.out.printf("[" + (i+1) + "] ");
				System.out.println(p.array.get(i).getName() + "\t"
						   + "$" + p.array.get(i).getPrice() + "\n"
			   + "Description: " + p.array.get(i).getDescription());
				
			}
			i++;
		}
		System.out.println("-----------------------------------------------------");
	}
}
 

