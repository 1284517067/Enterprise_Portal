package bean;

import java.io.Serializable;
import java.sql.Date;

public class NewsBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String content;
	private String type;
	private String id;
	private String user;
	private String img;
	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id1) {
		id = id1;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String Img) {
		img = Img;
	}

	public String getName() {
		return name;
	}

	public void setName(String newsName) {
		name = newsName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String newsContent) {
		content = newsContent;
	}

	public String getNewsType() {
		return type;
	}

	public void setNewsType(String newsType) {
		type = newsType;
	}

	public void setAll(String Id,String User,String date1,String name,String Content, String Type,String Img)
	{
		setId(Id);
		setUser(User);
		setDate(date1);
		setName(name);
		setContent(Content);
		setNewsType(Type);
		setImg(Img);
	}
	
	public String getAll()
	{
		return "id = "+id+" , user = "+user+" , date = "+date+" , name = "+name+" , content = "+content+" , type = "+type+" , img = "+img;
	}
	
	public boolean isEmpty()
	{
		boolean flag = false;
		if(this.user != null)
		{
			flag = true;
		}
		return flag;
	}
	
	public NewsBean()
	{
		
	}

}
