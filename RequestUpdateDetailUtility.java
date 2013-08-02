package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestUpdateDetailUtility {

	public void updateButton(int userid,String name, String email) {
		// TODO Auto-generated method stub
		DBManager manager= new DBManager();
		Connection localCon= manager.getConnection();
		PreparedStatement preSt= null;
		String query="INSERT INTO request VALUES(?,?,?);";
		try {
			preSt=localCon.prepareStatement(query);
			preSt.setInt(1, userid);
			preSt.setString(2, name);
			preSt.setString(3, email);
			boolean yn=preSt.execute();
			if(yn){
				System.out.println("filed for update successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
