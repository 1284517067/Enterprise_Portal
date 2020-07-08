package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.NewsBean;
import bean.ProductBean;
import bean.TypeBean;
import bean.UserBean;
import factory.Factory;

/**
 * Servlet implementation class ProductServlet
 */
@MultipartConfig(location = "/upload")
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session  = request.getSession();
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if("add".equals(type))
		{
			List<TypeBean> list = new ArrayList<TypeBean>();
			try 
			{
				list = Factory.getTypeServiceInstance().TypeList();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			request.setAttribute("Ptypelist", list);
			request.getRequestDispatcher("addProduct.jsp").forward(request, response);
		}
		else if("addF".equals(type))
		{
			String message = ""; 
			boolean flag = addProduct(request,response);
			if(flag)
			{
				List<TypeBean> list = new ArrayList<TypeBean>();
				System.out.println("true");
				try
				{
					list = Factory.getTypeServiceInstance().TypeList();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				request.setAttribute("Ptypelist", list);
				message = "发布成功";
				session.setAttribute("message", message);
				request.getRequestDispatcher("addProduct.jsp").forward(request, response);

			}
			else
			{
				System.out.println("false");
				message = "发布失败";
				session.setAttribute("message", message);
				request.getRequestDispatcher("addProduct.jsp").forward(request, response);
		
			}
		}
		else if("update".equals(type))
		{
			List<ProductBean> list = new ArrayList<ProductBean>();
			
			try {
				list = Factory.getProductServiceInstance().ListProducts();
				
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			request.setAttribute("Plist", list);
			request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
	
		}
		else if("update1".equals(type))
		{
			List<TypeBean> list = new ArrayList<TypeBean>();
			String id = request.getParameter("id");
			ProductBean n = new ProductBean();
			try {
				n = Factory.getProductServiceInstance().getProduct(id);
				list = Factory.getTypeServiceInstance().TypeList();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			request.setAttribute("Ptypelist", list);
			request.setAttribute("product", n);
			request.getRequestDispatcher("updateProduct1.jsp").forward(request, response);
		
		}
		else if("update2".equals(type))
		{
			String message = "";
			boolean flag = updateProduct(request,response); 
			if(flag)
			{
				message = "修改成功";
				session.setAttribute("message", message);
				List<ProductBean> list = new ArrayList<ProductBean>();
				
				try {
					list = Factory.getProductServiceInstance().ListProducts();
					
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				request.setAttribute("Plist", list);
				request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
			}
			else
			{
				message = "修改失败";
				session.setAttribute("message", message);
				List<ProductBean> list = new ArrayList<ProductBean>();
				
				try {
					list = Factory.getProductServiceInstance().ListProducts();
					
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			
				request.setAttribute("Plist", list);
				request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
		
			}
		}
		else if("delete".equals(type))
		{
			List<ProductBean> list = new ArrayList<ProductBean>();
			
			try {
				list = Factory.getProductServiceInstance().ListProducts();
				
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			request.setAttribute("Plist", list);
			request.getRequestDispatcher("deleteProduct.jsp").forward(request, response);
	
		}
		else if("delete1".equals(type))
		{
			String message = "";
			String id = request.getParameter("id");
			boolean flag = false;
			try {
				flag = Factory.getNewsServiceInstance().deleteNews(id);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(flag)
			{
				message = "删除成功";
				session.setAttribute("message", message);
				List<ProductBean> list = new ArrayList<ProductBean>();
				
				try {
					list = Factory.getProductServiceInstance().ListProducts();
					
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				request.setAttribute("Plist", list);
				request.getRequestDispatcher("deleteProduct.jsp").forward(request, response);
				
			}
			else
			{
				message = "删除失败";
				session.setAttribute("message", message);
				List<ProductBean> list = new ArrayList<ProductBean>();
				
				try {
					list = Factory.getProductServiceInstance().ListProducts();
					
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			
				request.setAttribute("Plist", list);
				request.getRequestDispatcher("deleteProduct.jsp").forward(request, response);
			}
			
		}
		
	}

	protected boolean addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Part part;
		boolean flag = false;
		try
		{
			
			String title = request.getParameter("title");
			System.out.println(title);
			String content = request.getParameter("content");
			System.out.println(content);
			String img = null;
			
			String filename = null;
			//上传图片
			part = request.getPart("customFile");
			
			filename = getFilename(part);
			if(!filename.isEmpty())
			{
				System.out.println(filename);
				part.write(filename);
				img = filename;
			}
		
			
			String type = request.getParameter("Ctype");
			String id = getMax();
			ProductBean  n = new ProductBean();
			n.setAll(id, title, content, type, img);
			System.out.println(n.getAll());
		
			flag = Factory.getProductServiceInstance().newProduct(n);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	protected boolean updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Part part;
		boolean flag = false;
		try
		{
			String id = request.getParameter("Pid");
			String title = request.getParameter("title");
			System.out.println(title);
			String content = request.getParameter("content");
			System.out.println(content);
			String img = null;
			String filename = null;
			//上传图片
			part = request.getPart("customFile");
			filename = getFilename(part);
			if(!filename.isEmpty())
			{
				System.out.println(filename);
				part.write(filename);
				img = filename;
			}
			else
			{
				img = Factory.getProductServiceInstance().getProduct(id).getImg();
			}
		
			
			
			String type = request.getParameter("Ctype");
			ProductBean  n = new ProductBean();
			n.setAll(id, title, content, type, img);
			System.out.println(n.getAll());
		
			flag = Factory.getProductServiceInstance().updateProduct(n);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public String getMax()
	{
		String max = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select Max(id) from product";
		try
		{
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				max = rs.getString("Max(id)");
			}
			int i = Integer.parseInt(max)+1;
			max = i+"";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(max);
		}
		finally
		{
			DButils.closeQuery(rs);
		}
		return max;
	}
	 

	public String getFilename(Part part)
	{
		String header = part.getHeader("Content-Disposition");
		String filename = header.substring(header.indexOf("filename=\"") + 10 , header.lastIndexOf("\"") );
		return filename;
	}
	
	
}
