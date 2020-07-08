package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import bean.NewsBean;
import dao.NewsDao;
import daolmpl.NewsDaolmpl;
import servlet.DButils;

public class NewsService implements NewsDao {

	private Connection con = null;
	private NewsDao newsdao = null;
	
	public NewsService() throws Exception
	{
		this.con = DButils.getCon();
		newsdao = new NewsDaolmpl();
	}
	
	@Override
	public boolean newNews(NewsBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.newsdao.newNews(n);
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
	public boolean updateNews(NewsBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.newsdao.updateNews(n);
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
	public NewsBean getNews(String id) throws Exception {
		// TODO 自动生成的方法存根
		NewsBean n = new NewsBean();
		try
		{
			n = this.newsdao.getNews(id);
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
	public boolean deleteNews(String id) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.newsdao.deleteNews(id);
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
	public List<NewsBean> ListNews() throws Exception {
		// TODO 自动生成的方法存根
		List<NewsBean> list = new ArrayList<NewsBean>();
		try
		{
			list = this.newsdao.ListNews();
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
			list = this.newsdao.searchGroup(obj);
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
