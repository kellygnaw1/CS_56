import java.util.ArrayList;

public class User implements Observer{
	private int userID;
	private static int count = 0;
	private ArrayList<String> tags;
	private ArrayList<Post> posts;
	
	public User() {
		count++;
		userID = count;
		posts = new ArrayList<Post>();
		tags = new ArrayList<String>();
	}

	public void addPosts(Post post) {
		if(posts.contains(post))
			return;
		posts.add(post);
	}
	
	public void addTags(String tag) {
		for(int i = 0; i < tags.size(); i++) {
			if (tags.get(i).equalsIgnoreCase(tag))
				return;
			else
				tags.add(tag);
		}
	}
	
	public int getUserID() {return userID;}
	
	public ArrayList<Post> getPosts(){return posts;}
	
	public ArrayList<String> getTags(){return tags;}
	
	public void update(Post post) {
		System.out.println("\n***** Updating UserID: " + userID+ "*****");
		System.out.println(post.toString());
		System.out.println("******************************");

		
		
	}
}
