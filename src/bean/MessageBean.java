package bean;

import java.io.Serializable;

public class MessageBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String user;
	private String date;
	private String content;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setAll(String id, String user, String date, String content)
	{
		setId(id);
		setUser(user);
		setDate(date);
		setContent(content);
	}
	public String getAll()
	{
		return "id = " + id + " user = " + user + " content  = " + content + " date = " + date; 
	}
}
