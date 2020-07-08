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
import bean.UserBean;
import factory.Factory;

/**
 * Servlet implementation class NewsServlet
 */
@MultipartConfig(location = "/upload")
@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		
		if("addF".equals(type))
		{
			String message = "";
			boolean flag = addnews(request,response);
			if(flag)
			{
				List<String> list1 = new ArrayList<String>();
				System.out.println("true");
				try
				{
					list1 = Factory.getNewsServiceInstance().searchGroup("type");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				request.setAttribute("Ntypelist", list1);
				message = "发布成功";
				session.setAttribute("message", message);
				request.getRequestDispatcher("addNews.jsp").forward(request, response);
			}
			else
			{
				System.out.println("false");
				message = "发布失败";
				session.setAttribute("message", message);
				request.getRequestDispatcher("addNews.jsp").forward(request, response);
			}
		}
		else if("add".equals(type))
		{
			List<String> list1 = new ArrayList<String>();
			try
			{
				list1 = Factory.getNewsServiceInstance().searchGroup("type");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			request.setAttribute("Ntypelist", list1);
			request.getRequestDispatcher("addNews.jsp").forward(request, response);
		}
		else if("update1".equals(type))
		{
			List<NewsBean> list = new ArrayList<NewsBean>();
			
			try {
				list = Factory.getNewsServiceInstance().ListNews();
				
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			request.setAttribute("newlist", list);
			request.getRequestDispatcher("updateNews.jsp").forward(request, response);
		}
		else if("update2".equals(type))
		{
			List<String> list1 = new ArrayList<String>();
			String id = request.getParameter("id");
			NewsBean n = new NewsBean();
			try {
				n = Factory.getNewsServiceInstance().getNews(id);
				list1 = Factory.getNewsServiceInstance().searchGroup("type");
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			request.setAttribute("Ntypelist", list1);
			request.setAttribute("news", n);
			request.getRequestDispatcher("updateNews1.jsp").forward(request, response);
		}
		else if("update3".equals(type))
		{
			String message = "";
			boolean flag = updatenews(request,response); 
			if(flag)
			{
				message = "修改成功";
				session.setAttribute("message", message);
				List<NewsBean> list = new ArrayList<NewsBean>();
				
				try {
					list = Factory.getNewsServiceInstance().ListNews();
					
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				request.setAttribute("newlist", list);
				request.getRequestDispatcher("updateNews.jsp").forward(request, response);
			}
			else
			{
				message = "修改失败";
				session.setAttribute("message", message);
				List<NewsBean> list = new ArrayList<NewsBean>();
				
				try {
					list = Factory.getNewsServiceInstance().ListNews();
					
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			
				request.setAttribute("newlist", list);
				request.getRequestDispatcher("updateNews.jsp").forward(request, response);
		
			}
		}
		else if("delete".equals(type))
		{
			List<NewsBean> list = new ArrayList<NewsBean>();
			
			try {
				list = Factory.getNewsServiceInstance().ListNews();
				
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			request.setAttribute("newlist", list);
			request.getRequestDispatcher("deleteNews.jsp").forward(request, response);
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
				List<NewsBean> list = new ArrayList<NewsBean>();
				
				try {
					list = Factory.getNewsServiceInstance().ListNews();
					
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				request.setAttribute("newlist", list);
				request.getRequestDispatcher("deleteNews.jsp").forward(request, response);
				
			}
			else
			{
				message = "删除失败";
				session.setAttribute("message", message);
				List<NewsBean> list = new ArrayList<NewsBean>();
				
				try {
					list = Factory.getNewsServiceInstance().ListNews();
					
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			
				request.setAttribute("newlist", list);
				request.getRequestDispatcher("deleteNews.jsp").forward(request, response);
			}
			
		}
		
		
	}

	protected boolean addnews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
			String user = "default";
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
		
			UserBean u = (UserBean) session.getAttribute("usr");
			if(u != null)
			{
				user = u.getName();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date utildate = new java.util.Date();
			String date = sdf.format(utildate);
			String type = request.getParameter("Ctype");
			String id = getMax();
			NewsBean  n = new NewsBean();
			n.setAll(id, user, date, title, content, type, img);
			System.out.println(n.getAll());
		
			flag = Factory.getNewsServiceInstance().newNews(n);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	protected boolean updatenews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Part part;
		boolean flag = false;
		try
		{
			String id = request.getParameter("Nid");
			String title = request.getParameter("title");
			System.out.println(title);
			String content = request.getParameter("content");
			System.out.println(content);
			String img = null;
			String user = "default";
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
				img = Factory.getNewsServiceInstance().getNews(id).getImg();
			}
		
			UserBean u = (UserBean) session.getAttribute("usr");
			if(u != null)
			{
				user = u.getName();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date utildate = new java.util.Date();
			String date = sdf.format(utildate);
			String type = request.getParameter("Ctype");
			NewsBean  n = new NewsBean();
			n.setAll(id, user, date, title, content, type, img);
			System.out.println(n.getAll());
		
			flag = Factory.getNewsServiceInstance().updateNews(n);
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
		String sql = "select Max(id) from news";
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
