package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMoreTask {

	public boolean pushIntoJobs(String jobname, String availibility) {
		// TODO Auto-generated method stub
		boolean yn = false;
		DBManager manager = new DBManager();
		Connection localCon= manager.getConnection();
		PreparedStatement preSt=null;
		String query="INSERT INTO jobs(jobname,availibility) values(?,?)";
		
		try {
			preSt=localCon.prepareStatement(query);
			preSt.setString(1,jobname);
			preSt.setString(2,availibility);
			yn=preSt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("job added successfully");
		}
		return yn;
	}
	
	
}
