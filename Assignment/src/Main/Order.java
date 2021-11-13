/**
* @author Divyansh
* @version 1.0
* @since 6th November 2021
*/
package Main;
//import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Order {
    private int tableNumber;
    private double total;
    private GregorianCalendar time;//maybe time uses some other data type, i think we are supposed to use some library

    private Staff server;

    private ArrayList<MenuItem> list;
    private ArrayList<Integer> quant;
    
    private ArrayList<Promotion> promoList;
    private ArrayList<Integer> quantp;
    
    /**
     * Order constructor
     * @param tableNumber
     * @param time
     * @param server
     */
    public Order(int tableNumber, GregorianCalendar time, Staff server){
        this.tableNumber = tableNumber;
        this.time = time;
        this.server = server;

        this.list = new ArrayList<MenuItem>();
        this.quant = new ArrayList<Integer>();
        
        this.promoList = new ArrayList<Promotion>();
        this.quantp = new ArrayList<Integer>();
        
        this.total = 0;

    }

    /**
     * Adds menu item to MenuItem list and quantity to quant list
     * @param dish
     * @param quantity
     */
    public void addToOrder(MenuItem dish, int quantity){
        list.add(dish);
        quant.add(quantity);
    }
    
    /**
     * Removes an item from MenuItem list
     * @param index
     */
    public void removeFromOrder(int index){
        if(index == -1){
            list.remove(list.size() - 1);
        }
        else{
            list.remove(index);
        }
    }
    
    /**
     * Removes an item from Promotion list
     * @param index
     */
    public void removePromoFromOrder(int index) {
    	if(index == -1) {
    		promoList.remove(list.size() - 1);
    	}
    	else {
    		promoList.remove(index);
    	}
    }
    
    /**
     * Adds promotion item to Promotion list and quantity to quantp list
     * @param promo
     * @param quantity
     */
    public void orderPromoItem(Promotion promo, int quantity) {
    	promoList.add(promo);
    	quantp.add(quantity);
    }

    /**
     * prints invoice from the menu items ordered
     * @param isMember 
     */
    public void printInvoice(Boolean isMember){

        System.out.println("Waiter: " + this.server.getName());

        MenuItem item;
        String name;
        String qua;
        double price;
        int q;
        double total = 0;
        for(int i = 0; i < list.size(); i++){
            item = list.get(i);
            name = item.getName();
            price = item.getPrice();
            q = quant.get(i); 
            
            if(q == 1){
                qua = " ";
            }
            else{
                qua = " x" + q;
            }
            System.out.println(name + qua + "\t\t\t\t" + q*price);

            total += q*price;
        }
        
        Promotion itemP;
        
        for(int j = 0; j < promoList.size(); j++) {
        	itemP = promoList.get(j);
        	name = itemP.getName();
        	price = itemP.getPrice();
        	q = quantp.get(j);
        	
            if(q == 1){
                qua = " ";
            }
            else{
                qua = " x" + q;
            }
            System.out.println(name + qua + "\t\t\t\t" + q*price);
            
            total += q*price;	
        }
        
        System.out.println("Total: \t\t\t\t\t" + total);
        if(isMember) {
        	System.out.println("Membership discount = 10%");
        	total = 0.9*total;
        	System.out.println("Total: \t\t\t\t\t" + total);
        }
        
        this.total = total;

    }

    /**
     * Prints a list of all orders
     */
    public void viewOrder(){
        MenuItem item;
        String name;
        int q;
        for(int i = 0; i < list.size(); i++){
            item = list.get(i);
            name = item.getName();
            q = quant.get(i);

            System.out.println((i+1) + ". " + name + " (" + q + ")");
        }
    }
    /**
     * Prints a list of orders from the Promotional menu
     */
    public void viewPromoOrder() {
    	int q;
    	System.out.println("Special menu items:");
    	System.out.println("--------------------------");
		for (int i=0;i<promoList.size();i++) {
			q = quantp.get(i);
			System.out.println((i+1) + ". " + promoList.get(i).getName() + " (" + q + ")");
		}
    }

    /**
     * 
     * @return tableNumber
     */
    public int getTableNumber(){
        return this.tableNumber;
    }
    
    /**
     * 
     * @return String formatted for each order using Order and time parameters.
     */
    public String convertToString() {
    	String out = Integer.toString(this.time.get(Calendar.YEAR)) + "\t" + Integer.toString(this.time.get(Calendar.MONTH)) + "\t" + Integer.toString(this.time.get(Calendar.DATE)) + "\t" + Integer.toString(this.time.get(Calendar.HOUR));
    	out = out + "\t" + Integer.toString(this.tableNumber) + "\t" + Integer.toString(this.server.getID()) + "\t" + Integer.toString(list.size());
    	for(int i = 0; i < list.size(); i++) {
    		out = out + "\t" + list.get(i).getName() + "\t" + Integer.toString(quant.get(i));
    	}
    	
    	for(int j = 0; j < promoList.size(); j++) {
    		out = out + "\t" + promoList.get(j).getName() + "\t" + Integer.toString(quantp.get(j));
    	}
    	
    	out = out + "\t" + Double.toString(this.total);
    	return out;
    }
    
    public int getMonth() {
    	return this.time.get(Calendar.MONTH);
    }
    
    public double getTotal() {
    	return this.total;
    }
    
    public void setTotal(double total2) {
    	this.total = total2;
    }
    
    public Staff getServer() {
    	return this.server;
    }


}
