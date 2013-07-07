package th.co.geek.dao;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import th.co.geek.bean.DatabaseKey;
import th.co.geek.bean.UserPost;
import th.co.geek.bean.UserProfile;

public class UserFollowDAO {
	private static UserFollowDAO _instance = new UserFollowDAO();
	
	private UserFollowDAO() {		
	}
	
	public static UserFollowDAO getInstance() {
		return _instance;
	}
	
	
// follow action 
	
	
	
	
	
	
// add + get follower
	public ArrayList<String> getFollowerList(String userName) throws Exception {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWER_PREFIX+userName;
		
		List<String> tmpFollowerList = jedis.lrange(key, 0, -1);
		return new ArrayList<String>(tmpFollowerList);
	}		
		
	public void addFollower(String userName, String follower) {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWER_PREFIX+userName;
		
		System.out.println("pusing follower :: "+follower);
		jedis.rpush(key, follower);
	}


// add + get following
	public ArrayList<String> getFollowingList(String userName) throws Exception {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWING_PREFIX+userName;
		
		List<String> tmpFollowingList = jedis.lrange(key, 0, -1);
		return new ArrayList<String>(tmpFollowingList);
	}		
		
	public void addFollowing(String userName, String following) {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWING_PREFIX+userName;
		
		System.out.println("pusing following :: "+following);
		jedis.rpush(key, following);
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
		
		
		UserFollowDAO a = new UserFollowDAO();
		
		a.addFollower("tha3k","ttttt2");
		System.out.println("all : "+a.getFollowerList("tha3k"));
	}

}
