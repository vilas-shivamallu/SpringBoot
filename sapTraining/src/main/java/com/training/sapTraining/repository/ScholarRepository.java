package com.training.sapTraining.repository;

import org.springframework.stereotype.Repository;

import com.training.sapTraining.model.Scholar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;  
@Repository
public class ScholarRepository {
	
	
	public List<Scholar> getAllScholars() { //Returning details of all Scholars by using List
		
	List<Scholar> sc=new ArrayList<>();
	try{  
		
	//Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");  
	
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from scholar");  
	
	while(rs.next()) 
	{		Scholar s=new Scholar();
			s.setScholarId(rs.getString(1));
			s.setScholarName(rs.getString(2));
			s.setScholarBatch(rs.getString(3));
			sc.add(s);
	}
	con.close();  
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return sc;  
	
	}  
	public String getScholar(String id) { //Return scholar details based on ID
		String getScholar="select * from scholar where scholarId=?";
		String result = "Scholar Record Not Found.";
		try{  
			
			//Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");  
			
			PreparedStatement stmt=con.prepareStatement(getScholar);  
			stmt.setString(1,id);
			ResultSet rs=stmt.executeQuery();  
			
			while(rs.next()) 
			result = rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3);  
			con.close(); 
			
		}
		catch(Exception e){
				System.out.println(e);
		}
		return result;
	}
	
	public String postAddScholar(Scholar sch) { //Add new scholar details
		
		
		String id=sch.getScholarId();
		String name=sch.getScholarName();
		String batch=sch.getScholarBatch();
		String addScholar="Insert into scholar values(?,?,?)";
		int i=0;
		
		try{  
			
			//Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");  
			
			PreparedStatement stmt=con.prepareStatement(addScholar);  
			stmt.setString(1,id);
			stmt.setString(2,name);
			stmt.setNString(3,batch);
			i=stmt.executeUpdate();  		
			
			con.close();  
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return i>0?"Scholar Details Added ":"Failed";
		}
	
	public String postUpdateScholar(Scholar sch) { //Update Scholar Details
		
		String id=sch.getScholarId();
		String name=sch.getScholarName();
		String batch=sch.getScholarBatch();
		String addScholar="Update scholar set scholarName=?,scholarBatch=? where scholarId=?";
		int i=0;
		
		try{  
			
			//Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");  
			
			PreparedStatement stmt=con.prepareStatement(addScholar);  
			
			stmt.setString(1,name);
			stmt.setNString(2,batch);
			stmt.setString(3,id);
			i=stmt.executeUpdate();  		
			
			con.close();  
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return i>0?"Scholar Details Updated ":"Scholar Record Not Found.";
	}
	public String deleteScholar(String id) { //Delete a scholar 
		String deleteScholar="Delete from scholar where scholarId=?";
		int i=0;
		
		try{  
			
			//Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");  
			
			PreparedStatement stmt=con.prepareStatement(deleteScholar);  
			stmt.setString(1,id);
			i=stmt.executeUpdate();  		
			
			con.close();  
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return i>0?"Scholar Record With Id: "+id+" Deleted" : "Scholar Record Not Found.";
	
		}
	
}