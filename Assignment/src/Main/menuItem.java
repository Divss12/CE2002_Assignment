package Main;

public class menuItem {
    
    private int type;
    private int price;
    private String description;
    private String name;
    
    public menuItem(int type, int price, String description, String name){
        this.type = type;
        this.price = price;
        this.description = description;
        this.name = name;
    }

    public void setType(int type){
        this.type = type;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getType(){
        return this.type;
    }

    public int getPrice(){
        return this.price;
    }
    
    public String getDescription(){
        return this.description;
    }

    public String getName(){
        return this.name;
    }
    
}
