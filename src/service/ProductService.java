package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import bean.NewsBean;
import bean.ProductBean;
import dao.ProductDao;
import daolmpl.Productlmpl;
import servlet.DButils;

public class ProductService implements ProductDao {

	private Connection con = null;
	private ProductDao productdao = null;
	
	public ProductService() throws Exception
	{
		this.con = DButils.getCon();
		this.productdao = new Productlmpl();
	}
	
	@Override
	public boolean newProduct(ProductBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.productdao.newProduct(n);
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
	public boolean updateProduct(ProductBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.productdao.updateProduct(n);
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
	public ProductBean getProduct(String id) throws Exception {
		// TODO 自动生成的方法存根

		ProductBean n = new ProductBean();
		try
		{
			n = this.productdao.getProduct(id);
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
	public boolean deleteProduct(String id) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.productdao.deleteProduct(id);
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
	public List<ProductBean> ListProducts() throws Exception {
		// TODO 自动生成的方法存根
		List<ProductBean> list = new ArrayList<ProductBean>();
		try
		{
			list = this.productdao.ListProducts();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeCon(this.con);
		}
		return list;
	}

	@Override
	public List<String> searchGroup(String obj) throws Exception {
		// TODO 自动生成的方法存根
		List<String> list = new ArrayList<String>();
		try
		{
			list = this.productdao.searchGroup(obj);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeCon(this.con);
		}
		return list;
	}

}
