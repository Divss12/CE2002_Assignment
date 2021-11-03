package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;	// Handle errors when editing files
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu
import java.util.ArrayList;
import java.util.Scanner;	// Import to read file

public class EditFile {
	private static String filepath;
	public EditFile() {
			this.filepath = "C:\\Users\\User\\OneDrive - Nanyang Technological University\\gitproj\\CE2002_Assignment\\Assignment\\src\\Main\\RestMenu";	// Change filepath accordingly
			File RestMenu = new File(filepath);	
			// Set location of txt file which contains menu items
			CreateFile(RestMenu);
		}

	public static void CreateFile(File filename) {
		try {	
			if (filename.createNewFile()) {
				System.out.println("File created: " + filename.getName());
			}else {
				System.out.println("File already exists.");
			}
		}catch (IOException e) {
			System.out.println("Error creating file.");
			e.printStackTrace();
		}
	}
	
	public static void WriteToFile(ArrayList<?> menu){ 
		//String data = item.convertToString();
		try {
			FileWriter myWriter = new FileWriter(filepath + ".txt");

			for(Object m: menu){
				m.StoreToFile(myWriter);
				myWriter.write("\n")
			}
			
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		}catch (IOException e) {
			System.out.println("An error occurred while writing to file.");
			e.printStackTrace();
		}
	}
	
	public static void ReadMenuFromFile(ArrayList<MenuItem> menu) { //make this for others
		try {
			File restMenu = new File(filepath + ".txt");
			Scanner myReader = new Scanner(restMenu);
			while(myReader.hasNextLine()) {
				String name = myReader.nextLine();
				String price = myReader.nextLine();
				String description = myReader.nextLine();
				System.out.println("[1] " + name + "\n" + price + "\n" + description + "\n");
			}myReader.close();
		}catch (FileNotFoundException e) {
			System.out.println("An error occured while reading from file.");
			e.printStackTrace();
		}
	}
}
