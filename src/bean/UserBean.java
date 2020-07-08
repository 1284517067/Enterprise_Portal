package bean;

import java.io.Serializable;

public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String UserName;
	private String Password;
	private String UserType;
	private String name;
	private String tel;
	private String email;
	
	public UserBean()
	{
		
	}
	
	public void setAll(String usr,String pwd,String name,String tel,String email,String type)
	{
		setUserName(usr);
		setPassword(pwd);
		setName(name);
		setTel(tel);
		setEmail(email);
		setUserType(type);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}
	
	public String getAll()
	{
		return "usr="+UserName+" pwd="+Password+" name="+name+" tel="+tel+" email="+email+" type="+UserType;
	}
	
	public boolean isEmpty()
	{
		boolean flag = false;
		if(this.UserName != null)
		{
			flag = true;
		}
		return flag;
	}
}
