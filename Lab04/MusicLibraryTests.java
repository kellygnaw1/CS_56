//Kelly Wang 5351010
//Colette Lee 5374731
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

import java.util.ArrayList;
public class MusicLibraryTests {
	private MusicTrack track1 = new VinylTrack("Last Nite", "3:17", "The Strokes","Is This It", "2001", "33");
	private MusicTrack track2 = new VinylTrack("Is This It", "2:35", "The Strokes","Is This It", "2001", "33");
	private MusicTrack track3 = new VinylTrack("X-Static", "4:13", "Foo Fighters", "Foo Fighters", "1995","33");
	private MusicTrack track4 = new VinylTrack("Young Lust", "4:20", "Aerosmith", "pump", "1989", "33" );
	
	private MusicTrack track5 = new DigitalTrack("Time is running out","3:56", "Muse", "Absolution", "2003", "320");                     
	private MusicTrack track6 = new DigitalTrack("Tiptoe", "3:14", "Imagine Dragons", "Night Visions", "2012", "320");

	@Before
	public void executeBeforeEachTest() {
		System.out.println("@Before: shown before each test");
	}
	
	@Test
	public void addArtistVinylTest() {
		ArtistBucket artistBucket = new ArtistBucket();
		artistBucket.addItem(track1);
		artistBucket.addItem(track2);
		ArrayList<ArrayList<MusicTrack>> expected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			expected.add(new ArrayList<MusicTrack>());
		}
		expected.get(19).add(track2);
		expected.get(19).add(track1);
		assertEquals(expected, artistBucket.getBuckets());


	}
	
	@Test
	public void addTitleVinylTest() {
		TitleBucket titleBucket = new TitleBucket();
		titleBucket.addItem(track3);
		titleBucket.addItem(track4);
		ArrayList<ArrayList<MusicTrack>> expected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			expected.add(new ArrayList<MusicTrack>());
		}
		expected.get(23).add(track3);
		expected.get(24).add(track4);
		assertEquals(expected, titleBucket.getBuckets());
	}
	
	@Test
	public void addArtistDigitalTest() {
		ArtistBucket artistBucket = new ArtistBucket();
		artistBucket.addItem(track5);
		artistBucket.addItem(track6);
		ArrayList<ArrayList<MusicTrack>> expected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			expected.add(new ArrayList<MusicTrack>());
		}
		expected.get(8).add(track6);
		expected.get(12).add(track5);
		assertEquals(expected, artistBucket.getBuckets());
	}
	
	@Test
	public void addTitleDigitalTest() {
		TitleBucket titleBucket = new TitleBucket();
		titleBucket.addItem(track5);
		titleBucket.addItem(track6);
		ArrayList<ArrayList<MusicTrack>> expected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			expected.add(new ArrayList<MusicTrack>());
		}
		expected.get(19).add(track5);
		expected.get(19).add(track6);
		assertEquals(expected, titleBucket.getBuckets());
		
	}
	
	@After
	public void executeAfterTest() {
		System.out.println("@After: shown after every test");
	}
	
	@AfterClass
	public static void executeAfterAllTests() {
		System.out.println("@AfterClass: shown once after all tests");
	}
	
	@BeforeClass
	public static void executeBeforeAllTests() {
		System.out.println("@BeforeClass: shown once before all tests");
	}
}
