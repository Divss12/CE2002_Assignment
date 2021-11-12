package Main;

public class Staff {
    private String name;
    private boolean gender; //only 2 genders??
    private int ID;
    private String jobTitle;

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
}
