//Kelly Wang 5351010
//Colette Lee 5374731
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
public class MusicManager {
	private ArtistBucket artistBucket;
	private TitleBucket titleBucket;
	private Scanner inFile;
	
	public MusicManager() {
		artistBucket = new ArtistBucket();
		titleBucket = new TitleBucket();
	}

	public void start() {
		String firstCommand = MusicManagerUI.getFirstCommand();
		while(true) {
			boolean sortByArtist = false;
			String secondCommand = MusicManagerUI.getSecondCommand();
			if(secondCommand.equalsIgnoreCase("a")) {
				System.out.println("Generate artistOutput.txt");
				sortByArtist = true;
			}
			else if(secondCommand.equalsIgnoreCase("q")) {
				System.out.println("Quits Application");
				break;
			}else {
				System.out.println("Generate titleOutput.txt");
			}
			if(firstCommand.equalsIgnoreCase("d")) {
				try {
					inFile = new Scanner(new File("MusicList.txt"));
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}else{
				try {
					URL remoteFileLocation = new URL("https://sites.cs.ucsb.edu/~richert/cs56/misc/lab04/MusicList.txt");
					URLConnection connection = remoteFileLocation.openConnection();
					inFile = new Scanner(connection.getInputStream());
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
			String[] fields;
			String line;
			while(inFile.hasNextLine()) {
				line = inFile.nextLine();
				fields = line.split(";");
				
				MusicTrack track;
				if(fields[5].equals("D")) {
					track = new DigitalTrack(fields[0], fields[1], fields[2], fields[3], fields[4], fields[6]);
				} else {
					track = new VinylTrack(fields[0], fields[1], fields[2], fields[3], fields[4], fields[6]);
				}
		
				if(sortByArtist) {
					artistBucket.addItem(track);
				} else {
					titleBucket.addItem(track);
				}
				
				
			}
			inFile.close();
			
			ArrayList<ArrayList<MusicTrack>> bucket;
			OutputFile out = new OutputFile();
			if(sortByArtist) {
				out.open("artistOutput.txt");
				bucket = artistBucket.getBuckets();
			}else {
				out.open("titleOutput.txt");
				bucket = titleBucket.getBuckets();
			}
			
			for(int i = 0; i < bucket.size(); i++) {
				ArrayList<MusicTrack> list = bucket.get(i);
				for(int j = 0; j < list.size(); j++) {
					out.writeItem(list.get(j));
				}
			}
			out.close();
		}
		MusicManagerUI.close();
	}
}

	