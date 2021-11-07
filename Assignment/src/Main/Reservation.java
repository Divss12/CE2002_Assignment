package Main;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

public class Reservation {
    private int pax;
    private GregorianCalendar time;
    private String name;
    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};    //customer, table

    public Reservation(int pax, String name, int year, int month, int day, int hours){
        this.pax = pax;
        this.name = name;
    	this.time = new GregorianCalendar(year, month, day, hours, 0);
    }

    public String convertToString() {	//name \n $p \n description
    	return name + "\t" + Integer.toString(pax) + "\t" + Integer.toString(this.time.get(Calendar.YEAR)) + "\t" + Integer.toString(this.time.get(Calendar.MONTH)) + "\t" + Integer.toString(this.time.get(Calendar.DATE)) + "\t" + Integer.toString(this.time.get(Calendar.HOUR));
    	// Format: name	pax	YEAR MONTH DATE HOUR MINUTE
    }

    public GregorianCalendar getTime() {
    	return this.time;
    }
    
    public String getName(){
        return this.name;
    }

    public void printDetails(){
        System.out.println("Name: " + this.name + ", pax: " + this.pax);
        System.out.println("Date: " + this.time.get(Calendar.DATE) + this.months[this.time.get(Calendar.MONTH)] + ", " + this.time.get(Calendar.YEAR));
        System.out.println("Time: " + this.time.get(Calendar.HOUR) + ":" + this.time.get(Calendar.MINUTE));
    }

    public boolean isValidReservation(ArrayList<Table> tableList) {
    	for (Table t:tableList) {
    		if (t.reserveTimeSlot(this.time, this.pax)){
    			return true;
    		}
    	}
    	return false;
    }

    public boolean checkExpiration(ArrayList<Reservation> reservationList) {
    	GregorianCalendar now = new GregorianCalendar();	// Get current time
    	GregorianCalendar old = new GregorianCalendar();
    	for (int i=0;i<reservationList.size();i++) {
    		old = reservationList.get(i).getTime();
    		old.add(reservationList.get(i).getTime().HOUR_OF_DAY, 2);
    		if (old.after(now)) {	// Remove reservation if more than 2h old
    			System.out.println(reservationList.get(i).getName() + "'s reservation expired.");
    			reservationList.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
}
	