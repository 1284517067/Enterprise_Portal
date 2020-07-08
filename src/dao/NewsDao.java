package dao;

import java.util.List;

import bean.NewsBean;

public interface NewsDao {
	public boolean newNews(NewsBean n) throws Exception;//增（已测试）
	public boolean updateNews(NewsBean n) throws Exception;//改（已测试）
	public NewsBean getNews(String id) throws Exception;//查（已测试）
	public boolean deleteNews(String id) throws Exception;//删（已测试）
	public List<NewsBean> ListNews() throws Exception;//查询所有新闻（已测试）
	
	public List<String> searchGroup(String obj) throws Exception; 
	
}
