import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

import java.util.ArrayList;
public class MessageBoardTester {
	
	private MessageBoardManager mb; 
	private User u1 = new User();
	private User u2 = new User();
	private User u3 = new User();
	private User u10 = new User();

	@Before
	public void executeBeforeEachTest() {
		System.out.println("@Before: shown before each test");
	}
	
	@Test
	public void testAddPostAndReplies() {
		ArrayList<String> tags = new ArrayList<String>();
		mb = new MessageBoardManager();
		tags.add("honda");
		tags.add("BMW");
		tags.add("Toyota");
		tags.add("HOnDa");
		
		Post p1 = new Post(tags, "toyota is da best", u2, -1);
		Post p2 = new Post(tags, "I agree, saving gas is cool", u3, p1.getPostID());
		Post p3 = new Post(tags, "Thanks!", u2, p2.getPostID());
	
		mb.addPost(p1);
		mb.addReply(p2);
		mb.addReply(p3);
		
		//Check add ALL 
		ArrayList<Post> allPosts = new ArrayList<Post>();
		allPosts = mb.getAllPosts();
		
		ArrayList<Post> expectedAll = new ArrayList<Post>();
		expectedAll.add(p1);
		expectedAll.add(p2);
		expectedAll.add(p3);
		
		assertEquals(expectedAll, allPosts);
		
		//Check add replies 
		ArrayList<Post> postReplies = new ArrayList<Post>();
		for(int i = 0; i < mb.getAllPosts().size(); i++) {
			if(mb.getAllPosts().get(i).getParentID() != -1) {
				postReplies.add(mb.getAllPosts().get(i));
			}
		}
		
		ArrayList<Post> expectedReplies = new ArrayList<Post>();
		expectedReplies.add(p2);
		expectedReplies.add(p3);
		assertEquals(expectedReplies, postReplies);
		
		//Check Error addPost
		mb.addPost(p1);
		assertEquals(expectedAll.size(), allPosts.size());
		
		//Check Error addReply
		Post p4 = new Post(tags, "ERROR REPLY", u3, -10);
		mb.addReply(p4);
		assertEquals(expectedAll.size(), allPosts.size());
	}
	
	@Test
	public void checkTagDisplay() {
		mb = new MessageBoardManager();
		ArrayList<String> tag2 = new ArrayList<String>();
		tag2.add("flowers");
		tag2.add("basil");

		Post p1 = new Post(tag2, "nature valley", u2, -1);
		Post p2 = new Post(tag2, "basil yum", u3, p1.getPostID());
		mb.addPost(p1);
		mb.addPost(p2);
		
		String error = mb.displayTagMessage("cool");
		String probablyWorks = mb.displayTagMessage("flowers");
		String expected ="";
		expected += p1.toString();
		expected += p2.toString();
		assertEquals("ERROR: cannot find tag!", error);
		assertEquals(expected, probablyWorks);
		
		
		
	}
	
	@Test
	public void checkDisplayKeyword() {
		mb = new MessageBoardManager();
		ArrayList<String> tag3 = new ArrayList<String>();
		tag3.add("bagels");
		tag3.add("pasta");
		
		Post p1 = new Post(tag3, "i <3 Bagels", u2, -1);
		Post p2 = new Post(tag3, "no I <3 PASTA MORE", u3, p1.getPostID());
		mb.addPost(p1);
		mb.addPost(p2);
		
		String probablyWorks = mb.displayKeywordMessage("<3");
		String error = mb.displayKeywordMessage("nonsense");
		String expected ="";
		expected += p1.toString();
		expected += p2.toString();
		
		assertEquals("ERROR: Cannot find keyword!", error);
		assertEquals(expected, probablyWorks);
		
	}

	@Test
	public void checkUserPosts() {
		mb = new MessageBoardManager();
		ArrayList<String> tag4 = new ArrayList<String>();
		tag4.add("bags");
		tag4.add("purses");
		
		Post p1 = new Post(tag4, "I cant find my purse", u2, -1);
		Post p2 = new Post(tag4, "wait no i cant find my bag", u2, p1.getPostID());
		mb.addPost(p1);
		mb.addPost(p2);
		
		String probablyWorks = mb.displayUserPost(u2);
		String error = mb.displayUserPost(u10);
		String expected = "";
		expected += p1.toString();
		expected += p2.toString();
		
		assertEquals("ERROR: cannot find user!", error);
		assertEquals(expected, probablyWorks);
	}
	
	@Test
	public void testThread() {
		
	}
	
	@Test
	public void testRegisterUserTag() {
		
	}
	
	@Test
	public void testRemoveUserTag() {
		
	}
	
	@Test
	public void testNotifyUser() {
		
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
