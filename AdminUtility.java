package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminUtility {

	public JobHistoryBean pullJobsFromJobsData(int userid) {
		// This method is just a copy past of the same name method in UserTaskImp :)
		
		JobHistoryBean jobHistoryBean=null;
		DBManager manager = new DBManager();
		Connection localCon = manager.getConnection();
		PreparedStatement preSt=null;
		ResultSet rs = null;
		String query="SELECT jobs.jobid,jobname,startfrom,till from jobsdata,jobs where jobsdata.userid=? and jobsdata.jobid=jobs.jobid;";
		System.out.println("before history query execution");
		try {
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
					jobHistoryBean= new JobHistoryBean();
					jobHistoryBean.setjobid(rs.getInt(1));
					jobHistoryBean.setjobname(rs.getString(2));
					jobHistoryBean.setstartfrom(rs.getInt(3));
					jobHistoryBean.settill(rs.getInt(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("exception while reading values form resultset");
			}
		}
		return jobHistoryBean;
	}

	public int pullreqforupdateFromrequest() {
		// TODO Auto-generated method stub
		int count=0;
		DBManager manager = new DBManager();
		Connection localCon = manager.getConnection();
		Statement st = null;
		ResultSet rs= null;
		String query="SELECT userid FROM request;";
		System.out.println("before rs adminutility");
		try {
			st=localCon.createStatement();
			rs=manager.executeSelectQuery(st, query);
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in adminutility");
		}
		System.out.println("before rs adminutility");
	return count;
	}

	public int pullNoOfJobAvailable() {
		// TODO Auto-generated method stub
		int count=0;
		DBManager manager = new DBManager();
		Connection localCon = manager.getConnection();
		Statement st = null;
		ResultSet rs= null;
		String query="SELECT jobid FROM jobs WHERE availibility='y';";
		System.out.println("before rs adminutility inpullnoofjob available method");
		try {
			st=localCon.createStatement();
			rs=manager.executeSelectQuery(st, query);
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in adminutility");
		}
		System.out.println("before rs adminutility");
	return count;
	}

	public int pullNoOfJobApllied() {
		// TODO Auto-generated method stub
		int count=0;
		DBManager manager = new DBManager();
		Connection localCon = manager.getConnection();
		Statement st = null;
		ResultSet rs= null;
		String query="SELECT jobid FROM jobsapplied;";
		System.out.println("before rs adminutility inpullnoofjob Applied method");
		try {
			st=localCon.createStatement();
			rs=manager.executeSelectQuery(st, query);
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in adminutility");
		}
		System.out.println("before rs adminutility");
	return count;
	}

	public List<Integer> pullListOfUseridFromjobsapplied() {
		// TODO Auto-generated method stub
		List<Integer> list= new ArrayList<Integer>();
		DBManager manager = new DBManager();
		Connection localCon= manager.getConnection();
		Statement st= manager.getStatement(localCon);
		ResultSet rs=null;
		String query="SELECT userid FROM jobsapplied";
		
		rs= manager.executeSelectQuery(st, query);
		if(rs!=null){
			try {
				while(rs.next()){
					list.add(new Integer(rs.getInt(1)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	

}
