package mytest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.*;

public class JEBCTest {
	public static void main(String[] args){
		String table ="", column = "";int mobile = 0;
		new JEBCTest(table, column, mobile);
	}
	public JEBCTest(String table, String column, int mobile) {
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://192.168.1.14:3306/DZJY";
		// MySQL配置时的用户名
		String user = "root"; 
		// MySQL配置时的密码
		String password = "efa803254d";
		 System.out.println("-----------------");
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 连续数据库
			Connection conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()) 
				System.out.println("Succeeded connecting to the Database!");
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "select * from "+ table + " where id = "+ mobile;
//			System.out.println(sql);
            // 结果集
			ResultSet rs = statement.executeQuery(sql);
            System.out.println("查询结果如下所示:");
//            System.out.println("" + "\t" + "");
            String name = null;
            while(rs.next()) {
            	// 选择列数据
            	name = rs.getString(column);
            	// 输出结果
            	System.out.println(rs.getString("id") + "\t" + name);
            	saveToFile(rs.getString("id") + "\t" + name, "runlog.log", false);
            	}
            rs.close();
            conn.close();
            } catch(ClassNotFoundException e) {
            	System.out.println("Sorry,can`t find the Driver!"); 
            	e.printStackTrace();
            	} catch(SQLException e) {
            		e.printStackTrace();
            		} catch(Exception e) {
            			e.printStackTrace();
            			} 
		
		
		
}
	


	public void saveToFile(String text, String path, boolean isClose) {
		File file = new File("runlog.log");
		BufferedWriter bf = null;
		try {
			FileOutputStream outputStream = new FileOutputStream(file, true);
			OutputStreamWriter outWriter = new OutputStreamWriter(outputStream);
			bf = new BufferedWriter(outWriter);
			bf.append(text);
			bf.newLine();
			bf.flush();
			if (isClose) {
				bf.close();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
					}
		}











}