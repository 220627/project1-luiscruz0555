package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class AuthDAO implements AuthDAOInterface {

	@Override
	public User login(String username, String password) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from users where username = ? and password = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getInt("role_id_fk")
						);
				
				return u;
			}
			
		} catch (SQLException e) {
			System.out.println("Login failed");
			e.printStackTrace();
		}
		
		
		return null;
	}

}
