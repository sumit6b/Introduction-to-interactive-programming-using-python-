/*package mnregapkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JButton submit,signUp;
	JLabel 	userName, password;
    JPanel panel;
    
    public Login(){
		JFrame myframe= new JFrame();
		myframe.setSize(300, 600);
		myframe.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
		myframe.setVisible(true);
		userName= new JLabel("UserName");
		password= new JLabel("Password");
		myframe.add(panel);
		myframe.add(userName);
		myframe.add(password);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
		Login n= new Login();

	}

}

package mnregapkg;


import java.sql.*;


public class Test {
    static Connection con= null;
    static Statement stmt= null;

    public static void main(String[] args) {
       DBManager manager = new DBManager();
       con=manager.getConnection();
       stmt= manager.getStatement(con);
       ResultSet res = null;
       res = manager.executeSelectQuery(stmt, "SELECT*FROM user;");
       
       if(res != null){
    	   System.out.println("Result found");
       }else{
    	   System.out.println("Not Found");
       }
       
       
    }
    
}
*/