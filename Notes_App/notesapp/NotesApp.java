package notesapp;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class NotesApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String fileName = scanner.nextLine();
		while(true) {
			System.out.println("1.Create/Append note");
			System.out.println("2.Read notes");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			 case 1:
				 System.out.println("Enter your note: ");
				 String note = scanner.nextLine();
				 appendNote(fileName, note);
				 break;
			 case 2:
				 readNotes(fileName);
				 break;
			 case 3:
				 System.out.println("Exiting...");
				 scanner.close();
				 return;
			 default:
				 System.out.println("Invalid choice!");
			 
			}
		}
		// TODO Auto-generated method stub

	}
	private static void appendNote(String fileName, String note) {
		try(FileWriter fileWriter = new FileWriter(fileName, true)){
			fileWriter.write(note + "\n");
			System.out.println("Note appended successfully!");
					
		}catch(IOException e) {
			System.out.println("Error appending note: " + e.getMessage());
		}
		
	}
	private static void readNotes(String fileName) {
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
			String line;
			boolean isEmpty = true;
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				isEmpty = false;
				
			}
			if(isEmpty) {
				System.out.println("No notes found");
			}
		}catch(IOException e) {
			System.out.println("Error reading notes: " + e.getMessage());
		}
	}

}
