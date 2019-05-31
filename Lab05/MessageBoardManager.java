import java.util.ArrayList;
import java.util.LinkedHashMap; 

public class MessageBoardManager implements Subject {
	private LinkedHashMap<String, ArrayList<User>> tagsUsers;
	private ArrayList<Post> posts;
	
	public MessageBoardManager() {
		posts = new ArrayList<Post>();
		tagsUsers = new LinkedHashMap<String, ArrayList<User>>();
	}
	
	public void addPost(Post p) {
		/*---------------------------ERROR CHECK-----------------*/
		if(posts.contains(p)) {
			System.out.println("ERROR: Post already exists!");
			return;
		}
		/*-------------------------------------------------------
		 *********************************************************/
		
		posts.add(p);
		System.out.println("+++ Adding Post to MessageBoard +++");
		System.out.print(p.toString());
		System.out.println("\n++++++++++++++++++++++++++++++++++++\n");
		notifyUser(p);
	}

	public void addReply(Post reply) {
		boolean foundParent = false;
//		posts.add(reply);
		if(reply.getParentID() != -1) {
			for(int i = 0; i < posts.size(); i++) {
				if(reply.getParentID() == posts.get(i).getPostID()) {
					posts.get(i).addPostReplies(reply);
					posts.add(reply);
					foundParent = true;
				}
			}
		}
		System.out.println("\n+++ Adding Post to MessageBoard +++");
		System.out.println(reply.toString());
		System.out.println("++++++++++++++++++++++++++++++++++++");
		notifyUser(reply);
		

		
		/*---------------------------ERROR CHECK-----------------*/
		if(foundParent = false) {
			System.out.println("ERROR: Cannot find parent post!");
			return;
		}
		/*-------------------------------------------------------
		 *********************************************************/
	}
	
	public String displayTagMessage(String tag) {
		String ErrorMessage; 
		String tagPosts = "";
		/*---------------------------ERROR CHECK-----------------*/
		boolean hasTag = false;
		for(int i = 0; i < posts.size(); i++) {
			if(posts.get(i).getTags().contains(tag))
				hasTag = true;
		}
		if(hasTag == false) {
			System.out.println("ERROR: cannot find tag!");
			ErrorMessage = "ERROR: cannot find tag!";
			return ErrorMessage;
		}
		/*-------------------------------------------------------
		 *********************************************************/
		
		System.out.println("##### Displaying posts with tag: " + tag + " #####");
		for(int i = 0; i < posts.size(); i++) {
			if(posts.get(i).getTags().contains(tag)) {
				System.out.println(posts.get(i).toString());
				tagPosts += posts.get(i).toString(); 
			}
		}
		System.out.println("##############################\n");
		return tagPosts;
	}
	
	public String displayKeywordMessage(String keyword) {
		String error;
		String keyPosts = "";
		boolean hasKey = false;
		for(int i = 0; i < posts.size(); i++) {
			String message = posts.get(i).getMessage().toLowerCase();
			String newKeyword = keyword.toLowerCase();
			if(message.contains(newKeyword)) {
				hasKey = true;
				System.out.println("##### Displaying posts with keyword: " + keyword + " #####");
				System.out.println(posts.get(i).toString());
				System.out.println("##############################\n");
				keyPosts += posts.get(i).toString();
			}
		}
		/*---------------------------ERROR CHECK-----------------*/
		if(hasKey == false) {
			System.out.println("ERROR: Cannot find keyword!");
			error = "ERROR: Cannot find keyword!";
			return error;
		}
		/*-------------------------------------------------------
		 *********************************************************/
		return keyPosts;
	}
	
	public String displayUserPost(User user) {
		/*---------------------------ERROR CHECK-----------------*/
		String error; 
		String userPosts = "";
		boolean findUser = false; 
		for(int i = 0; i < posts.size(); i++) {
			if(posts.get(i).getUser() == user) {
				findUser = true;
			}
		}
		
		if(findUser == false) {
			System.out.println("ERROR: cannot find user!");
			error = "ERROR: cannot find user!";
			return error;
		}
		/*-------------------------------------------------------
		 *********************************************************/
		
		System.out.println("##### Displaying all posts for User ID: " + user.getUserID() + " #####");
		for(int i = 0; i < posts.size(); i++) {
			if(posts.get(i).getUser() == user) {
				System.out.println(posts.get(i).toString());
				userPosts += posts.get(i).toString();
			}
		}
		System.out.println("##############################\n");
		return userPosts;
	}
	
	public void displayThread(int postID) {
		Post root = null;
		for(int i = 0; i < posts.size(); i++) {
			if(posts.get(i).getPostID() == postID) {
				root = findParent(posts.get(i));
			}
		}
		System.out.println("##### Displaying thread for PostID: " + postID + " #####");
		System.out.println(root.toString());
		displayReplyThread(root);
		System.out.println("##############################\n");
		
	}
	
	public Post findParent(Post p) {
		if(p.getParentID() != -1) {
			for(int i = 0; i < posts.size(); i++) {
				if(posts.get(i).getPostID() == p.getParentID()) {
					p = findParent(posts.get(i));
				}
			}
		}
		return p;
	}
	
	public void displayReplyThread(Post p) {
		if(p.getPostReplies() != null) {
			for(int i = 0; i < p.getPostReplies().size(); i++) {
				System.out.println(p.getPostReplies().get(i).toString());
				displayReplyThread(p.getPostReplies().get(i));
			}
		}
	}

	
	public void registerUserTag(String tag, User user){
		String lowerTag = tag.toLowerCase();
		if(tagsUsers.containsKey(lowerTag)) {
			ArrayList<User> userList = tagsUsers.get(lowerTag);
			if(userList != null) {
				userList.add(user);
			}else {
				userList = new ArrayList<User>();
				userList.add(user);
				tagsUsers.put(lowerTag, userList);
			}
		}else {
			ArrayList<User> userList = new ArrayList<User>();
			userList.add(user);
			tagsUsers.put(lowerTag.toLowerCase(), userList);
		}
	}

	
	public void removeUserTag(String tag, User user){
		if(tagsUsers.containsKey(tag)) {
			System.out.println("^^^^^ Removing tag: " + tag + " for User ID: " + user.getUserID() + " ^^^^^");
			ArrayList<User> userList = tagsUsers.get(tag);
			if(userList != null) {
				for(int i = 0; i < userList.size(); i++) {
					if(userList.get(i) == user) {
						userList.remove(userList.get(i));
						return;
					}
				}
			}
			return;
		}
	}
	
	public void notifyUser(Post p) {
		LinkedHashMap<String, ArrayList<User>> lcTagsUsers = new LinkedHashMap<String, ArrayList<User>>();
        for (String key:tagsUsers.keySet()) {
            if (!lcTagsUsers.containsKey(key.toLowerCase()))
                lcTagsUsers.put(key.toLowerCase(), tagsUsers.get(key));
            else {
                lcTagsUsers.get(key.toLowerCase()).addAll(tagsUsers.get(key));
            }
        }
        ArrayList<User> usersNotified = new ArrayList<User>();
        for (int i = 0; i < p.getTags().size(); i++) {
            if (lcTagsUsers.containsKey(p.getTags().get(i).toLowerCase())) {
                usersNotified.addAll(lcTagsUsers.get(p.getTags().get(i).toLowerCase()));
            }
        }
        usersNotified.remove(p.getUser());
        for (int k = 0; k < usersNotified.size(); k++) {
            User userNotified = usersNotified.get(k);
            userNotified.update(p);
        }
	}
	
	public ArrayList<Post> getAllPosts() {
		return posts;
	}

}
