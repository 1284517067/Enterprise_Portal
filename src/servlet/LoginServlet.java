package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import factory.Factory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//JDBC驱动名 数据库URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/news?serverTimezone=UTC";
    //数据库用户名及密码
    static final String USR = "root";
    static final String PWD = "123456"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.setCharacterEncoding("UTF-8");
		try {
			login(request,response);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void login (HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Connection con;
		try
		{
			con = DButils.getCon();
			if(!con.isClosed())
			{
				String user = request.getParameter("username");
				String pwd = request.getParameter("pwd");
				if(Factory.getUserServiceInstance().search(user))
				{
					UserBean n = new UserBean();
					n = Factory.getUserServiceInstance().getUesr(user);
					System.out.println(pwd);
					System.out.println(n.getUserType());
					System.out.println(n.getPassword());
					pwd = MD5.getMD5String(pwd);
					System.out.println(pwd);
					if(pwd.equals(n.getPassword()))
					{
						session.setAttribute("usr", n);
						System.out.println("密码正确");
						response.sendRedirect("SkipServlet?skip=OfficalwWebSide");
					}
					else {
						System.out.println("密码错误");
						session.setAttribute("message", "密码错误");
						request.getRequestDispatcher("SkipServlet?skip=login").forward(request, response);
					}
				}else
				{
					System.out.println("用户名不存在");
					session.setAttribute("message", "用户名不存在");
					request.getRequestDispatcher("SkipServlet?skip=login").forward(request, response);
				}
			}
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}	
}
