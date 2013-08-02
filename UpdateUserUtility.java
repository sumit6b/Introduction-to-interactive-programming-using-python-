package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateUserUtility {

	public UserBean pullDataFromUser(int userid) {
		// TODO Auto-generated method stub
		UserBean user=null;
		DBManager manager = new DBManager();
		Connection localCon= manager.getConnection();
		PreparedStatement preSt=null;
		ResultSet rs=null;
		System.out.println("updateuserutility");
		String query="SELECT* FROM user WHERE userid=?;";
		try {
			preSt=localCon.prepareStatement(query);
			preSt.setInt(1, userid);
			rs= preSt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					user=new UserBean();
					user.setuserid(rs.getInt(1));
					user.setname(rs.getString(4));
					user.setemail(rs.getString(5));
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sqlexception in updateuserutility");
		}
		return user;
	}

	public UserBean pullDatafromrequest(int userid) {
		// TODO Auto-generated method stub
		UserBean user=null;
		DBManager manager = new DBManager();
		Connection localCon= manager.getConnection();
		PreparedStatement preSt=null;
		ResultSet rs=null;
		
		String query="SELECT* FROM request WHERE userid=?;";
		
		try {
			preSt=localCon.prepareStatement(query);
			preSt.setInt(1, userid);
			rs= preSt.executeQuery();
			while(rs.next()){
				user= new UserBean();
				user.setuserid(rs.getInt(1));
				user.setname(rs.getString(2));
				user.setemail(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sqlexception in updateuserutility");
		}
		return user;
	}

}
