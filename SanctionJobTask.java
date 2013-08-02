package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SanctionJobTask {

	public void assignButton(int userid,int jobid) {
		// TODO Auto-generated method stub
		SanctionJobUtility sanctionJobUtility= new SanctionJobUtility();
		JobsDataBean jobsDataBean= sanctionJobUtility.makeJobsDataBean(userid);
		
		DBManager manager= new DBManager();
		Connection localCon = manager.getConnection();
		PreparedStatement preSt=null;
		String query="INSERT INTO jobsdata(userid,jobid) values(?,?)";
		
		try {
			preSt=localCon.prepareStatement(query);
			preSt.setInt(1, userid);
			preSt.setInt(2, jobid);
			boolean yn=preSt.execute();
			if(yn){
				System.out.println("jobs assigned");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
