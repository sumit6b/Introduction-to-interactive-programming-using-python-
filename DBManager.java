/*package mnregapkg;

import java.sql.*;



public class DBManager {
	private Connection con=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private final String URL="jdbc:mysql://localhost:3306/mydb";
	
	
	public Connection getConnection(){
		//step1:
		try{
			Class.forName();
		}catch(ClassNotFoundException e){
			System.out.println("Error:1 Driver not found");
		}
		
		//step2:
		try{
			con= DriverManager.getConnection(URL, user, password);
		}catch(SQLException e){
			System.out.println("Error:2 Connection not established");
		}
		return con;
	}
	
	

}
*/

package mnregapkg;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sumit
 */
public class DBManager {
     //fields:
    private Connection con=null;
    private Statement st= null;
    private ResultSet rs=null;
    private int rows=0;
    private final String URL="jdbc:mysql://localhost:3306/mydb";
    private final String USER="root";
    private final String PASSWORD="root";
    
    //methods:
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){            
            System.out.println("ERROR 1: Driver Error!");
         }
        
        try{
            con=DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException ex){
             
            System.out.println("ERROR 2: DateBase not connected");
         }
        return con;
    
    }
    public Statement getStatement(Connection conn){
        try{
             st=conn.createStatement();
        }catch(SQLException ex){
            ex.printStackTrace(); 
            System.out.println("ERROR 3: Statement generation failure");
         }
        return st;
    }
    public boolean executeInsertQuery(Statement st,String query){
        try{
            rows=st.executeUpdate(query);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("ERROR 3: bbgbbgb Systemfailed");
        }
        if (rows>0)
            return true;
        else
            return false;
     }
    public ResultSet executeSelectQuery(Statement st,String query){
        try{
            rs=st.executeQuery(query);
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Statement Failure");
        }
        return rs;
    }
    public boolean closeConnection(Connection conn){
        
        try{
            if(rs!=null)
                rs.close();
            if(conn!=null)
                conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Connection doesnot closed successfully");
        }
        return true;
    
    }
 
    
}
