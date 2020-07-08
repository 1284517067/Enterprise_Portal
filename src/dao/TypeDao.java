package dao;

import java.util.List;

import bean.TypeBean;

public interface TypeDao {
	public boolean addtype(TypeBean n) throws Exception;
	public boolean updatetype(TypeBean n) throws Exception;
	public boolean deletetype(String id) throws Exception;
	public TypeBean gettype(String id) throws Exception;
	public List<TypeBean> TypeList() throws Exception;
	public List<String> searchGroup(String obj) throws Exception ;
}
