/**
* @author Divyansh
* @version 1.0
* @since 6th November 2021
*/
package Main;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

public class Reservation {
    private int pax;
    private GregorianCalendar time;
    private String name;
    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};    //customer, table
    private int year;
    private int month;
    private int day;
    private int hours;
    private int tableNumber;

    /**
     * Constructor for Reservation
     * @param pax
     * @param name
     * @param year
     * @param month
     * @param day
     * @param hours
     */
    public Reservation(int pax, String name, int year, int month, int day, int hours){
        this.pax = pax;
        this.name = name;
    	this.time = new GregorianCalendar(year, month, day, hours, 0);
    	this.year = year;
    	this.month = month;
    	this.day = day;
    	this.hours = hours;
    }

    ///////////////// MUTATORS ///////////////// 
    /**
     * 
     * @return year
     */
    public int getYear() {
		return year;
	}

    /**
     * 
     * @return month
     */
	public int getMonth() {
		return month;
	}

	/**
	 * 
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 
	 * @return hours
	 */
	public int getHours() {
		return hours;
	}
	
	/**
	 * 
	 * @return tableNumber
	 */
	public int getTableNumber() {
		return this.tableNumber;
	}
	
    /**
     * @return String of all Reservation parameters formatted for reservations.txt
     */
    public String convertToString() {	//name \n $p \n description
    	return name + "\t" + Integer.toString(pax) + "\t" + Integer.toString(this.time.get(Calendar.YEAR)) + "\t" + Integer.toString(this.time.get(Calendar.MONTH)) + "\t" + Integer.toString(this.time.get(Calendar.DATE)) + "\t" + Integer.toString(this.time.get(Calendar.HOUR));
    	// Format: name	pax	YEAR MONTH DATE HOUR MINUTE
    }

	/**
     * @return time
     */
    public GregorianCalendar getTime() {
    	return this.time;
    }
    
    /**
     * 
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Prints name, pax and the date and time (in hours) that the reservation was made
     */
    public void printDetails(){
        System.out.println("Name: " + this.name + ", pax: " + this.pax);
        System.out.println("Date: " + this.time.get(Calendar.DATE) + this.months[this.time.get(Calendar.MONTH)] + ", " + this.time.get(Calendar.YEAR));
        System.out.println("Time: " + this.time.get(Calendar.HOUR) + ":" + this.time.get(Calendar.MINUTE));
    }

    /**
     * Checks if a Reservation was made within a valid time slot [1000-2200)
     * @param tableList
     * @return true if valid
     */
    public boolean isValidReservation(ArrayList<Table> tableList) {
    	for (Table t:tableList) {
    		if (t.reserveTimeSlot(this.time, this.pax)){
    			this.tableNumber = t.getTableNumber();
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * Checks if a reservation has been valid for more that 2 hours
     * @param reservationList
     * @return true if reservation was made more than 2 hours ago
     */
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
	