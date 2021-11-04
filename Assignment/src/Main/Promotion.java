package Main;
import java.util.ArrayList;

public class Promotion extends MenuItem{
    private ArrayList<MenuItem> array;

    public Promotion(String n, String d, double p) {
        super(n, d, p);
        this.array = new ArrayList<MenuItem>();
    }

    public addItemToPromotion(MenuItem item){
        this.array.add(item);
    }

}