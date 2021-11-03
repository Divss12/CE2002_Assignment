package Main;

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

    public void storeToFile(FileWriter file){
        try{
            file.write(this.tableNumber + "\t" + this.size);
        }catch(FileNotFoundException e){
        System.out.println("An error occured while reading from file.");
        e.printStackTrace();
        }
    }
}