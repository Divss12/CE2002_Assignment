package Main;
import java.io.File;
import java.io.FileNotFoundException;	// Handle error when reading from files
import java.io.IOException;	// Handle error when writing to files
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu
import java.util.ArrayList;
import java.util.Scanner;	// Import to read file

public class EditFile {
	private static String filepath;
	private File myFile;
	private Scanner myReader;

	public EditFile(String filePath) {
			this.filepath = filePath;	// Change filepath accordingly
			File myFile = new File(filePath);	
			this.myFile = myFile;
			try {
				this.myReader = new Scanner(myFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error creating file");
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
	
	public static void WriteMenuToFile(ArrayList<MenuItem> array, String filepath){ 
		//String data = item.convertToString();
		try {
			FileWriter myWriter = new FileWriter(filepath);
			//write this using normal for or while loop
			for(int i = 0; i < array.size(); i++){
				myWriter.write(array.get(i).convertToString());	// Downcast object to MenuItem to use MenuItem.convertToString
				myWriter.write("\n");
			}
			
			myWriter.close();
			System.out.println("Successfully wrote to the menu file.");
		}catch (IOException e) {
			System.out.println("An error occurred while writing to menu file.");
			e.printStackTrace();
		}
	}
	
	public static void WriteTablesToFile(ArrayList<Table> array, String filepath){ 
		//String data = item.convertToString();
		try {
			FileWriter myWriter = new FileWriter(filepath);
			//write this using normal for or while loop
			for(int i = 0; i < array.size(); i++){
				myWriter.write(array.get(i).convertToString());	// Downcast object to MenuItem to use MenuItem.convertToString
				myWriter.write("\n");
			}
			
			myWriter.close();
			System.out.println("Successfully wrote to tables file.");
		}catch (IOException e) {
			System.out.println("An error occurred while writing to tables file.");
			e.printStackTrace();
		}
	}
	
	public static void WriteReservationsToFile(ArrayList<Reservation> array, String filepath){ 
		//String data = item.convertToString();
		try {
			FileWriter myWriter = new FileWriter(filepath);
			//write this using normal for or while loop
			for(int i = 0; i < array.size(); i++){
				myWriter.write(array.get(i).convertToString());	// Downcast object to MenuItem to use MenuItem.convertToString
				myWriter.write("\n");
			}
			
			myWriter.close();
			System.out.println("Successfully wrote to reservations file.");
		}catch (IOException e) {
			System.out.println("An error occurred while writing to reservations file.");
			e.printStackTrace();
		}
	}
	
	public void readMenuFromFile(ArrayList<MenuItem> array) { //make this for others
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

		
	public void readTablesFromFile(ArrayList<Table> array) { //make this for others
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			String[] parts = str.split("\t");
			int tableNumber = Integer.parseInt(parts[0]);
			int size = Integer.parseInt(parts[1]);

			array.add(new Table(tableNumber, size));
		}
		myReader.close();
	}

	public void readReservationsFromFile(ArrayList<Reservation> array) { //make this for others
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			String[] parts = str.split("\t");
			int pax = Integer.parseInt(parts[0]);
			int size = Integer.parseInt(parts[1]); 
			int year = Integer.parseInt(parts[2]);
			int month = Integer.parseInt(parts[3]);
			int date = Integer.parseInt(parts[4]);
			int hours = Integer.parseInt(parts[5]);
			int minutes = Integer.parseInt(parts[6]);

			array.add(new Reservation(pax, size, year, month, date, hours, minutes));
		}
		myReader.close();
	}
}
