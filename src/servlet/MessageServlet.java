package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MessageBean;
import bean.UserBean;
import factory.Factory;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if("add".equals(type))
		{
			if(session.getAttribute("usr") != null)
			{
				UserBean n = (UserBean) session.getAttribute("usr");
				String user = n.getUserName();
				String content = request.getParameter("M");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date date1 = new java.util.Date();
				String date = sdf.format(date1);
				MessageBean m = new MessageBean();
				String id = getMax();
				m.setAll(id, user, date, content);
				boolean flag = false;
				try
				{
					flag = Factory.getMessageServiceInstance().newMessage(m);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(flag)
				{
					out.print("<script>alert('发布成功');window.location.href='SkipServlet?skip=Message'</script>");
				}
				else
				{
					out.print("<script>alert('由于一些意料之外的错误导致您的留言发布失败，请重试');window.location.href='SkipServlet?skip=Message'</script>");
				}
				
			}
			else
			{
				out.print("<script>alert('请先登录'); window.location.href='SkipServlet?skip=login'</script>");
			}
		}
	}
	
	public String getMax()
	{
		String max = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select Max(id) from message";
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
