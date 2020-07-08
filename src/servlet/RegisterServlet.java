package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.UserDao;
import factory.Factory;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		check(request,response);
	}

	public void check (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
	
		try {
			
				String user = request.getParameter("usr");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				String usrtype;
				String message = "";
				
					
					if(!Factory.getUserServiceInstance().search(user))
					{
						if("666666".equals(request.getParameter("type")))
						{
							usrtype = "管理员";
						}
						else
						{
							usrtype = "用户";
						}
						UserBean n = new UserBean();
						pwd = MD5.getMD5String(pwd);
						n.setAll(user, pwd, name, tel, email, usrtype);
						Factory.getUserServiceInstance().newUser(n);
						session.setAttribute("usr", n);			
						message = "注册成功";
						session.setAttribute("message",message);
						request.getRequestDispatcher("SkipServlet?skip=OfficalwWebSide").forward(request, response);
					}
					else
					{
						message = "用户名已存在";
						session.setAttribute("message", message);
						request.getRequestDispatcher("SkipServlet?skip=register").forward(request, response);
					}
	
			}
		
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		}
	
	
}
