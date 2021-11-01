package Main;

public class Table {

    private int tableNumber;
    private boolean occupied;

    public Table(int tableNumber){
        this.tableNumber = tableNumber;
        this.occupied = false;
    }

    public void changeAvailability(boolean newBool){
        this.occupied = newBool;
    }

    public Boolean checkAvailability(){
        return !occupied;
    }
}
