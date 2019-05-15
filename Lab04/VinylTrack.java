
//Kelly Wang 5351010
//Colette Lee 5374731

public class VinylTrack extends MusicTrack implements MusicTrackInterface{

	private String x = "Vinyl RPM: ";
	private String RPM; 
	
	public VinylTrack(String title, String length, String artist, String album, String year, String RPM) {
		super(title, length, artist, album, year);
		this.RPM = RPM;
	}
	public String getAdditionalInfo() {return (x +RPM);}
	
}
