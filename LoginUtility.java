package mnregapkg;

import java.sql.*;

import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class LoginUtility {
	
	@SuppressWarnings("deprecation")
	public UserBean submitButton(String username,String password){
		UserBean user=null;
		DBManager manager= new DBManager();
		Connection localCon=manager.getConnection();
		PreparedStatement preSt= null;
		ResultSet rs = null;
		String query= "SELECT* FROM user WHERE username=? AND password=?;";
		
		
		try {
			preSt = localCon.prepareStatement(query);
			preSt.setString(1,username);
			preSt.setString(2,password);
			rs = preSt.executeQuery();
		} catch (SQLException e) {
			System.out.println("error in transfering username and password b/w ui and utility");
		}
		
		if(rs!=null){
		
			try {
				while(rs.next()){
					user = new UserBean();
					user.setuserid(rs.getInt(1));
					user.setusername(rs.getString(2));
					user.setpassword(rs.getString(3));
					user.setname(rs.getString(4));
					user.setemail(rs.getString(5));
					
				}
			} catch (SQLException e) {
				System.out.println("error in LoginUtility while creating a user object");
			}
		}
		else{
			System.out.println("please enter a valid username and password");
		}
		return user;
	}

}
