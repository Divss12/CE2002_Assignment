package Main;
import java.util.ArrayList;
import java.util.Scanner;

public class TableList {
	ArrayList<Table> array;
	
	public TableList(ArrayList<Table> tList) {
		array = tList;
	}
	
	public void changeAvailability() {
		System.out.println("Enter table no.: ");
		Scanner scan = new Scanner(System.in);
		int tableNumber = scan.nextInt();
		scan.nextLine(); // clear input buffer
		if(array.get(tableNumber).occupy()) {
			System.out.println("Table " + Integer.toString(tableNumber) + "Occupied");
		}
		else {
			System.out.println("Table could not be occupied");
		}
		
	}
	
	public void checkAvailability() {
		System.out.println("Enter table no.: ");
		Scanner scan = new Scanner(System.in);
		int tableNumber = scan.nextInt();
		scan.nextLine(); // clear input buffer
		if(array.get(tableNumber).checkAvailability()){
			System.out.println("Currently Available");
		}
		else{
			System.out.println("Currently Unavailable");
		}
	}
	
	public ArrayList<Table> getArray(){
		return array;
	}
	
	

}
