package Main;
import java.io.IOException;	// Handle errors when writing to files
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu

public class Table {

    private int tableNumber;
    private boolean occupied;
    private int size;

    public Table(int tableNumber, int size){
        this.tableNumber = tableNumber;
        this.occupied = false;
        this.size = size;
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
}

