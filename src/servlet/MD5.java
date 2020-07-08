package servlet;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	public static String getMD5String(String s)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			return new BigInteger(1,md.digest()).toString(16);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
