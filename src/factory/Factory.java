package factory;

import dao.MessageDao;
import dao.NewsDao;
import dao.ProductDao;
import dao.TypeDao;
import dao.UserDao;
import service.MessageService;
import service.NewsService;
import service.ProductService;
import service.TypeService;
import service.UserService;

public class Factory {

	public static UserDao getUserServiceInstance() throws Exception
	{
		return new UserService();
	}
	
	public static NewsDao getNewsServiceInstance() throws Exception
	{
		return new NewsService();
	}
	public static ProductDao getProductServiceInstance() throws Exception
	{
		return new ProductService();
	}
	public static TypeDao getTypeServiceInstance() throws Exception
	{
		return new TypeService();
	}
	public static MessageDao getMessageServiceInstance() throws Exception
	{
		return new MessageService();
	}
}
