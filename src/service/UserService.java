package service;

import java.sql.Connection;
import java.util.List;

import bean.UserBean;
import dao.UserDao;
import daolmpl.UserDaolmpl;
import servlet.DButils;

public class UserService implements UserDao {

	private Connection con = null;
	private UserDao userdao = null;
	
	
	public UserService() throws Exception
	{
		this.con = DButils.getCon();
		this.userdao = new UserDaolmpl();
	}
	
	@Override
	public boolean newUser(UserBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			
				flag = this.userdao.newUser(n);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeCon(this.con);
		}
		return flag;
	}

	@Override
	public boolean updateUser(UserBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			
				flag = this.userdao.updateUser(n);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			DButils.closeCon(this.con);
		}
		return flag;
	}

	@Override
	public UserBean getUesr(String usr) throws Exception {
		// TODO 自动生成的方法存根
		UserBean n = new UserBean();
		try
		{
			n = this.userdao.getUesr(usr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeCon(this.con);
		}
		return n;
	}

	@Override
	public boolean deleteUser(String usr) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			
				flag = this.userdao.deleteUser(usr);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeCon(this.con);
		}
		return flag;
	}

	@Override
	public List<UserBean> ListUser() throws Exception {
		// TODO 自动生成的方法存根
		List<UserBean> userlist = null;
		try
		{
			userlist = this.userdao.ListUser();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeCon(this.con);
		}
		return userlist;
	}

	

	@Override
	public boolean search(String obj) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try 
		{
			flag = this.userdao.search(obj);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public String search(String obj1, String value, String obj2) throws Exception {
		// TODO 自动生成的方法存根
		String flag = null;
		try
		{
			flag = this.userdao.search(obj1, value, obj2);
		}
		catch(Exception e)
		{
			System.out.println(flag);
			e.printStackTrace();
		}
		
		return flag;
	}

}
