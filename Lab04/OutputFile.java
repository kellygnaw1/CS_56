//Kelly Wang 5351010
//Colette Lee 5374731
import java.io.PrintWriter;

public class OutputFile implements OutputFileInterface{
	PrintWriter outputFile = null; 
	
	@Override 
	public void open(String outputFileName) {
		try {
			outputFile = new PrintWriter(outputFileName);
			String title = "TITLE";
			String artist = "ARTIST";
			String album = "ALBUM";
			String length = "LENGTH";
			String year = "YEAR";
			String additional = "ADDITIONAL_INFORMATION";
			outputFile.format("%-40s %-40s %-40s %-7s %-5s %-40s \n", title, artist, album, length, year, additional );
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	@Override
	public void writeItem(MusicTrack trackToWrite) {
		outputFile.format("%-40s %-40s %-40s %-7s %-5s %-40s \n", trackToWrite.getTitle(), trackToWrite.getArtist(), trackToWrite.getAlbum(), trackToWrite.getLength(), trackToWrite.getYear(), trackToWrite.getAdditionalInfo());
	}
	
	@Override 
	public void close() {
		outputFile.close();
	}
}
