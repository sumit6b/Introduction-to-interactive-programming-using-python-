package mnregapkg;

public class JobsDataBean {
	private int userid;
	private int jobid;
	private int startfrom;
	private int till;
	
	
	public void setuserid(int id){
		this.userid=id;
	}
	
	public int getuserid(){
		return this.userid;
	}
	
	public void setjobid(int id){
		this.jobid=id;
	}
	
	public int getjobid(){
		return this.jobid;
	}
	
	public void setstartfrom(int from){
		this.startfrom=from;
	}
	
	public int getstartfrom(){
		return this.startfrom;
	}
	
	public void settill(int till){
		this.till=till;
	}
	
	public int gettill(){
		return this.till;
	}

}
