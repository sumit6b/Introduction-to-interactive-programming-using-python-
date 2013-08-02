package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegistrationTaskImp implements RegistrationTask {

	@Override
	public int putIntoDataBase(UserBean usr) {
		// TODO Auto-generated method stub
		int noOfChangeLine = 0;
		DBManager manager= new DBManager();
		Connection localCon=manager.getConnection();
		PreparedStatement preSt=null;
		String query="INSERT INTO user (username,password,name,email) VALUES (?,?,?,?);";
		try {
			preSt=localCon.prepareStatement(query);
			System.out.println("1");

			preSt.setString(1, usr.getusername());
			System.out.println("2");
			preSt.setString(2, usr.getpassword());
			preSt.setString(3, usr.getname());
			preSt.setString(4, usr.getemail());
			System.out.println("3");

			noOfChangeLine = preSt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in registerTaskImp with data updation during registration");
		}
		return noOfChangeLine;

	}

}
