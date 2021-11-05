package Main;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private MenuItem item;
	private ArrayList<MenuItem> menu;
	Scanner sc = new Scanner(System.in);
	
	public Menu(ArrayList<MenuItem> menu) {
		this.menu = menu;
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
}
