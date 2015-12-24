package cn.panda.utils;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	/*private static Properties config = new Properties();
	static {
		try {
			config.load(JdbcUtils.class.getClassLoader().getResourceAsStream(
					"db.properties"));
			Class.forName(config.getProperty("driver"));
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
*/
	
	
	public static Connection getConnection() throws SQLException {
		
		
	return C3p0utils.getConnection();
		
		/*return DriverManager.getConnection(config.getProperty("url"),
				config.getProperty("username"), config.getProperty("password"));*/
	}


	public static void release(Connection conn, Statement st, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close(); // throw new
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			st = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

//1.加载驱动
//static{	
//	try {
//		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}

////2.获取连接
//return DriverManager.getConnection("jdbc:mysql://localhost:3306/day16_customer", "root",
//			"123456");
//}