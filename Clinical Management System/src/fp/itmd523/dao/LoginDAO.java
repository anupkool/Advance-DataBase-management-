package fp.itmd523.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fp.itmd523.model.Login;

public class LoginDAO extends DataSource {
	
	public Login findUserLogin(String username, String password) {
		Login login = null;
		
		String query = "select * from 510labs.cms_login where username = ? and password = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	login = new Login(
            			resultSet.getString("username"),
            			resultSet.getString("password"),
            			resultSet.getString("usertype")
            			);
            	
            }
        } catch(SQLException e){
            System.out.println("Error Finding User (findUser)" + e);
        }
        return login;
    }
}

