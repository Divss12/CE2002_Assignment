package Main;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class reservation {
    private int pax;
    private int date;
    private int time; //i think there is some library we have to use for date and time
    //customer, table
    
    public getTime() {
    	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	   LocalDateTime now = LocalDateTime.now();  
    	   System.out.println(dtf.format(now));  
    }
    public reservation(int pax, int date, int time, customer patron){
    	
    }

}
