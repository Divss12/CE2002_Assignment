package Main;
import java.io.File;		
import java.io.IOException;	// Handle errors when editing files
import java.io.FileWriter;	// Import FileWriter class to write menuItem attributes to RestMenu

public class EditFile {
	public static void main(String[] args) {
		String filepath = "C:\\Users\\User\\OneDrive - Nanyang Technological University\\gitproj\\CE2002_Assignment\\Assignment\\src\\Main\\RestMenu";
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
	
//	public static void WriteToFile(String filepath, MenuItem item){
//		try {
//		FileWriter myWriter = new FileWriter(filepath + ".txt");
//		myWriter.write(null);
//	}
}
