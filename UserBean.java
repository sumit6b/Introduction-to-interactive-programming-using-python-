package mnregapkg;

public class UserBean {
	private int userid;
	private String username;
	private String password;
	private String name;

	private String email;
	
	public void setuserid(int id){
		this.userid=id;
	}
	public int getuserid(){
		return this.userid;
	}
	
	public void setusername(String usrname){
		this.username=usrname;
	}
	public String getusername(){
		return this.username;
	}
	
	public void setpassword(String pwd){
		this.password=pwd;
	}
	public String getpassword(){
		return this.password;
	}
	
	public void setname(String name){
		this.name=name;
	}
	public String getname(){
		return this.name;
	}
	
	public void setemail(String email){
		this.email=email;
	}
	public String getemail(){
		return this.email;
	}
	

	
	

}
