package dao;

import java.util.List;

import bean.ProductBean;

public interface ProductDao {
	
	public boolean newProduct(ProductBean n) throws Exception;//增
	public boolean updateProduct(ProductBean n) throws Exception;//改
	public ProductBean getProduct(String id) throws Exception;//查
	public boolean deleteProduct(String id) throws Exception;//删
	public List<ProductBean> ListProducts() throws Exception;//查询所有产品
	public List<String> searchGroup(String obj) throws Exception;
	
	
}
