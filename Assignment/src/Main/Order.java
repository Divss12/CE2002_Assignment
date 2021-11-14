/**
* @author Divyansh
* @version 1.0
* @since 6th November 2021
*/
package Main;
import java.time.format.DateTimeFormatter;
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
    	if (list.size()<=index) {
    		System.out.println("Item of index " + Integer.toString(index) + " does not exist in the order.");
    		return;
    	}
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
    	if (promoList.size()<=index) {
    		System.out.println("Item of index " + Integer.toString(index) + " does not exist in the order.");
    		return;
    	}
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
    	
    	int width = 50;
    	
    	System.out.println("-".repeat(width));
    	System.out.println("|" + " ".repeat(width - 2) + "|");
    	System.out.println("|" + " ".repeat(width/2 - 8) + "ZAVIER'S PLACE" + " ".repeat(width/2 - 8) + "|");
    	System.out.println("|" + " ".repeat(width/2 - 8) + "**************" + " ".repeat(width/2 - 8) + "|");
    	System.out.println("|" + " ".repeat(width/2 - 10) + "21 Fake Address St." + " ".repeat(width/2 - 11) + "|");
    	System.out.println("|" + " ".repeat(width/2 - 9) + "238721, Singapore" + " ".repeat(width/2 - 10) + "|");
    	System.out.println("|" + " ".repeat(width/2 - 8) + "Tel: 3847 2821" + " ".repeat(width/2 - 8) + "|");
    	System.out.println("|" + " ".repeat(width - 2) + "|");
    	System.out.println("|" + " ".repeat(width - 2) + "|");
    	
    	String server = "Server: " + this.server.getName();
    	String date = "Date: " + (this.time).toZonedDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	String table = "Table: " + Integer.toString(this.tableNumber);
    	String time = "Time: " + (this.time).toZonedDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));
       
    	int left;
        if(server.length() > table.length()) {
        	table = " ".repeat(server.length() - table.length()) + table;
        	left = server.length();
        }
        else {
        	server = " ".repeat(table.length() - server.length()) + server;
        	left = table.length();
        }
        
        time = time + " ".repeat(5);
        int right = 16;
        
        System.out.println("|  " + server + " ".repeat(width - left - right - 6) + date + "  |");
        System.out.println("|  " + table + " ".repeat(width - left - right - 6) + time + "  |");
        
        System.out.println("|" + " ".repeat(width - 2) + "|");
        System.out.println("|" + "-".repeat(width - 2) + "|");
        System.out.println("|" + " ".repeat(width - 2) + "|");
        MenuItem item;
        String name, qua, pri;
        double price;
        int q;
        double total = 0;
        for(int i = 0; i < list.size(); i++){
            item = list.get(i);
            name = item.getName();
            price = item.getPrice();
            q = quant.get(i); 
            
            qua = Integer.toString(q);
            qua = " ".repeat(2-qua.length()) + qua; 
            
            pri = Double.toString(price);
            pri = pri + "0".repeat(3 - pri.length() + pri.indexOf("."));
             
            System.out.println("|   " + qua + "   " + name + " ".repeat(width - 12 - name.length() - pri.length()) + pri + "  |");
            

            total += q*price;
        }
        
        Promotion itemP;
        
        for(int j = 0; j < promoList.size(); j++) {
        	itemP = promoList.get(j);
        	name = itemP.getName();
        	price = itemP.getPrice();
        	q = quantp.get(j);
        	
            qua = Integer.toString(q);
            qua = " ".repeat(2-qua.length()) + qua; 
            
            pri = Double.toString(price);
            
            pri = pri + "0".repeat(3 - pri.length() + pri.indexOf("."));
            
            System.out.println("|   " + qua + "   " + name + " ".repeat(width - 12 - name.length() - pri.length()) + pri + "  |");
            
            total += q*price;	
        }
        
        System.out.println("|" + "-".repeat(width - 2) + "|");
        
        String subtotal = Double.toString(total);
        subtotal = subtotal + "0";
        System.out.println("|" + " ".repeat(width - 14 - subtotal.length()) + "Subtotal: " + subtotal + "  |");
        
        int dec;
        if(isMember) {
        	String memberDisc =  Double.toString(0.1*total);
        	dec = memberDisc.length() - memberDisc.indexOf(".") - 1;
        	if(dec > 2) {
        		memberDisc = memberDisc.substring(0, memberDisc.length() - dec + 2);
        	}
        	else if (dec < 2) {
        		memberDisc = memberDisc + "0".repeat(2 - dec);
        	}
        	
        	System.out.println("|" + " ".repeat(width - 31 - memberDisc.length()) + "-10% Membership discount: -" + memberDisc + "  |");
        	total = 0.9*total;
        }
        
        String serviceCharge = Double.toString(0.1*total);
        dec = serviceCharge.length() - serviceCharge.indexOf(".") - 1;
    	if(dec > 2) {
    		serviceCharge = serviceCharge.substring(0, serviceCharge.length() - dec + 2);
    	}
    	else if (dec < 2) {
    		serviceCharge = serviceCharge + "0".repeat(2 - dec);
    	}
        
        System.out.println("|" + " ".repeat(width - 24 - serviceCharge.length()) + "10% Service Charge: " + serviceCharge + "  |");
        total = 1.1*total;
        
        String gst = Double.toString(0.07*total);
        dec = gst.length() - gst.indexOf(".") - 1;
    	if(dec > 2) {
    		gst = gst.substring(0, gst.length() - dec + 2);
    	}
    	else if (dec < 2) {
    		gst = gst + "0".repeat(2 - dec);
    	}
        
        System.out.println("|" + " ".repeat(width - 12 - gst.length()) + "7% GST: " + gst + "  |");
        total = 1.07*total;
        
        String finaltotal = Double.toString(total);
        dec = finaltotal.length() - finaltotal.indexOf(".") - 1;
    	if(dec > 2) {
    		finaltotal = finaltotal.substring(0, finaltotal.length() - dec + 2);
    	}
    	else if (dec < 2) {
    		finaltotal = finaltotal + "0".repeat(2 - dec);
    	}
    	
    	System.out.println("|" + "=".repeat(width - 2) + "|");
        System.out.println("|" + " ".repeat(width - 14 - finaltotal.length()) + "TOTAL: $" + finaltotal + "  |");
        System.out.println("|" + "=".repeat(width - 2) + "|");
        
        System.out.println("|" + " ".repeat(width - 2) + "|");
        System.out.println("|" + " ".repeat(width - 2) + "|");
        
        System.out.println("|" + " ".repeat(width/2 - 17) + "* Thank you for dining with us! *" + " ".repeat(width/2 - 18) + "|");
        
        System.out.println("|" + " ".repeat(width - 2) + "|");
        System.out.println("|" + " ".repeat(width - 2) + "|");
        
        System.out.println("-".repeat(width));
        
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
    
    public int getDay() {
    	return this.time.get(Calendar.DAY_OF_MONTH);
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
