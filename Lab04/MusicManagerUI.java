//Kelly Wang 5351010
//Colette Lee 5374731
import java.util.Scanner;
public class MusicManagerUI {
	public static Scanner s = new Scanner(System.in);
	public static String getFirstCommand() {
		System.out.println("Welcome to the Music Library Application!");
		
		while(true) {
			System.out.println("Enter `D` to read the music file from "
					+ "your local disk or `W` to read the music file from the web: ");
			String command = s.nextLine();
			if(command.equalsIgnoreCase("D") || command.equalsIgnoreCase("W")) {
				//s.close();
				return command; 
			}
			System.out.println("Invalid Input");
		}
	}
	
	public static String getSecondCommand() {
		while(true) {
			System.out.println("Enter `A` to output tracks by Artists "
					+ "or `T` to output tracks by Title. Enter `Q` to quit: ");
			String command = s.nextLine();
			if(command.equalsIgnoreCase("A") || command.equalsIgnoreCase("T") || command.equalsIgnoreCase("Q")) {
				return command;
			}
			System.out.println("Invalid Input");
		}
	}
	
	public static void close() {
		s.close();
	}
}
