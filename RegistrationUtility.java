package mnregapkg;


public class RegistrationUtility {
	public void submitButton(String username, String password, String name,
			String email) {
		// TODO Auto-generated method stub
		UserBean user= new UserBean();
		user.setusername(username);
		user.setpassword(password);
		user.setname(name);
		user.setemail(email);
		RegistrationTaskImp reg = new RegistrationTaskImp();
		int changedLine = reg.putIntoDataBase(user);
		if(changedLine!=0){
			System.out.println("success");
		}
	}

}
