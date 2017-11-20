/**
 * 
 */
package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Nanda
 *
 */
public class Test {
	
	Connection con;
	Statement st;
	
	Test() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");
			if(con != null) {
				System.out.println("tested, connected!");
				st = con.createStatement();
				int x = st.executeUpdate("insert into books (title, price, publisher) values ('Java', 23.45, 'TATA McGraw')");
				x = x + st.executeUpdate("insert into books (title, price, publisher) values ('REST API', 12.34, 'Wrox')");
				System.out.println(x + " rows inserted!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
