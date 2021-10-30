package Main;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class Reservation {
    private int pax;
    private int date;
    private int time; //i think there is some library we have to use for date and time
    //customer, table
    
    public void getTime() {
    	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	   LocalDateTime now = LocalDateTime.now();  
    	   System.out.println(dtf.format(now));  
    }
    public Reservation(int pax, int date, int time, Customer patron){
    	
    }

}
