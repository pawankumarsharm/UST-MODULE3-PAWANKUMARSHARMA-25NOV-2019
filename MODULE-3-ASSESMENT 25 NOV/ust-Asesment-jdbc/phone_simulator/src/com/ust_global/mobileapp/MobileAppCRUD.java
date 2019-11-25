package com.ust_global.mobileapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;


public class MobileAppCRUD {

	public static void getAllContact()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {


			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String sql = "select * from contact";
			String url = "jdbc:mysql://localhost:3307/contactfile?user=root&password=root";
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				String name = rs.getString("name");

				System.out.println("Name : "+name);
				System.out.println("~~~~~~~~~~~~~~~~");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)
					conn.close();
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}


	}
	/////////////////add contact////////////////////
	public static void addContact(String name,long number,String group)
	{

		Connection conn = null;
		Statement stmt = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3307/contactfile?user=root&password=root";
			conn = DriverManager.getConnection(url);

			String sql = "insert into contact values('"+name+"',"+number+",'"+group+"')";
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);


			System.out.println(count +" Row(s) Inserted");
			System.out.println("Contact saved !!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/////////////////////delete contact////////////////

	public static void deleteContact(String name1)
	{

		boolean check = checkName(name1);
		if(check)
		{
			Connection conn = null;
			Statement stmt = null;
			try {
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);

				String url = "jdbc:mysql://localhost:3307/contactfile?user=root&password=root";
				conn = DriverManager.getConnection(url);

				String sql = "delete from contact where name='"+name1+"'";
				stmt = conn.createStatement();
				int count = stmt.executeUpdate(sql);
				System.out.println(count +" Row(s) deleted");

			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
					if(stmt!=null) {
						stmt.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else
			System.out.println("Name not found");
	}

	////////////////Update contact///////////////////
	public static void updateContact(String newName,long newNumber,String newGroup)
	{

		boolean check = checkName(newName);

		if(check)
		{
			Connection conn = null;
			Statement stmt = null;
			try {
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);

				String url ="jdbc:mysql://localhost:3307/contactfile?user=root&password=root";
				conn = DriverManager.getConnection(url);

				String sql = "update contact set number="+newNumber+" ,groups='"+newGroup+"' where name='"+newName+"'";
				stmt  = conn.createStatement();
				int count  = stmt.executeUpdate(sql);
				System.out.println(count +" Row(s) Updated");

			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
					if(stmt!=null) {
						stmt.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else
			System.out.println("Name not found");
	}


	//////////////calling//////////////////
	public static void call(String name)
	{
		boolean check = checkName(name);
		if(check) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {


				Driver driver = new Driver();
				DriverManager.registerDriver(driver);

				String sql = "select * from contact where name='"+name+"' ";
				String url = "jdbc:mysql://localhost:3307/contactfile?user=root&password=root";
				conn = DriverManager.getConnection(url);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				if(rs.next())
				{
					String name1 = rs.getString("name");
					long number = rs.getInt("number");
					String group = rs.getString("groups");

					System.out.println(name1+ "  "+number);
					System.out.println("CALLING.........");

					System.out.println("Press 1 to end call");
					Scanner sc = new Scanner(System.in);
					int val = sc.nextInt();
					if(val ==1)
						System.out.println("Call ended");
				}


			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null)
						conn.close();
					if(stmt!=null)
						stmt.close();
					if(rs!=null)
						rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}else
			System.out.println("Name not found");
	}
	//////////////message/////////////////
	public static void message(String name1)
	{
		boolean check = checkName(name1);
		if(check)
		{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {


				Driver driver = new Driver();
				DriverManager.registerDriver(driver);

				String sql = "select * from contact where name='"+name1+"' ";
				String url = "jdbc:mysql://localhost:3307/contactfile?user=root&password=root";
				conn = DriverManager.getConnection(url);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				Scanner sc12 = new Scanner(System.in);
				System.out.println("Tpye message...");
				String message = sc12.nextLine();
				if(rs.next())
				{
					String name2 = rs.getString("name");
					long number = rs.getInt("number");
					String group = rs.getString("groups");

					System.out.println();
					System.out.println(name1+ "  "+number);
					System.out.println();
					System.out.println(message);
					System.out.println("SENDING MESSAGE.......");



				}


			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null)
						conn.close();
					if(stmt!=null)
						stmt.close();
					if(rs!=null)
						rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}else
			System.out.println("Name not found");
	}
	///////check name exist or not////////////////
	public static boolean checkName(String name)
	{

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {


			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String sql = "select * from contact";
			String url = "jdbc:mysql://localhost:3307/contactfile?user=root&password=root";
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				String name1 = rs.getString("name");
				if(name.equals(name1))
				{
					return true;
				}

			}
			return false;


		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(conn!=null)
					conn.close();
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}


	}
}
