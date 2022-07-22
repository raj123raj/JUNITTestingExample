package geeksforgeeks.jdbc.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FreelancerQueries {
	public List<Freelancer> listFreelancerDetails(){
		ConnectionClass connClass = new ConnectionClass();
		Connection con = connClass.getFileFromResources();
		List<Freelancer> list = new ArrayList<Freelancer>();
		Freelancer freelancer = null;
		ResultSet rs = null;
		Statement stmt = null;
		String query = "select * from freelancer";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query); 
	        while (rs.next()) { 
	        	freelancer = new Freelancer();
	        	freelancer.setFreelancerId(rs.getInt(1));
	        	freelancer.setFreelancerName(rs.getString(2));
	        	freelancer.setFreelancerAge(rs.getInt(3));
	        	freelancer.setPricePerHour(rs.getInt(4));
	            //System.out.println(rs.getInt(1) + " " + rs.getString(2)); 
	        	list.add(freelancer);
	        } 
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally{
			connClass.close(con);
			connClass.close(stmt);
			connClass.close(rs);
		}
		return list;
	}
	
	public String getFreelancerNameById(int freelancerId){
		ConnectionClass connClass = new ConnectionClass();
		Connection con = connClass.getFileFromResources();
		PreparedStatement pStmt= null;
		ResultSet rs = null;
		String freelancerName = null;
		try {
			String query = "select * from freelancer where freelancerId=?";
			pStmt = con.prepareStatement(query);
			pStmt.setInt(1, freelancerId);
			rs = pStmt.executeQuery(); 
			
	        while (rs.next()) { 
	        	freelancerName = rs.getString(2);
	            System.out.println( rs.getString(2)); 
	        } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			connClass.close(con);
			connClass.close(pStmt);
			connClass.close(rs);
		}  
		return freelancerName;
	}
	
	public int getFreelancerPricePerHour(int freelancerId){
		ConnectionClass connClass = new ConnectionClass();
		Connection con = connClass.getFileFromResources();
		PreparedStatement pStmt= null;
		ResultSet rs = null;
		int pricePerHour = 0;
		try {
			String query = "select * from freelancer where freelancerId=?";
			pStmt = con.prepareStatement(query);
			pStmt.setInt(1, freelancerId);
			rs = pStmt.executeQuery();			
	        while (rs.next()) { 
	        	pricePerHour = rs.getInt(4);
	            System.out.println( pricePerHour); 
	        } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			connClass.close(con);
			connClass.close(pStmt);
			connClass.close(rs);
		}  
		return pricePerHour;
	}
	
	
	
}
