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
	
	public static void WriteToFile(ArrayList<?> array){ 
		//String data = item.convertToString();
		try {
			FileWriter myWriter = new FileWriter(filepath);
			//write this using normal for or while loop
			for(int i = 0; i < array.size(); i++){
				myWriter.write(((MenuItem)array.get(i)).convertToString());	// Downcast object to MenuItem to use MenuItem.convertToString
				myWriter.write("\n");
			}
			
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		}catch (IOException e) {
			System.out.println("An error occurred while writing to file.");
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

			//array.add(new Reservation(pax, date, time, name));	// TODO
		}
		myReader.close();
	}
}
