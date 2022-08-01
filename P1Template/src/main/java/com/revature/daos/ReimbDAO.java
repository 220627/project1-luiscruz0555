package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.models.Reimb;
import com.revature.utils.ConnectionUtil;

public class ReimbDAO implements ReimbDAOInterface {

	@Override
	public ArrayList<Reimb> getAllReimb() {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursement;";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Reimb> reimbList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimb newReimb = new Reimb(
						
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author_fk"),
						rs.getInt("reimb_resolver_fk"),
						rs.getInt("reimb_status_id_fk"),
						rs.getInt("reimb_type_id_fk")
						
						);
				
				reimbList.add(newReimb);
				
				
			} //END OF WHILE LOOP
			
			return reimbList;
			
		} catch (SQLException e) {
			System.out.println("Reimbursements pull failed.");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean createNewReimb(Reimb newReimb) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author_fk, reimb_status_id_fk, reimb_type_id_fk) values (?, ?, ?, ?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, newReimb.getReimb_amount());
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setString(3, newReimb.getReimb_description());
			ps.setInt(4, newReimb.getReimb_author_fk());
			ps.setInt(5, newReimb.getReimb_status_id_fk());
			ps.setInt(6, newReimb.getReimb_type_id_fk());
			
			ps.executeUpdate();
			
			System.out.println("Reimbursement submitted successfully!");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Reimbursement creation failed!");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean approveReimb(int reimb_status_id_fk, int reimb_id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update reimbursement set reimb_resolved = ?, reimb_status_id_fk = ? where reimb_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			
			ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			ps.setInt(2, reimb_status_id_fk);
			ps.setInt(3, reimb_id);
			
			ps.executeUpdate();
			
			if(reimb_status_id_fk == 2) {
				System.out.println("Reimbursement approved.");
			}else {
				System.out.println("Reimbursement denied.");
			}
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Reimbursement edit failed.");
			e.printStackTrace();
			
		}
		
		return false;
	}

	@Override
	public ArrayList<Reimb> getReimbByUserId(int reimb_author_fk) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursement where reimb_author_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimb_author_fk);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Reimb> reimbList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimb reimb = new Reimb(
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author_fk"),
						rs.getInt("reimb_resolver_fk"),
						rs.getInt("reimb_status_id_fk"),
						rs.getInt("reimb_type_id_fk")
						);
				
				reimbList.add(reimb);
				
			}
			
			return reimbList;
			
		}catch (SQLException e) {
			System.out.println("Reimbursement pull failed.");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Reimb> getPendingReimbs() {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursement where reimb_resolved is null;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setString(1, nullString);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Reimb> reimbList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimb reimb = new Reimb(
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author_fk"),
						rs.getInt("reimb_resolver_fk"),
						rs.getInt("reimb_status_id_fk"),
						rs.getInt("reimb_type_id_fk")
						);
				reimbList.add(reimb);
				
			}
			return reimbList;
			
			
		}catch (SQLException e) {
			System.out.println("Reimb pull failed");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Reimb> getApprovedReimbs() {

		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursement where reimb_status_id_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, 2);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Reimb> reimbList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimb reimb = new Reimb(
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author_fk"),
						rs.getInt("reimb_resolver_fk"),
						rs.getInt("reimb_status_id_fk"),
						rs.getInt("reimb_type_id_fk")
						);
				reimbList.add(reimb);
				
			}
			return reimbList;
			
			
		}catch (SQLException e) {
			System.out.println("Reimb pull failed");
			e.printStackTrace();
		}
		
		return null;
	}

}
