package lab03;
//Kelly Wang 5351010
//Evan Altshule 5233234
import java.util.Scanner;

public class ClassRosterUI {
	
	public static void printMenu() {
		System.out.println("----------"
				+ "\n ac: Add Course"
				+ "\n dc: Drop Course"
				+ "\n as: Add Student"
				+ "\n ds: Drop Student"
				+ "\n p: Print Class Roster"
				+ "\n q: Quit Program"
				+ "\n ----------");

		
		
	}
	
	public static String getCommand() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Command");
		while(true) {
			String command = s.nextLine();
			if(command == "ac" || command == "dc" || command == "as" || command =="ds" || command == "p" || command == "q")
				s.close();
				return command;
		}
	}
}
