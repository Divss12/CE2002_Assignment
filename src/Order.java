public class Order {
    private int tableNum;
    private int orderNum;   // Order ID
    private Customer customer;
    private int date;   // For time stamp in invoice

    public Order(int tableNum, Customer customer, int date){
        this.tableNum = tableNum;
        this.customer = customer;
        this.date = date;
        System.out.println("Taking order");
    }

    public int getTableNum() {
        return this.tableNum;
    }
    public int getOrderNum() {
        return this.orderNum;
    }

    public Customer getCustomer() {
        return this.customer;
    }


}
