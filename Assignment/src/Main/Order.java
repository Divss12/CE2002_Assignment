package Main;
import java.util.ArrayList; 

public class Order {
    private int tableNumber;
    private int time;//maybe time uses some other data type, i think we are supposed to use some library

    private Staff server;

    private ArrayList<MenuItem> list;
    private ArrayList<Integer> quant;
    
    private ArrayList<Promotion> promoList;
    private ArrayList<Integer> quantp;
    

    public Order(int tableNumber, int time, Staff server){
        this.tableNumber = tableNumber;
        this.time = time;
        this.server = server;

        this.list = new ArrayList<MenuItem>();
        this.quant = new ArrayList<Integer>();
        
        this.promoList = new ArrayList<Promotion>();
        this.quantp = new ArrayList<Integer>();

    }

    public void addToOrder(MenuItem dish, int quantity){
        list.add(dish);
        quant.add(quantity);
    }
    
    public void removeFromOrder(int index){
        if(index == -1){
            list.remove(list.size() - 1);
        }
        else{
            list.remove(index);
        }
    }
    
    public void orderPromoItem(Promotion promo, int quantity) {
    	promoList.add(promo);
    	quantp.add(quantity);
    }

    public void printInvoice(Boolean isMember){

        System.out.println("Waiter: " + this.server.getName());

        //Print time


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

    }

    public void viewOrder(){
        MenuItem item;
        String name;
        int q;
        for(int i = 0; i < list.size(); i++){
            item = list.get(i);
            name = item.getName();
            q = quant.get(i);

            System.out.println(i + ". " + name + " (" + q + ")");
        }
    }

    public int getTableNumber(){
        return this.tableNumber;
    }


}
