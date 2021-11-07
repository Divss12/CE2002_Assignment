package Main;
import java.io.IOException;	// Handle errors when writing to files
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Table {

    private int tableNumber;
    private boolean occupied;
    private int size;
    private boolean[] timeSlots = new boolean[84];

    public Table(int tableNumber, int size){
        this.tableNumber = tableNumber;
        this.occupied = false;
        this.size = size;
        for (int i=0;i<timeSlots.length;i++) {
        	timeSlots[i] = false;
        }
    }

    public void changeAvailability(boolean newBool){
        this.occupied = newBool;
    }

    public Boolean checkAvailability(){
        return !occupied;
    }

    public String convertToString(){
        return Integer.toString(this.tableNumber); //complete this
    }
    
    public boolean reserveTimeSlot(GregorianCalendar time, int pax) {
    	GregorianCalendar now = new GregorianCalendar();
    	int dayOfWeek;
    	int hourOfDay;
    	if (this.size < pax) {
    		return false;
    	}
    	if (time.get(Calendar.WEEK_OF_YEAR)==now.get(Calendar.WEEK_OF_YEAR)) {
    		 dayOfWeek = time.get(Calendar.DAY_OF_WEEK);
    		 hourOfDay = time.get(Calendar.HOUR_OF_DAY);
    		 if (hourOfDay >= 10 && hourOfDay < 22) {
    			 if (timeSlots[((dayOfWeek-1)*12) + (hourOfDay-10)]) {
    				 return false;
    			 }else {
    				 return timeSlots[((dayOfWeek-1)*12) + (hourOfDay-10)]=true;
    			 }
    		 }else
    			 return false;
    	}else
    		return false;
    }
}

