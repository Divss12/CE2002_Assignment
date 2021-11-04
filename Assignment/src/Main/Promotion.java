package Main;
import java.util.ArrayList;

public class Promotion extends MenuItem{
	private ArrayList<MenuItem> array;
	
	public Promotion(String n, String d, double p) {
		super(n, d, p);
		array = new ArrayList<>();
	}
	
}
