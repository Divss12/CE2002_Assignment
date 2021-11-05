package Main;
import java.util.Scanner;
import java.util.ArrayList;

public class PromotionMenu {
	Scanner sc = new Scanner(System.in);
	ArrayList<Promotion> promoMenu;
	Promotion promoItem;
	
	public PromotionMenu(ArrayList<Promotion> promoMenu) {
		this.promoMenu = promoMenu;
	}

	
 public void createPromotionPackage(ArrayList<MenuItem> menu, Promotion item) {
		int flag = 0;

		System.out.println("Enter the name of the item you want to add to the Package");
		//sc.nextLine(); // Clear input buffer
		String itemname = sc.nextLine();

		flag = 0;
		for(MenuItem m : menu){
			if(m.getName().equals(itemname)){	// Check if menuitem to be added to promotion package is in menu
				item.addItemToPromotion(m);
				flag = 1;
				break;
			}
		}
		if(flag == 0){
			System.out.println("item does not exist, try again");
		}
		
    }
 
public boolean updatePromotionPackage(ArrayList<MenuItem> menu) {
	 	int pidx = 0;

	 	displayPromotionPackage(menu);
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
			System.out.println("Name not found in Promotion package.");
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
				}
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
public void removePromotionPackage(ArrayList<MenuItem> menu) {
	int i = 0; // Idx counter for promotionMenu
 	displayPromotionPackage(menu);
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

private void displayPromotionPackage(ArrayList<MenuItem> menu) {
	int idx = 0;
	for (Promotion item:this.promoMenu) {
		System.out.println(idx + ") " + item.getName());
		idx++;
	}
	System.out.println("-----------------------------------------------------");
}
}
 

