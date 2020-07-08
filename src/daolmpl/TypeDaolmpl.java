package daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.NewsBean;
import bean.TypeBean;
import dao.TypeDao;
import servlet.DButils;

public class TypeDaolmpl implements TypeDao {

	@Override
	public boolean addtype(TypeBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into type values(?,?)";
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getId());
			ps.setString(2, n.getType());
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
	public boolean updatetype(TypeBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update type set type = ? where id = ?";
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getType());
			ps.setString(2, n.getId());
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
	public boolean deletetype(String id) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "delete from type where id = ?";
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
	public List<TypeBean> TypeList() throws Exception {
		// TODO 自动生成的方法存根
		List<TypeBean> list = new ArrayList<TypeBean>();
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from type";
		ResultSet rs = null;
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);		
			rs = ps.executeQuery();
			while(rs.next())
			{
				TypeBean n = new TypeBean();
				String id = rs.getString("id");
				String  type = rs.getString("type");
				n.setAll(id, type);
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
	public List<String> searchGroup(String obj) throws Exception {
		// TODO 自动生成的方法存根
		List<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select " + obj + " from type group by "+obj;
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

	@Override
	public TypeBean gettype(String id) throws Exception {
		// TODO 自动生成的方法存根
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from type where id = ?";
		TypeBean n = new TypeBean();
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
			n.setType(rs.getString("type"));
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

}
