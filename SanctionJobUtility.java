package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SanctionJobUtility {

	public SanctionJobBean pullSanctionBean(int userid) {
		// TODO Auto-generated method stub
		SanctionJobBean sanctionJobBean = null;
		DBManager manager= new DBManager();
		Connection localCon= manager.getConnection();
		PreparedStatement preSt=null;
		ResultSet rs=null;
		String query="select name,email,jobname,jobs.jobid from jobs,jobsapplied,user where jobsapplied.userid=? and jobs.jobid=jobsapplied.jobid";
		 
		try {
			preSt=localCon.prepareStatement(query);
			preSt.setInt(1, userid);
			System.out.println("in sanctionjobutility");
			rs=preSt.executeQuery();
			if(rs!=null){
				
				while(rs.next()){
					sanctionJobBean = new SanctionJobBean();
					sanctionJobBean.setname(rs.getString(1));
					sanctionJobBean.setemail(rs.getString(2));
					sanctionJobBean.setjobname(rs.getString(3));
					sanctionJobBean.setjobid(rs.getInt(4));
				}
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanctionJobBean;
	}

	public JobsDataBean makeJobsDataBean(int userid) {
		// TODO Auto-generated method stub
		DBManager manager = new DBManager();
		Connection localCon=manager.getConnection();
		String query="";
		PreparedStatement preSt=localCon.prepareStatement(query);
		return null;
	}

}
