package Main;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Reservation {
    private int pax;
    private GregorianCalendar time;
    private String name;
    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};    //customer, table

    public Reservation(int pax, String name, int year, int month, int day, int hours, int minutes){
        this.pax = pax;
        this.name = name;
    	this.time = new GregorianCalendar(year, month, day, hours, minutes);
    }

    public String convertToString() {	//name \n $p \n description
    	return name + "\t" + Integer.toString(pax) + "\t" + Integer.toString(this.time.get(Calendar.YEAR)) + "\t" + Integer.toString(this.time.get(Calendar.MONTH)) + "\t" + Integer.toString(this.time.get(Calendar.DATE)) + "\t" + Integer.toString(this.time.get(Calendar.HOUR)) + "\t" + Integer.toString(this.time.get(Calendar.MINUTE));
    	// Format: name	pax	YEAR MONTH DATE HOUR MINUTE
    }

    public String getName(){
        return this.name;
    }

    public void printDetails(){
        System.out.println("Name: " + this.name + ", pax: " + this.pax);
        System.out.println("Date: " + this.time.get(Calendar.DATE) + this.months[this.time.get(Calendar.MONTH)] + ", " + this.time.get(Calendar.YEAR));
        System.out.println("Time: " + this.time.get(Calendar.HOUR) + ":" + this.time.get(Calendar.MINUTE));
    }

    

}
