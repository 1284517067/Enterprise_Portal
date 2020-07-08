package bean;

import java.io.Serializable;

public class ProductBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String type;
	private String introduce;
	private String img;
	
	

	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getIntroduce() {
		return introduce;
	}



	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public void setAll(String Id,String Name,String Introduce,String Type,String Img)
	{
		setId(Id);
		setName(Name);
		setIntroduce(Introduce);
		setType(Type);
		setImg(Img);
	}

	public String getAll()
	{
		return "id = " + id + " name = " + name + " introduce =" + introduce + " type = " + type +" img = " + img;
	}
	
	public ProductBean()
	{
		
	}
}
