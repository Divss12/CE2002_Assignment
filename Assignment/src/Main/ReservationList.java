package Main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ReservationList {
	ArrayList<Reservation> array;
	
	/**
	 * Constructor for ReservationList
	 * @param rList
	 */
	public ReservationList(ArrayList<Reservation> rList) {
		array = rList;
	}
	
	/**
	 * 
	 * @return Reservation array
	 */
	public ArrayList<Reservation> getArray(){
		return array;
	}
	
	/**
	 * Creates a Reservation object and adds it to tableList if it is
	 * a valid reservation.
	 * @param tableList
	 */
	public void createReservation(ArrayList<Table> tableList) {
		System.out.println("*You can only make reservations for this week.");
		System.out.println("Enter name for the reservation:");
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
	
	/**
	 * Function to remove Reservation object from the Reservation ArrayList
	 */
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
	
	/**
	 * Checks if a reservation has exceeded its allocated time frame (2h)
	 * If it has, the reservation is removed from the reservations file, and
	 * the table is made available.
	 * @param tableList
	 */
	public void checkExpiration(ArrayList<Table> tableList) {
		GregorianCalendar now = new GregorianCalendar();	// Get current time
    	GregorianCalendar old = new GregorianCalendar();
    	for (int i=0;i<array.size();i++) {
    		old = array.get(i).getTime();
    		old.add(Calendar.HOUR_OF_DAY, 2);
    		if (now.after(old)) {	// Remove reservation if more than 2h old
    			Reservation cur = array.get(i);
    			System.out.println("WARNING!!! " + cur.getName() + "'s reservation expired.");
    			GregorianCalendar time = new GregorianCalendar(cur.getYear(), cur.getMonth(), cur.getDay(), cur.getHours(), 0);
       		 	int dayOfWeek = time.get(Calendar.DAY_OF_WEEK);
       		 	int hourOfDay = time.get(Calendar.HOUR_OF_DAY);
    			int tableIdx = array.get(i).getTableNumber();
    			for (Table t:tableList) {
    				if (t.getTableNumber() == tableIdx) {
    					t.freeTimeSlot(((dayOfWeek-1)*12) + (hourOfDay-10));
    					System.out.print(dayOfWeek + ", " + hourOfDay + ": Time slot freed\n");
    				}
    			}
    			array.remove(i);
    		}
    	}
	}
	
}
