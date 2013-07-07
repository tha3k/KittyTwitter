package th.co.geek.action;

import th.co.geek.dao.UserFollowDAO;

public class FollowAction {

	public void follow(String userName, String targetUserName) throws Exception {
		UserFollowDAO.getInstance().addFollower(targetUserName, userName);
		UserFollowDAO.getInstance().addFollowing(userName, targetUserName);
	}
	
	public void unFollow(String userName, String password) throws Exception {
		return authenticate(userName, password);
	}

}
