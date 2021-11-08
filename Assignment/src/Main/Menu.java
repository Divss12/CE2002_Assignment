package Main;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private MenuItem item;
	private ArrayList<MenuItem> menu;
	Scanner sc = new Scanner(System.in);
	
	public Menu() {
		this.menu = new ArrayList<MenuItem>();
	}
	
	/////////// Functions to work with menu ArrayList //////////////
	public void removeItem() {
		System.out.println("Enter name of item you want to remove:");
		String newName3 = sc.nextLine();
		for (int i=0;i<menu.size();i++) {
			if (menu.get(i).getName().equals(newName3)) {
				System.out.println(menu.get(i).getName() + " removed from menu.");
				menu.remove(i);	// Remove target menuItem from menu arraylist
				break;
			}else if (i==(menu.size()-1)) {
				System.out.println("Target item does not exist.");
			}
		}
	}
	public void createMenuItem() {
		System.out.println("Enter item name:");
		String n = sc.nextLine();
		System.out.println("Enter item description:");
		String d = sc.nextLine();
		System.out.println("Enter item price:");
		double p = sc.nextDouble();
		sc.nextLine(); //Clear input buffer
		MenuItem m = new MenuItem(n,d,p);
		menu.add(m);	// Add newly created item to menu arraylist
		System.out.println(n + " added to menu.");
	}
	
	public void updateMenuItem() {
		System.out.println("Enter name of item you want to update:");
		String newName = sc.nextLine();
		for (MenuItem menuItem: menu) {
			if (menuItem.getName().equals(newName)) {
				System.out.println(newName + " updated.");
				menuItem.updateItem();
				return;
			}
		}
		System.out.println("Menu item not found.");
	}
	
	public void viewMenu() {
		System.out.println("Name\t\t\t\t\tPrice");
		for(MenuItem m: menu) {
			System.out.println(m.getName() + "\t\t\t\t\t" + m.getPrice());
		}
	}
	public ArrayList<MenuItem> getArray(){
		return this.menu;
	}
	
	public int getSize() {
		return this.menu.size();
	}
}
