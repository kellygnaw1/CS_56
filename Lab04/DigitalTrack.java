//Kelly Wang 5351010
//Colette Lee 5374731

public class DigitalTrack extends MusicTrack{
	
	private String bitRate;
	private String x = "Digital BitRate: ";
	
	public DigitalTrack(String title, String length, String artist, String album, String year, String bitRate) {
		super(title, length, artist, album, year);
		this.bitRate = bitRate;
	}
	public String getAdditionalInfo() {return (x +bitRate);}
}
