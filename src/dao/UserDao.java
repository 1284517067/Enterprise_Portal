package dao;

import java.util.List;

import bean.UserBean;

public interface UserDao {
	public boolean newUser(UserBean n) throws Exception;//增（已测试）
	public boolean updateUser(UserBean n)throws Exception;//改（已测试）
	public UserBean getUesr(String usr)throws Exception;//查(整个用户)（已测试）
	public boolean search(String obj) throws Exception;//查(单个元素)（已测试）
	public String search(String obj1,String value, String obj2) throws Exception;//查(目标元素)(未解决)
	public boolean deleteUser(String usr)throws Exception;//删（已测试）
	public List<UserBean> ListUser()throws Exception;//查询所有User（已测试）
}
