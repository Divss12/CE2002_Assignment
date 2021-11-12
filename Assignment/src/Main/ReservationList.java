package Main;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationList {
	ArrayList<Reservation> array;
	
	public ReservationList(ArrayList<Reservation> rList) {
		array = rList;
	}
	
	public void createReservation(ArrayList<Table> tableList) {
		System.out.println("Enter name for the reservation");
		//scan.nextLine(); // Clear input buffer
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.println("Enter pax:");
		int pax = scan.nextInt();
		System.out.println("Enter year:");
		int year = scan.nextInt();
		System.out.println("Enter month (1-12):");
		int month = scan.nextInt() - 1;
		System.out.println("Enter day of month (1-31)");
		int date = scan.nextInt();
		System.out.println("Enter hour (10-21)");
		int hour = scan.nextInt();

		Reservation res = new Reservation(pax, name, year, month, date, hour);
		if (res.isValidReservation(tableList)) {
			array.add(res);
		}else {
			System.out.println("Reservation not made.");
		}
	}
	
	public void editReservation() {
		System.out.println("Enter name:");
		Scanner scan = new Scanner(System.in);
		//scan.nextLine(); // Clear input buffer
		String name1 = scan.nextLine();
		int flag = 0;
		int flag1 = 0;
		int counterr = 0;
		for(Reservation r: array){
			if(r.getName().equals(name1)){
				flag = 1;
				r.printDetails();
				System.out.println("Remove Reservation (Y/N)?");
				String C = scan.nextLine();
				if(C.equals("Y")){
					flag1++;
					break;
				}
			}
			counterr++;
		}
		if (flag1>0)
		{
			System.out.println(name1 + "'s reservation has been removed.");
			array.remove(counterr);
		}
		if(flag == 0){
			System.out.println("Name not found");
		}
	}
	
}
