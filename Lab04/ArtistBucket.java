//Kelly Wang 5351010
//Colette Lee 5374731
import java.util.ArrayList;

public class ArtistBucket implements BucketInterface{
	private ArrayList<ArrayList<MusicTrack>> artistAL;
	
	public ArtistBucket() {
		artistAL = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			artistAL.add(new ArrayList<MusicTrack>());
		}
	}
	public void addItem(MusicTrack musicTrack) {
		String artist = musicTrack.getArtist();
		int index = Character.toUpperCase(artist.charAt(0)) -65;
		ArrayList<MusicTrack> bucket = artistAL.get(index);
		String name; 
		String newName = musicTrack.getArtist() + musicTrack.getTitle();
		if(bucket.size() == 0)
			bucket.add(musicTrack);
		else {
			for(int i = 0; i < bucket.size(); i++) {
				name = bucket.get(i).getArtist()+bucket.get(i).getTitle();
				if(newName.compareTo(name)<0) {
					bucket.add(i, musicTrack);
					break;
				}if(i==bucket.size()-1) {
					bucket.add(musicTrack);
					break;
				}
			}
		}
	}
	public ArrayList<ArrayList<MusicTrack>> getBuckets(){
		return artistAL;
	}
}
