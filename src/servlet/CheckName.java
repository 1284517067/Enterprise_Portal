package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.Factory;


/**
 * Servlet implementation class CheckName
 */
@WebServlet("/CheckName")
public class CheckName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckName() {
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
		String method = request.getParameter("method");
		if("login".equals(method))
		{
			System.out.println(method);
			try {
				FindUsr(request,response);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	public void FindUsr(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		response.setCharacterEncoding("UTF-8");
		String jsonResult = "";
		String username = request.getParameter("username");
		Connection con = null;
		System.out.println(username);
		try
		{
			con = DButils.getCon();
			if(username != null)
			{
				 
				 if(Factory.getUserServiceInstance().search(username))
				 {
					 jsonResult = "{\"valid\":true}";
					 System.out.println(jsonResult);
				 }
				 else
				 {
					 jsonResult = "{\"valid\":false}";
					 System.out.println(jsonResult);
				 }
			}
			else
			{
				 jsonResult = "{\"valid\":false}";	
				 System.out.println(jsonResult + "2");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButils.closeCon(con);
		}
		System.out.println(jsonResult);
		response.getWriter().write(jsonResult);
		
	}
	
	public static void main(String args[])
	{
		
	}
}
