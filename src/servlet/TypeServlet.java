package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.TypeBean;
import factory.Factory;

/**
 * Servlet implementation class TypeServlet
 */
@WebServlet("/TypeServlet")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeServlet() {
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
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		if("add".equals(type))
		{
			request.getRequestDispatcher("addType.jsp").forward(request, response);
		}
		else if("addF".equals(type))
		{
			String message = "";
			String type1 = request.getParameter("chance");
			String id = getMax();
			TypeBean n = new TypeBean();
			n.setAll(id, type1);
			boolean flag = false;
			try {
				flag = Factory.getTypeServiceInstance().addtype(n);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(flag)
			{
				message = "发布成功";
				session.setAttribute("message", message);
				request.getRequestDispatcher("addType.jsp").forward(request, response);
			}
			else
			{
				message = "发布失败";
				session.setAttribute("message", message);
				request.getRequestDispatcher("addType.jsp").forward(request, response);
			}
		}
		else if("update".equals(type))
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
			session.setAttribute("Tlist", list);
			request.getRequestDispatcher("updateType.jsp").forward(request, response);
		}
		else if("update1".equals(type))
		{
			String id = request.getParameter("id");
			TypeBean n = new TypeBean();
			
			try
			{
				n = Factory.getTypeServiceInstance().gettype(id);
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			request.setAttribute("Tbean", n);
			request.getRequestDispatcher("updateType1.jsp").forward(request, response);
		
		}
		else if("update2".equals(type))
		{
			String input = request.getParameter("chance");
			String id = request.getParameter("Tid");
			TypeBean n = new TypeBean();
			String message = "";
			boolean flag = false;
			n.setAll(id, input);
			try
			{
				flag = Factory.getTypeServiceInstance().updatetype(n);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(flag)
			{
				message = "修改成功";
				List<TypeBean> list = new ArrayList<TypeBean>();
				try
				{
					list = Factory.getTypeServiceInstance().TypeList();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				session.setAttribute("message", message);
				session.setAttribute("Tlist", list);
				request.getRequestDispatcher("updateType.jsp").forward(request, response);
		
			}
			else
			{
				message = "修改失败";
				List<TypeBean> list = new ArrayList<TypeBean>();
				try
				{
					list = Factory.getTypeServiceInstance().TypeList();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				session.setAttribute("message", message);
				session.setAttribute("Tlist", list);
				request.getRequestDispatcher("updateType.jsp").forward(request, response);
		
			}
					
		}
		else if("delete".equals(type))
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
			session.setAttribute("Tlist", list);
	
			request.getRequestDispatcher("deleteType.jsp").forward(request, response);
		}
		else if("delete1".equals(type))
		{
			String message = "";
			String id = request.getParameter("id");
			boolean flag = false;
			try
			{
				flag = Factory.getTypeServiceInstance().deletetype(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(flag)
			{
				message = "删除成功";
				List<TypeBean> list = new ArrayList<TypeBean>();
				try
				{
					list = Factory.getTypeServiceInstance().TypeList();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				session.setAttribute("message", message);
				session.setAttribute("Tlist", list);
				request.getRequestDispatcher("deleteType.jsp").forward(request, response);
		
			}
			else
			{
				message = "删除失败";
				List<TypeBean> list = new ArrayList<TypeBean>();
				try
				{
					list = Factory.getTypeServiceInstance().TypeList();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				session.setAttribute("message", message);
				session.setAttribute("Tlist", list);
				request.getRequestDispatcher("deleteType.jsp").forward(request, response);
		
			}
			
		}
	}

	public String getMax()
	{
		String max = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select Max(id) from type";
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
	 
}
