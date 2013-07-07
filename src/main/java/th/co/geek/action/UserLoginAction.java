package th.co.geek.action;

import java.util.ArrayList;
import java.util.Date;

import th.co.geek.bean.UserPost;
import th.co.geek.bean.UserProfile;

public class UserLoginAction {

	public UserProfile login(String userName, String password) throws Exception {
		return mockUserProfile();
	}
	
	
	public UserProfile mockUserProfile() {
		UserProfile userProfile = new UserProfile();
		userProfile.setName("tha3k");
		userProfile.setEmail("tha3k@hotmail.com");
		
		
		ArrayList<UserPost> userPostList = new ArrayList<UserPost>();
		
		UserPost eachPost = new UserPost();
		eachPost.setPostUser("tha3k");
		eachPost.setPostDate(new Date());
		eachPost.setPostContent("test post for mock!!");
		eachPost.setCanDelete(false);
		
		userProfile.setPostList(userPostList);
		
		return userProfile;
	}

}
