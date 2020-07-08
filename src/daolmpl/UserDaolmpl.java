package daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.UserBean;
import dao.UserDao;
import servlet.DButils;

public class UserDaolmpl implements UserDao {
	
	
	
	public UserDaolmpl()
	{
		
	}
	
	@Override
	public boolean newUser(UserBean n) throws Exception {
		// TODO 自动生成的方法存根
		
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try
		{
			con = DButils.getCon();
			String sql = "insert into user values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, n.getUserName());
			ps.setString(2,n.getPassword());
			ps.setString(3,n.getName());
			ps.setString(4, n.getTel());
			ps.setString(5,n.getEmail());
			ps.setString(6,n.getUserType());
			if(ps.executeUpdate()>= 1 )
			{
				flag = true;
			}
		} 
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			DButils.closeUpdate(ps);
		}
		return flag;
	}

	@Override
	public boolean updateUser(UserBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "update user set  pwd = ?, name = ?, tel = ? , email = ? , type = ?  where user = ?";
		PreparedStatement ps = DButils.getPrepare(sql);
		try {
			ps.setString(1, n.getPassword());
			ps.setString(2, n.getName());
			ps.setString(3, n.getTel());
			ps.setString(4, n.getEmail());
			ps.setString(5, n.getUserType());
			ps.setString(6, n.getUserName());
			if(ps.executeUpdate()> 0 )
			{
				flag = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeUpdate(ps);
		}
		return flag;
	}

	@Override
	public UserBean getUesr(String usr) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "select * from user  where user = ?";
		PreparedStatement ps = DButils.getPrepare(sql);
		ResultSet rs = null;
		UserBean n = new UserBean();
		try
		{
			ps.setString(1, usr);
			//获取结果集对象
			rs = ps.executeQuery();
			//游标向下移动
			if(rs.next()) {
			//将结果写入UserBean中
			n.setUserName(rs.getString("user"));
			n.setPassword(rs.getString("pwd"));
			n.setName(rs.getString("name"));
			n.setTel(rs.getString("tel"));
			n.setEmail(rs.getString("email"));
			n.setUserType(rs.getString("type"));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println(n.getAll());
		}
	
		return n;
	}

	@Override
	public boolean deleteUser(String usr) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "delete from user where user=?";
		PreparedStatement ps = DButils.getPrepare(sql);
		try
		{
			ps.setString(1, usr);
			if(ps.executeUpdate() > 0)
			{
				flag = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeUpdate(ps);
		}
		return flag;
	}

	@Override
	public List<UserBean> ListUser() throws Exception {
		// TODO 自动生成的方法存根
		String sql = "select * from user";
		PreparedStatement ps = DButils.getPrepare(sql);
		ResultSet rs = null;
		
		List<UserBean> UserList = new ArrayList<UserBean>();
		try
		{
			rs = ps.executeQuery(sql);
	
			
			while(rs.next())
			{
				String usr = rs.getString("user");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String type = rs.getString("type");
				UserBean n = new UserBean();
				n.setAll(usr, pwd, name, tel, email, type);
				UserList.add(n);
		
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeQuery(rs);

		}
		return UserList;
	}

	public String search(String obj1,String value,String obj2) throws Exception
	{
		String obj = null;
		
		String sql = "select ? from user where ? = ?";
		PreparedStatement ps = DButils.getPrepare(sql);
		ResultSet rs = null;
		try
		{
			ps.setString(1, obj2);
			ps.setString(2, obj1);
			ps.setString(3,value);
			rs = ps.executeQuery();
			while(rs.next()) {
			obj = rs.getString(obj2);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeUpdate(ps);

		}
		
		return obj;
	}
	
	@Override
	public boolean search(String user) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "select user from user where user = ?"; 
		PreparedStatement ps = DButils.getPrepare(sql);
		ResultSet rs = null;
		try
		{
			ps.setString(1, user);
			rs = ps.executeQuery();
			if(rs.next())
			{
			flag = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

}
