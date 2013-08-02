package mnregapkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminTaskImp implements AdminTask{

	public UserBean pullDataFromUser(int userid) {
		// TODO Auto-generated method stub
		System.out.println("in admintaskimp and values of gathered userid is"+userid);
		UserBean userBean = null;
		DBManager manager= new DBManager();
		
		Connection localCon = manager.getConnection();
		PreparedStatement preSt = null;
		ResultSet rs = null;
		String query= "SELECT* FROM user WHERE userid=?";
		try {
			preSt=localCon.prepareStatement(query);
			preSt.setInt(1, userid);
		
			rs = preSt.executeQuery();
			System.out.println("got rs");
			if(rs!=null){
				while(rs.next()){
					userBean = new UserBean();
					userBean.setuserid(rs.getInt(1));
					userBean.setusername(rs.getString(2));
					userBean.setpassword(rs.getString(3));
					userBean.setname(rs.getString(4));
					userBean.setemail(rs.getString(5));
				}
			}else
				System.out.println("no values recevied in rs");
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("sql exception at admintaskimp");
		 }
		
		return userBean;
	}

	public void displayUserInformation(UserBean user) {
		// TODO Auto-generated method stub
		AdminUserView userview = new AdminUserView(user);
		userview.setVisible(true);
	}

	public List pullAllUseridFromrequest() {
		// TODO Auto-generated method stub
		
		List list = null;
		DBManager manager = new DBManager();
		Connection localCon=manager.getConnection();
		Statement st=null;
		ResultSet rs=null;
		st=manager.getStatement(localCon);
		String query="SELECT userid FROM REQUEST";
		rs=manager.executeSelectQuery(st, query);
		if(rs!=null){
			try {
				while(rs.next()){
					list = new ArrayList();
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
