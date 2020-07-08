package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DButils {
	//JDBC驱动名 数据库URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/news?serverTimezone=UTC";
    //数据库用户名及密码
    private static final String USR = "root";
    private static final String PWD = "123456"; 
    
    
    /**
         * 与数据库建立连接
     */
    public static Connection getCon() throws Exception
    {
    	Class.forName(JDBC_DRIVER);
    	Connection con = DriverManager.getConnection(DB_URL, USR, PWD);
    	return con;
    }
    
   
    /**
         * 获取执行SQL语句返回的预编译PreparedStatement对象
     */
    public static PreparedStatement getPrepare(String sql) throws Exception
    {
    	PreparedStatement ps = null;
    	try 
    	{
    		Connection con = getCon();
    		ps = con.prepareStatement(sql);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return ps;
    }
    /**
         * 关闭修改数据库所用到的资源
     */
    public static void closeUpdate(PreparedStatement ps) throws Exception
    {
    	try
    	{
    		if(ps != null)
    		{
    			Connection con = ps.getConnection();
    			ps.close();
    			closeCon(con);
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    /**
         * 关闭查询数据库所用到的资源
     */
    public static void closeQuery(ResultSet rs)
    {
    	try
    	{
    		if(rs != null)
    		{
    			Statement stm = rs.getStatement();
    			rs.close();
    			if(stm != null)
    			{
    				Connection conn = stm.getConnection();
    				stm.close();
    				closeCon(conn);
    			}
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    /**
         * 关闭数据库连接
     */
    public static void closeCon(Connection con) throws Exception
    {
    	if(!con.isClosed())
    	{
    		con.close();
    	}
    	
    }
    
    public static void main(String []args) {
		
		try
		{
			Connection con = DButils.getCon();
			if(!con.isClosed())
			{
			System.out.println("数据库连接成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
