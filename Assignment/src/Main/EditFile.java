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

		
	public void readTablesFromFile(ArrayList<Table> array) {
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			String[] parts = str.split("\t");
			int tableNumber = Integer.parseInt(parts[0]);
			int size = Integer.parseInt(parts[1]);

			array.add(new Table(tableNumber, size));
		}
		myReader.close();
	}

	public void readReservationsFromFile(ArrayList<Reservation> array) { 
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			String[] parts = str.split("\t");
			int pax = Integer.parseInt(parts[0]);
			String name = parts[1];
			int year = Integer.parseInt(parts[2]);
			int month = Integer.parseInt(parts[3]);
			int date = Integer.parseInt(parts[4]);
			int hours = Integer.parseInt(parts[5]);
			int minutes = Integer.parseInt(parts[6]);

			array.add(new Reservation(pax, name, year, month, date, hours, minutes));
		}
		myReader.close();
	}
	
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
	
	public void readPromotionsFromFile(ArrayList<Promotion> array, ArrayList<MenuItem> menu) {
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			String[] parts = str.split("\t");
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
		myReader.close();
		}
	}
}
	
	
