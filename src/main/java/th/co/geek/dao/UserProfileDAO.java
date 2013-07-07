package th.co.geek.dao;

import java.util.ArrayList;
import java.util.Date;

import redis.clients.jedis.Jedis;
import th.co.geek.action.exception.UserNotfoundException;
import th.co.geek.bean.DatabaseKey;
import th.co.geek.bean.UserPost;
import th.co.geek.bean.UserProfile;

public class UserProfileDAO {
	private static UserProfileDAO _instance = new UserProfileDAO();
	
	private UserProfileDAO() {		
	}
	
	public static UserProfileDAO getInstance() {
		return _instance;
	}
	
	public UserProfile getUserProfile(String userName) throws Exception {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.USER_PREFIX+userName;
		
		if(jedis.exists(key)) {
			UserProfile userProfile = new UserProfile();
			userProfile.setName(jedis.hget(key, DatabaseKey.USER_NAME_KEY));
			userProfile.setPassword(jedis.hget(key, DatabaseKey.USER_PASSWORD_KEY));
			userProfile.setEmail(jedis.hget(key, DatabaseKey.USER_EMAIL_KEY));
			return userProfile;
		}
		else {	
			throw new UserNotfoundException();			
		}
    }		
		
		
	public void addUserProfile(UserProfile userProfile) {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);

		String key = DatabaseKey.USER_PREFIX+userProfile.getName();
		jedis.hset(key, DatabaseKey.USER_NAME_KEY, userProfile.getName());
		jedis.hset(key, DatabaseKey.USER_PASSWORD_KEY, userProfile.getPassword());
		jedis.hset(key, DatabaseKey.USER_EMAIL_KEY, userProfile.getEmail());
		
	}

	public UserProfile mockUserProfile() {
		UserProfile userProfile = new UserProfile();
		userProfile.setName("tha3k");
		userProfile.setPassword("111");
		userProfile.setEmail("tha3k@hotmail.com");
		
		ArrayList<UserPost> userPostList = new ArrayList<UserPost>();
		
		UserPost eachPost = new UserPost();
		eachPost.setPostUser("tha3k");
		eachPost.setPostDate("20130101");
		eachPost.setPostContent("test post for mock!!");
		eachPost.setCanDelete(false);
		
		userProfile.setPostList(userPostList);
		
		return userProfile;
	}	
	
	
	public static void main(String[] args) throws Exception {
		
		
		UserProfileDAO a = new UserProfileDAO();
		
		a.addUserProfile(a.mockUserProfile());
		UserProfile b = a.getUserProfile("tha3k");
		System.out.println(b.getName());
		System.out.println(b.getPassword());
		System.out.println(b.getEmail());
	}

}
