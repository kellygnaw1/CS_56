//Kelly Wang 5351010
//Colette Lee 5374731
public interface OutputFileInterface {
	public abstract void open(String outputFileName);
	public abstract void writeItem(MusicTrack trackToWrite);
	public abstract void close();
}
