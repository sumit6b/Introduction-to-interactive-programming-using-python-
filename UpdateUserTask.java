package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateUserTask {

	public void allowButton(int userid) {
		// TODO Auto-generated method stub
		boolean yn = false;
		DBManager manager = new DBManager();
		Connection localCon=manager.getConnection();
		PreparedStatement preSt=null;
	
		String query=("UPDATE user SET user.name=request.updatedname,user.email=request.updatedemail WHERE userid=?;");
		String delquery=("DELETE FROM request WHERE userid=? ");
		
		try {
			preSt=localCon.prepareStatement(query);
			preSt.setInt(1, userid);
			yn=preSt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(yn){
			System.out.println("successfully updated");
			try {
				preSt=localCon.prepareStatement(delquery);
				preSt.setInt(1, userid);
				boolean delyn = preSt.execute();
				if(delyn){
					System.out.println("that request is deleted from request");
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		}
	}
}
