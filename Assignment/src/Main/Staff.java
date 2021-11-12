/**
 * @author Divyansh
 * @version 1.0
 * @since 6th November 2021
 */
package Main;
import java.util.Scanner;

public class Staff {
    private String name;
    private boolean gender; 
    private int ID;
    private String jobTitle;
    Scanner sc = new Scanner(System.in);

    /**
     * Constructor for Staff
     * @param name
     * @param gender
     * @param ID
     * @param jobTitle
     */
    public Staff(String name, boolean gender, int ID, String jobTitle){
    	this.name = name;
    	this.gender = gender;
    	this.ID = ID;
    	this.jobTitle = jobTitle;
    }

    /**
     * returns ID
     * @return ID
     */
    public int getID(){
        return this.ID;
    }

    /**
     * returns Name
     * @return Name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * returns Job title
     * @return jobTitle
     */
    public String getTitle() {
    	return this.jobTitle;
    }
    
    /**
     * returns Gender
     * @return String M if male String F if female
     */
    public String getGender() {
    	if (gender==false)
    		return "M";
    	else
    		return "F";
    }
    
    /**
     * Formats and converts to String 
     * @return String formatted for staff.txt
     */
    public String convertToString() {
    	int intGender = this.gender ? 1 : 0;
        return name + "/" + Integer.toString(intGender) + "/" + Integer.toString(this.ID) + "/" + this.jobTitle;
    }
}
