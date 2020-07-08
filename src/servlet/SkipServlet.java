package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MessageBean;
import bean.NewsBean;
import bean.ProductBean;
import bean.UserBean;
import factory.Factory;

/**
 * Servlet implementation class SkipServlet
 */
@WebServlet("/SkipServlet")
public class SkipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkipServlet() {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String skip = request.getParameter("skip");
		if("Activity".equals(skip))
		{
			List<NewsBean> list = new ArrayList<NewsBean>();
			try
			{
				list = Factory.getNewsServiceInstance().ListNews();
				Collections.reverse(list);//倒置list
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			session.setAttribute("newslist", list);
			request.getRequestDispatcher("Activity.jsp").forward(request, response);
		}
		else if("News".equals(skip))
		{
			String id = request.getParameter("id");
			NewsBean n = new NewsBean();
			try
			{
				n = Factory.getNewsServiceInstance().getNews(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			session.setAttribute("news", n);
			request.getRequestDispatcher("News.jsp").forward(request, response);
		}
		else if("OfficalwWebSide".equals(skip))
		{
			request.getRequestDispatcher("OfficalwWebSide.jsp").forward(request, response);
		}
		else if("AdminControlTable".equals(skip))
		{
			if(session.getAttribute("usr") != null)
			{
				UserBean n = (UserBean) session.getAttribute("usr");
				
				System.out.println();
				String type = n.getUserType();
				System.out.println(type);
				if("管理员".equals(n.getUserType()))
				{
					request.getRequestDispatcher("AdminControlTable.jsp").forward(request, response);
				}
				else
				{
					
					session.setAttribute("message", "您没有权限访问此网页");
					request.getRequestDispatcher("OfficalwWebSide.jsp").forward(request, response);
				}
			}
			else
			{
				String url = request.getServletPath();
				session.setAttribute("message", "您还没有登录");
				request.getRequestDispatcher("OfficalwWebSide.jsp").forward(request, response);
			}
			
		}
		else if("Products".equals(skip))
		{
			List<ProductBean> list = new ArrayList<ProductBean>();
			try
			{
				list = Factory.getProductServiceInstance().ListProducts();
				Collections.reverse(list);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			session.setAttribute("productlist", list);
			request.getRequestDispatcher("Products.jsp").forward(request, response);
		}
		else if("Introduce".equals(skip))
		{
			
			request.getRequestDispatcher("Introduce.jsp").forward(request, response);
		}
		else if("Message".equals(skip))
		{
			List<MessageBean> list = new ArrayList<MessageBean>();
			try
			{
				list = Factory.getMessageServiceInstance().MessageList();
				Collections.reverse(list);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			session.setAttribute("Mlist", list);
			request.getRequestDispatcher("Messageboard.jsp").forward(request, response);
					
		}
		else if("login".equals(skip))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if("Support".equals(skip))
		{
			request.getRequestDispatcher("Support.jsp").forward(request, response);
		}
		else if("register".equals(skip))
		{
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else if("logout".equals(skip))
		{
			session.removeAttribute("usr");
			request.getRequestDispatcher("OfficalwWebSide.jsp").forward(request, response);
		}
		else if("product1".equals(skip))
		{
			String id = request.getParameter("id");
			ProductBean n = new ProductBean();
			try
			{
				n = Factory.getProductServiceInstance().getProduct(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			session.setAttribute("p", n);
			request.getRequestDispatcher("Product1.jsp").forward(request, response);
		}
		
	}

}
