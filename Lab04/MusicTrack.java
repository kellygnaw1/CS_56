//Kelly Wang 5351010
//Colette Lee 5374731

public abstract class MusicTrack implements MusicTrackInterface{
//digital
//	(Track_title);(Track_length);(Artist);(Album);(Release_date);(Format_Type);(BitRate)
//vinyl
//	(Track_title);(Track_length);(Artist);(Album);(Release_date);(Format_Type);(RPM)
//

	private String title; 
	private String album; 
	private String length; 
	private String artist;
	private String year; 
	
	public MusicTrack(String title, String length, String artist, String album, String year) {
		this.title = title; 
		this.album = album; 
		this.artist = artist; 
		this.length = length; 
		this.year = year; 
	}
	public String getTitle() {return title;}
	public String getLength() {return length;}
	public String getArtist() {return artist;}
	public String getAlbum() {return album;}
	public String getYear() {return year;}
	public abstract String getAdditionalInfo();
	
}
