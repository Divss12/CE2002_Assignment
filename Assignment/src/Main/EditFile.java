package Main;
import java.io.File;
import java.io.FileNotFoundException;	// Handle error when reading from files
import java.io.IOException;	// Handle error when writing to files
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
			try {
				this.myReader = new Scanner(myFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public static void WriteToFile(ArrayList<MenuItem> menu){ 
		//String data = item.convertToString();
		try {
			FileWriter myWriter = new FileWriter(filepath + ".txt");

			for(MenuItem m: menu){
				myWriter.write(m.convertToString());
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
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			String[] parts = str.split("\t");
			String n = parts[0];
			String d = parts[1];
			double p = Double.parseDouble(parts[2]);
			
			array.add(new MenuItem(n,d,p));
		}
		myReader.close();
	}
}
