package daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.MessageBean;
import bean.TypeBean;
import dao.MessageDao;
import servlet.DButils;

public class MessageDaolmpl implements MessageDao {

	@Override
	public boolean newMessage(MessageBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into message values(?,?,?,?)";
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getId());
			ps.setString(2, n.getUser());
			ps.setString(3, n.getContent());
			ps.setString(4, n.getDate());
			if(ps.executeUpdate() > 0 )
			{
				flag = true;
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
		return flag;
	}

	@Override
	public boolean updateMessage(MessageBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update message set user = ? , content = ? , date = ? where id = ?";
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getUser());
			ps.setString(2, n.getContent());
			ps.setString(3, n.getDate());
			ps.setString(4, n.getId());
			if(ps.executeUpdate() > 0 )
			{
				flag = true;
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
		return flag;
	}

	@Override
	public MessageBean getMessage(String id) throws Exception {
		// TODO 自动生成的方法存根
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from meassage where id = ?";
		MessageBean n = new MessageBean();
		try 
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next())
			{
				n.setId(rs.getString("id"));
				n.setUser(rs.getString("user"));
				n.setContent(rs.getString("content"));
				n.setDate(rs.getString("date"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeQuery(rs);
		}
		return n;
	}

	@Override
	public boolean deleteMessage(String id) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "delete from message where id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			if(ps.executeUpdate() > 0 )
			{
				flag = true;
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
		return flag;
	}

	@Override
	public List<MessageBean> MessageList() throws Exception {
		// TODO 自动生成的方法存根
		List<MessageBean> list = new ArrayList<MessageBean>();
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from message";
		ResultSet rs = null;
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				MessageBean n = new MessageBean();
				String id = rs.getString("id");
				String user = rs.getString("user");
				String content = rs.getString("content");
				String date = rs.getString("date");
				n.setAll(id, user, date, content);
				list.add(n);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeQuery(rs);
		}
		return list;
	}

}
