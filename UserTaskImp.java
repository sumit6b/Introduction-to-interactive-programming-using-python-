package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;



public class UserTaskImp implements UserTask{

	public JobHistoryBean pullJobsFromJobsData(int userid) {
		// TODO Auto-generated method stub
		JobHistoryBean jobHistoryBean=null;
		DBManager manager= new DBManager();
		Connection localCon = manager.getConnection();
		PreparedStatement preSt = null;
		ResultSet rs = null;
		String query="SELECT jobs.jobid,jobname,startfrom,till from jobsdata,jobs where jobsdata.userid=? and jobsdata.jobid=jobs.jobid;";
		System.out.println("before history query execution");
		try {System.out.println("in usertaskimp");
			preSt=localCon.prepareStatement(query);
			preSt.setInt(1, userid);
			rs=preSt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in UserTaskImp while fetching history of jobs");
		}
		if(rs!=null){
			//System.out.println("some data fetched and before creating jobHistoryBean");
			try {
				while(rs.next()){
					System.out.println("1-usertaskimp");
					jobHistoryBean = new JobHistoryBean();
					jobHistoryBean.setjobid(rs.getInt(1));
					jobHistoryBean.setjobname(rs.getString(2));
					jobHistoryBean.setstartfrom(rs.getInt(3));
					jobHistoryBean.settill(rs.getInt(4));
					System.out.println("2-usertaskimp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("exception while reading values form resultset");
			}
		}System.out.println("3-usertaskimp");
		return jobHistoryBean;
		
		
	}

	public JobsBean pullJobsFromJobs() {
		// TODO Auto-generated method stub
		Collection joblist = new List;
		int i=0;
		DBManager manager = new DBManager();
		Connection localCon = null;
		Statement st = null;
		ResultSet rs = null;
		String query="SELECT jobname FROM jobs WHERE availibility='y';";
		
		localCon=manager.getConnection();
		st=manager.getStatement(localCon);
		rs=manager.executeSelectQuery(st, query);
		
		if(rs!=null){
			while(rs.next()){
				i++;
				=setjobname(rs.getString(1));
			}
		}
		return null;
	}

}
