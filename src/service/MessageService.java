package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import bean.MessageBean;
import bean.ProductBean;
import dao.MessageDao;
import dao.ProductDao;
import daolmpl.MessageDaolmpl;
import servlet.DButils;

public class MessageService implements MessageDao {

	private Connection con = null;
	private MessageDao messagedao = null;
	
	public MessageService() throws Exception
	{
		this.con = DButils.getCon();
		this.messagedao = new MessageDaolmpl();
	}
	
	@Override
	public boolean newMessage(MessageBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.messagedao.newMessage(n);
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
	public boolean updateMessage(MessageBean n) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.messagedao.updateMessage(n);
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
	public MessageBean getMessage(String id) throws Exception {
		// TODO 自动生成的方法存根
		MessageBean n = new MessageBean();
		try
		{
			n = this.messagedao.getMessage(id);
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
	public boolean deleteMessage(String id) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		try
		{
			flag = this.messagedao.deleteMessage(id);
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
	public List<MessageBean> MessageList() throws Exception {
		// TODO 自动生成的方法存根
		List<MessageBean> list = new ArrayList<MessageBean>();
		try
		{
			list = this.messagedao.MessageList();
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
