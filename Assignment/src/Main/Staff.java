package Main;
import java.util.Scanner;

public class Staff {
    private String name;
    private boolean gender; 
    private int ID;
    private String jobTitle;
    Scanner sc = new Scanner(System.in);

    public Staff(String name, boolean gender, int ID, String jobTitle){
    	this.name = name;
    	this.gender = gender;
    	this.ID = ID;
    	this.jobTitle = jobTitle;
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }
    
    public String getTitle() {
    	return this.jobTitle;
    }
    public String getGender() {
    	if (gender==false)
    		return "M";
    	else
    		return "F";
    }
    
    public String getJobTitle() {
    	return this.jobTitle;
    }
    
    public String convertToString() {
    	int intGender = this.gender ? 1 : 0;
        return name + "/" + Integer.toString(intGender) + "/" + Integer.toString(this.ID) + "/" + this.jobTitle;
    }
}
