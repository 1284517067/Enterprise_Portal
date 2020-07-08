package servlet;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import bean.NewsBean;
import bean.UserBean;
import factory.Factory;

public class testSQL {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		
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
			
			System.out.println(max);
	}

}
