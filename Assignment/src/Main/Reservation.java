package Main;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu

public class Reservation {
    private int pax;
    private int date;
    private int time; //i think there is some library we have to use for date and time
    private String name;
    //customer, table
    

    //what is this?? 
    public void getTime() {
    	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	   LocalDateTime now = LocalDateTime.now();  
    	   System.out.println(dtf.format(now));  
    }


    public Reservation(int pax, int date, int time, String name){
    	
    }

    public String convertToString() {	//name \n $p \n description
    	return name + "\t" + Integer.toString(pax) + "\t" + Integer.toString(date) + "\t" + Integer.toString(time) + "\n";
    	// Format: name	pax	date time
    }

    

}
