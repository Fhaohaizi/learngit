package selenium;

import java.io.*;
import java.sql.*;

public class MySql extends Base{
	//start 驱动程序名
	static String driver = "com.mysql.jdbc.Driver";
	// URL指向要访问的数据库名scutcs
	static String url = "jdbc:mysql://192.168.1.14:3306/DZJY";
	// MySQL配置时的用户名
	static String user = "root"; 
	// MySQL配置时的密码
	static String password = "efa803254d";
	//end
	
	//删除用户
	public static void deleteUserByMobile(String mobile) throws ClassNotFoundException, SQLException, IOException {
		// 加载驱动程序
		Class.forName(driver);
		// 连接数据库
		Connection conn = DriverManager.getConnection(url, user, password);
		if(!conn.isClosed()){
			output("Succeeded connecting to the Database!");
			//statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "delete from users where mobile = "+ mobile;
            output(sql);
            statement.executeQuery(sql);
			saveToFile(getNow()+sql, "runlog.log", false);
            conn.close();
            }else {
            	output("failed connecting to the Database!");
            	}
		}
	//获取最新token
	public static String getNewToken(String mobile) throws ClassNotFoundException, SQLException, IOException {
		// 加载驱动程序
		Class.forName(driver);
		// 连接数据库
		Connection conn = DriverManager.getConnection(url, user, password);
		if(!conn.isClosed()) 
			System.out.println("Succeeded connecting to the Database!");
			//statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "select * from users where mobile = "+ mobile;
            output(sql);
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
            System.out.println("查询结果如下所示:");
            System.out.println("验证码ID" + "\t" + "验证码");
            String id = null;
            while(rs.next()) {
            	// 选择列数据
            	id = rs.getString("id");
            	// 输出结果
            	System.out.println(rs.getString("id") + "\t" + id);
            	}
            rs.close();
            String sql2 = "select * from users_token where uid = "+ id + " ORDER BY create_time DESC LIMIT 1";
            ResultSet rs2 = statement.executeQuery(sql2);
            String token = null;
            System.out.println("查询结果如下所示:");
            while(rs2.next()){
            	token = rs2.getString(token);
            	output(token);
            	saveToFile(getNow() + token, "runlog.log", false);
            }
            conn.close();
            return token;
		}	
	//获取短信验证码
	public static String getMobileCode(String mobile) throws ClassNotFoundException, SQLException, IOException {
		// 加载驱动程序
		Class.forName(driver);
		// 连接数据库
		Connection conn = DriverManager.getConnection(url, user, password);
		if(!conn.isClosed()) 
			System.out.println("Succeeded connecting to the Database!");
			//statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "select * from verify where mobile = "+ mobile + " ORDER BY create_time DESC LIMIT 1";
            output(sql);
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
            System.out.println("查询结果如下所示:");
            System.out.println("验证码ID" + "\t" + "验证码");
            String code = null;
            while(rs.next()) {
            	// 选择列数据
            	code = rs.getString("verify");
            	// 输出结果
            	System.out.println(rs.getString("id") + "\t" + code);
            	saveToFile(getNow()+rs.getString("id") + "\t" + code, "runlog.log", false);
            	}
            rs.close();
            conn.close();
            return code;
		}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
