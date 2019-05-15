//Kelly Wang 5351010
//Colette Lee 5374731
import java.util.ArrayList;
public class TitleBucket {
	private ArrayList<ArrayList<MusicTrack>> titleAL;
	
	public TitleBucket() {
		titleAL = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			titleAL.add(new ArrayList<MusicTrack>());
		}
	}
	
	public void addItem(MusicTrack musicTrack) {
		String title = musicTrack.getTitle(); 
		int index = Character.toUpperCase(title.charAt(0)) -65;
		ArrayList<MusicTrack> bucket = titleAL.get(index);
		String name;
		String newName = musicTrack.getTitle()+musicTrack.getArtist();
		if(bucket.size() == 0)
			bucket.add(musicTrack);
		else {
			for(int i = 0; i < bucket.size(); i++) {
				name = bucket.get(i).getTitle() + bucket.get(i).getArtist();
				if(newName.compareTo(name) < 0) {
					bucket.add(i, musicTrack);
					break;
				}
				if(i == bucket.size()-1) {
					bucket.add(musicTrack);
					break;
				}
			}
		}
	}
	
	public ArrayList<ArrayList<MusicTrack>> getBuckets(){
		return titleAL;
	}
}
