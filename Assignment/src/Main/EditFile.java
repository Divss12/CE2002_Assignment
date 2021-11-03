package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;	// Handle errors when editing files
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu
import java.util.ArrayList;
import java.util.Scanner;	// Import to read file

public class EditFile {
	private static String filepath;
	private static File myFile;
	private static Scanner myReader;

	public EditFile(String filePath) {
			this.filepath = filePath;	// Change filepath accordingly
			File myFile = new File(filePath);	
			this.myFile = myFile;
			this.myReader = new Scanner(myFile);
			// Set location of txt file which contains menu items
			CreateFile(myFile);
		}

	public static void CreateFile(File filename) {
		try {	
			if (filename.createNewFile()) {
				System.out.println("File created: " + filename.getName());
			}else {
				System.out.println("File already exists."); //expected
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
				myWriter.write("\n");
			}
			
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		}catch (IOException e) {
			System.out.println("An error occurred while writing to file.");
			e.printStackTrace();
		}
	}
	
	public static void readMenuFromFile(ArrayList<MenuItem> array) { //make this for others
		try {
			while(this.myReader.hasNextLine()) {
				String str = this.myReader.nextLine();
				array.add(new MenuItem(str));
			}
			this.myReader.close();
		}catch (FileNotFoundException e) {
			System.out.println("An error occured while reading from file.");
			e.printStackTrace();
		}
	}
}
