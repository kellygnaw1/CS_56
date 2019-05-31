import java.util.ArrayList;

public class Post {
	private ArrayList<String> tags;
	private String message; 
	private ArrayList<Post> postReplies; 
	private static int postCount = 0;
	private int parentID;
	private int postID;
	private User user; 
	
	
	public Post(ArrayList<String> tags, String message, User user, int parentID) {
		postReplies = new ArrayList<Post>();
		this.tags = new ArrayList<String>();
		for(int i = 0; i < tags.size(); i++) {
			this.tags.add(tags.get(i));
		}
		this.message = message;
		this.user = user;
		this.parentID = parentID;
		postCount++;
		postID = postCount;
		//user.getPosts().add(this);
	}
	
	public ArrayList<String> getTags(){return tags;}
	public String getMessage() {return message;}
	public User getUser() {return user;}
	public int getParentID() {return parentID;}
	public int getPostID() {return postID;}
	public ArrayList<Post> getPostReplies(){return postReplies;}
	
	public void setTags(String tag) {
		tags.add(tag);
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void addPostReplies(Post post) {
		postReplies.add(post);
	}
	
	public String toString() {
		String out = "--\nPost ID: " + postID;
		out += "\nTags: ";
		for(int i = 0; i < tags.size(); i++) {
			out += tags.get(i).toLowerCase() + " ";
		}
		out += "\nPosted by UserID: " + user.getUserID();
		if(parentID != -1)
			out += "\nRe: to Post ID: " + parentID;
		out += "\nMessage: " + message + "\n--";
		return out;
	}

}
