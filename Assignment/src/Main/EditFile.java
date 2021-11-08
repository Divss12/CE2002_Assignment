/**
* @author Zavier
* @version 1.0
* @since 3rd November 2021
* This class is used to create, write to and read from files
*/
package Main;
import java.io.File;
import java.io.FileNotFoundException;	// Handle error when reading from files
import java.io.IOException;	// Handle error when writing to files
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu
import java.util.ArrayList;
import java.util.Scanner;	// Import to read file

public class EditFile {
	private String filepath;
	private File myFile;
	private Scanner myReader;

	public EditFile(String filePath) {
			this.filepath = filePath;	// Change filepath accordingly
			File myFile = new File(filePath);	
			this.myFile = myFile;
			try {
				this.myReader = new Scanner(myFile);
			} catch (FileNotFoundException e) {
				System.out.println("Error creating file");
				e.printStackTrace();
			}
			CreateFile(myFile);
		}

	/**
	 * Creates a new file with the name filename
	 * Abstraction
	 * @param filename
	 */
	private static void CreateFile(File filename) {
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
	
	/**
	 * Writes MenuItem objects to file at filepath
	 * @param array
	 * @param filepath
	 */
	public static void WriteMenuToFile(ArrayList<MenuItem> array, String filepath){ 
		try {
			FileWriter myWriter = new FileWriter(filepath);
			for(int i = 0; i < array.size(); i++){
				myWriter.write(array.get(i).convertToString());
				myWriter.write("\n");
			}
			
			myWriter.close();
		}catch (IOException e) {
			System.out.println("An error occurred while writing to menu file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes Table objects to file at filepath
	 * @param array
	 * @param filepath
	 */
	public static void WriteTablesToFile(ArrayList<Table> array, String filepath){ 
		try {
			FileWriter myWriter = new FileWriter(filepath);
			for(int i = 0; i < array.size(); i++){
				myWriter.write(array.get(i).convertToString());	
				myWriter.write("\n");
			}
			
			myWriter.close();
		}catch (IOException e) {
			System.out.println("An error occurred while writing to tables file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes Reservation objects to file at filepath
	 * @param array
	 * @param filepath
	 */
	public static void WriteReservationsToFile(ArrayList<Reservation> array, String filepath){ 
		try {
			FileWriter myWriter = new FileWriter(filepath);
			for(int i = 0; i < array.size(); i++){
				myWriter.write(array.get(i).convertToString());	
				myWriter.write("\n");
			}
			myWriter.close();
		}catch (IOException e) {
			System.out.println("An error occurred while writing to reservations file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes Promotion objects to file at filepath
	 * @param array
	 * @param filepath
	 */
	public void writePromoMenu(ArrayList<Promotion> array, String filepath) {
		try {
			FileWriter myWriter = new FileWriter(filepath);
			for(int i = 0; i < array.size(); i++){
				myWriter.write(array.get(i).convertToString());	
				myWriter.write("\n");
			}
			myWriter.close();
		}catch (IOException e) {
			System.out.println("An error occurred while writing to promotions file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads String objects from file and uses them as arguments to initialize MenuItem objects
	 * @param array
	 */
	public void readMenuFromFile(ArrayList<MenuItem> array) { 
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

	/**
	 * Reads String objects from file and uses them as arguments to initialize Table objects	
	 * @param array
	 */
	public void readTablesFromFile(ArrayList<Table> array) {
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			String[] parts = str.split("\t");
			int tableNumber = Integer.parseInt(parts[0]);
			int size = Integer.parseInt(parts[1]);

			boolean[] boolArray = new boolean[84];
			int j;
			for(int i = 2; i < parts.length; i++){
				j = Integer.parseInt(parts[i]);
				if(j == 1) {boolArray[i-2] = true;}
				else {boolArray[i-2] = false;}
			}
			for(int k = parts.length - 2; k < 84; k++) { //if the file has incomplete values for timeSlots[]
				boolArray[k] = false;
			}

			Table t = new Table(tableNumber, size);
			t.setTimeSlots(boolArray);

			array.add(t);
		}
		myReader.close();
	}

	/**
	 * Reads Reservation objects from file and uses them as arguments to initialize Reservation objects
	 * @param array
	 */
	public void readReservationsFromFile(ArrayList<Reservation> array) { 
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			String[] parts = str.split("\t");
			String name = parts[0];
			int pax = Integer.parseInt(parts[1]);
			int year = Integer.parseInt(parts[2]);
			int month = Integer.parseInt(parts[3]);
			int date = Integer.parseInt(parts[4]);
			int hours = Integer.parseInt(parts[5]);

			array.add(new Reservation(pax, name, year, month, date, hours));
		}
		myReader.close();
	}
	
	/**
	 * Reads Promotion objects from file and uses them as arguments to initialize Promotion objects
	 * @param array
	 * @param menu
	 */
	public void readPromotionsFromFile(ArrayList<Promotion> array, ArrayList<MenuItem> menu) {
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			String[] parts = str.split("/");
			String name = parts[0];
			String desc = parts[1];
			double price = Double.parseDouble(parts[2]);
			
			Promotion promo = new Promotion(name, desc, price);
			
			for(int i = 3; i < parts.length; i++) {
				for(MenuItem m: menu) {
					if(parts[i].equals(m.getName())) {
						promo.addItemToPromotion(m);
						break;
					}
				}
			}
			array.add(promo);
		}
	}
}
	
	
