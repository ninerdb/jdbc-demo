/**
 * 
 */
package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * @author Nanda
 *
 */
public class SelectData {
	
	Connection con;
	Statement st;
	
	SelectData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from authors");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			/*while(rs.next()) {
				System.out.println("Author ID: " + rs.getInt(1));
				System.out.println("Author Name: " + rs.getString(2));
				System.out.println("Author Age: " + rs.getInt(3));
				System.out.println("Zip: " + rs.getString(4));
			}*/
			
			int columnCount = rsmd.getColumnCount();
			
			for(int i=1;i<=columnCount;i++) {
				System.out.println(rsmd.getColumnType(i));
			}
			
			for(int i=1;i<=columnCount;i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			
			System.out.println();
			
			while(rs.next()) {
				for(int i=1;i<=columnCount;i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println("\n");
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
		new SelectData();
	}

}
