package Main;

public class Order {
    private int tableNumber;
    private int time; //maybe time uses some other data type, i think we are supposed to use some library

    private menuItem[] list = new menuItem[128];

    public Order(int tableNumber, int time, Staff server){

    }

    public void addToOrder(MenuItem dish, int quantity){

    }

    public void printInvoice(){

    }

    public void viewOrder(){

    }

    public int getTableNumber(){
        return this.tableNumber;
    }
}
