package daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.NewsBean;
import bean.ProductBean;
import dao.ProductDao;
import servlet.DButils;

public class Productlmpl implements ProductDao {

	@Override
	public boolean newProduct(ProductBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into product values(?,?,?,?,?)";
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getId());
			ps.setString(2, n.getName());
			ps.setString(3, n.getIntroduce());
			ps.setString(4, n.getType());
			ps.setString(5, n.getImg());
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
	public boolean updateProduct(ProductBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update product set name = ? , content = ? , type = ? , img = ? where id = ?";
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, n.getName());
			ps.setString(2, n.getIntroduce());
			ps.setString(3, n.getType());
			ps.setString(4, n.getImg());
			ps.setString(5, n.getId());
			if(ps.executeUpdate() >=1 )
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
	public ProductBean getProduct(String id) throws Exception {
		// TODO 自动生成的方法存根
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from product where id = ?";
		ProductBean n = new ProductBean();
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
			n.setName(rs.getString("name"));
			n.setIntroduce(rs.getString("content"));
			n.setType(rs.getString("type"));
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
	public boolean deleteProduct(String id) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "delete from product where id = ?";
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
	public List<ProductBean> ListProducts() throws Exception {
		// TODO 自动生成的方法存根
		List<ProductBean> list = new ArrayList<ProductBean>();
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from product";
		ResultSet rs = null;
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);		
			rs = ps.executeQuery();
			while(rs.next())
			{
				ProductBean n = new ProductBean();
				String id = rs.getString("id");;
				String name = rs.getString("name");
				String content = rs.getString("content");
				String  type = rs.getString("type");
				String img = rs.getString("img");
				n.setAll(id, name, content, type, img);
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
		String sql = "select " + obj + " from product group by "+obj;
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
