//Kelly Wang 5351010
//Colette Lee 5374731
import java.util.ArrayList;

public interface BucketInterface {
	void addItem(MusicTrack itemToAdd); //by default it's already 'public abstract'
	public ArrayList<ArrayList<MusicTrack>> getBuckets();
}
