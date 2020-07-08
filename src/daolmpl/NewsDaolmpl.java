package daolmpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.NewsBean;
import dao.NewsDao;
import servlet.DButils;



public class NewsDaolmpl implements NewsDao {

	@Override
	public boolean newNews(NewsBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into news values(?,?,?,?,?,?,?)";
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getId());
			ps.setString(2, n.getUser());
			ps.setString(3, n.getDate());
			ps.setString(4, n.getName());
			ps.setString(5, n.getContent());
			ps.setString(6, n.getNewsType());
			ps.setString(7, n.getImg());
			if(ps.executeUpdate() >= 1)
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
	 public boolean updateNews(NewsBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update news set user = ?, date = ?, name = ?, content = ?, type = ?, img = ? where id = ?";
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getUser());
			ps.setString(2, n.getDate());
			ps.setString(3, n.getName());
			ps.setString(4, n.getContent());
			ps.setString(5, n.getNewsType());
			ps.setString(6, n.getImg());
			ps.setString(7, n.getId());
			if(ps.executeUpdate() >= 1)
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
	public NewsBean getNews(String id) throws Exception {
		// TODO 自动生成的方法存根
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from news where id = ?";
		NewsBean n = new NewsBean();
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			//获取结果集对象
			rs = ps.executeQuery();
			//游标向下移动
			if(rs.next()){
			//将结果写入NewsBean中
			n.setId(rs.getString("id"));
			n.setUser(rs.getString("user"));
			n.setDate(rs.getString("date"));
			n.setName(rs.getString("name"));
			n.setContent(rs.getString("content"));
			n.setNewsType(rs.getString("type"));
			n.setImg(rs.getString("img"));
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
	public boolean deleteNews(String id) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "delete from news where id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			if(ps.executeUpdate() > 0)
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
	public List<NewsBean> ListNews() throws Exception {
		// TODO 自动生成的方法存根
		List<NewsBean> list = new ArrayList<NewsBean>();
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from news";
		ResultSet rs = null;
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);		
			rs = ps.executeQuery();
			while(rs.next())
			{
				NewsBean n = new NewsBean();
				String id = rs.getString("id");
				String user = rs.getString("user");
				String date = rs.getString("date");
				String name = rs.getString("name");
				String content = rs.getString("content");
				String  type = rs.getString("type");
				String img = rs.getString("img");
				n.setAll(id, user, date, name, content, type, img);
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
	
	@Override
	public List<String> searchGroup(String obj) throws Exception {
		// TODO 自动生成的方法存根
		List<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select " + obj + " from news group by "+obj;
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String obj1 = rs.getString(obj);
				list.add(obj1);
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
