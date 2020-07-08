package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import bean.NewsBean;
import bean.ProductBean;
import bean.TypeBean;
import dao.TypeDao;
import daolmpl.TypeDaolmpl;
import servlet.DButils;

public class TypeService implements TypeDao {
	private Connection con = null;
	private TypeDao typedao = null;
	
	public TypeService() throws Exception
	{
		this.con = DButils.getCon();
		typedao = new TypeDaolmpl();
	}
	
	@Override
	public boolean addtype(TypeBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.typedao.addtype(n);
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
	public boolean updatetype(TypeBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.typedao.updatetype(n);
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
	public boolean deletetype(String id) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.typedao.deletetype(id);
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
	public List<TypeBean> TypeList() throws Exception {
		// TODO 自动生成的方法存根
		List<TypeBean> list = new ArrayList<TypeBean>();
		try
		{
			list = this.typedao.TypeList();
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
			list = this.typedao.searchGroup(obj);
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
	public TypeBean gettype(String id) throws Exception {
		// TODO 自动生成的方法存根
		TypeBean n = new TypeBean();
		try
		{
			n = this.typedao.gettype(id);
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

}
