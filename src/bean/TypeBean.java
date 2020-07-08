package bean;

import java.io.Serializable;

public class TypeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void setAll(String id,String type)
	{
		setId(id);
		setType(type);
	}
	public String getAll()
	{
		return "id = " + id + " type = " + type;
	}
	public TypeBean()
	{
		
	}

}
