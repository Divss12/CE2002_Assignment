/**
* @author Divyansh
* @version 1.0
* @since 6th November 2021
*/
package Main;
import java.io.IOException;	// Handle errors when writing to files
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Table {

    private int tableNumber;
    //private boolean occupied;
    private int size;
    private boolean[] timeSlots = new boolean[84];

    /**
     * Constructor for Table
     * @param tableNumber
     * @param size
     */
    public Table(int tableNumber, int size){
        this.tableNumber = tableNumber;
        //this.occupied = false;
        this.size = size;
        for (int i=0;i<timeSlots.length;i++) {
        	timeSlots[i] = false;
        }
    }

    /**
     * returns table number
     * @return tableNumber
     */
    public int getTableNumber() {
    	return this.tableNumber;
    }
    
    /**
     * Sets timeSlots from boolean array input
     * @param array to set timeSlots
     */
    public void setTimeSlots(boolean[] array){
        this.timeSlots = array;
    }
    
    /**
     * sets timeSlot at index to free;
     * @param idx for which timeSlot to free
     */
    public void freeTimeSlot(int idx) {
    	timeSlots[idx] = false;
    }

    /**
     * Occupies a table by changing the appropriate value in timeSlots[] according to current time;
     * @return true if successful
     * @return false if unsuccessful/table already occupied
     */
    public boolean occupy(){
        GregorianCalendar now = new GregorianCalendar();
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
		if (hourOfDay >= 10 && hourOfDay < 22) {
			if(timeSlots[((dayOfWeek-1)*12) + (hourOfDay-10)]) {
				return false;
			}
			else {
				return timeSlots[((dayOfWeek-1)*12) + (hourOfDay-10)] = true;
			}
		}
		return false;
    }

    /**
     * Checks if a table is occupied by a customer
     * @return true if available
     */
    public Boolean checkAvailability(){
    	GregorianCalendar now = new GregorianCalendar();
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
		if (hourOfDay >= 10 && hourOfDay < 22) {
			return timeSlots[((dayOfWeek-1)*12) + (hourOfDay-10)];
		}
		else {
			return false;
		}
    }

    /**
     * formats and converts to String
     * @return String formatted for tables.txt
     */
    public String convertToString(){
        String out = Integer.toString(this.tableNumber) + "\t" + Integer.toString(this.size);
        String s;
        for(boolean b: timeSlots){
        	if(b) {s = "1";} else {s = "0";}
            out = out + "\t" + s;
        }
        return out;
    }
    
    /**
     * Set corresponding table index to true in timeSlots array if a reservation
     * has already been made for a particular table at a time slot
     * @param time
     * @param pax
     * @return true if time slot is taken
     */
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

