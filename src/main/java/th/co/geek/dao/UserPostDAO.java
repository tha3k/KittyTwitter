package th.co.geek.dao;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import th.co.geek.action.exception.UserNotfoundException;
import th.co.geek.bean.DatabaseKey;
import th.co.geek.bean.UserPost;
import th.co.geek.bean.UserProfile;

public class UserPostDAO {
	private static UserPostDAO _instance = new UserPostDAO();
	
	private UserPostDAO() {		
	}
	
	public static UserPostDAO getInstance() {
		return _instance;
	}
	
	public void addUserPost(String userName, UserPost userPost) throws Exception {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.POST_PREFIX+userName;
		
		System.out.println("pusing post :: "+getUserPostString(userPost));
		jedis.lpush(key, getUserPostString(userPost));
    }		
	
	public ArrayList<UserPost> getUserPostList(String userName) throws Exception {
		ArrayList<UserPost> userPostList = new ArrayList<UserPost>();
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.POST_PREFIX+userName;
		
		if(jedis.exists(key)) {
			List<String> tmpUserPostList = jedis.lrange(key, 0, 50);
			for (int i=0;i<tmpUserPostList.size();i++) {
				System.out.println("geting post :: "+tmpUserPostList.get(i));
				userPostList.add(getUserPost(tmpUserPostList.get(i)));
			}
		}
		else {	
			throw new UserNotfoundException();			
		}
		return userPostList;
    }			
	
	public UserPost getUserPost(String strUserPost) throws Exception {
		String[] userPostArr = strUserPost.split(DatabaseKey.KEY_SEPERATER);
		
		UserPost userPost = new UserPost();
		userPost.setPostUser(userPostArr[0]);
		userPost.setPostDate(userPostArr[1]);
		userPost.setPostContent(userPostArr[2]);
		
		return userPost;
	}
	
	public String getUserPostString(UserPost userPost) throws Exception {
		return  userPost.getPostUser()+(DatabaseKey.KEY_SEPERATER)+
				userPost.getPostDate()+(DatabaseKey.KEY_SEPERATER)+
				userPost.getPostContent();
	}

	public UserPost mockUserPost() {
		UserPost eachPost = new UserPost();
		eachPost.setPostUser("tha3k");
		eachPost.setPostDate("20130101");
		eachPost.setPostContent("test post for mock!!");
		eachPost.setCanDelete(false);
		
		return eachPost;
	}	
	
	public static void main(String[] args) throws Exception {
		UserPostDAO.getInstance().addUserPost("tha3k", UserPostDAO.getInstance().mockUserPost());
		UserPostDAO.getInstance().getUserPostList("tha3k");
	}
	
}
