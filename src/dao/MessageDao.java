package dao;

import java.util.List;

import bean.MessageBean;

public interface MessageDao {
	public boolean newMessage(MessageBean n) throws Exception;//增
	public boolean updateMessage(MessageBean n) throws Exception;//改
	public MessageBean getMessage(String id) throws Exception;//查
	public boolean deleteMessage(String id) throws Exception;//删
	public List<MessageBean> MessageList() throws Exception;//查询所有留言
	
}
