package mnregapkg;

public class JobHistoryBean{
	private int jobid;
	private String jobname;
	private int startfrom;
	private int till;
	
	public void setjobid(int jobid){
		this.jobid = jobid;
	}
	public int getjobid(){
		return this.jobid;
	}
	
	public void setjobname(String jobname){
		this.jobname = jobname;
	}
	public String getjobname(){
		return this.jobname;
	}
	
	public void setstartfrom(int startfrom){
		this.startfrom = startfrom;
	}
	public int getstartfrom(){
		return this.startfrom;
	}
	
	public void settill(int till){
		this.till = till;
	}
	public int gettill(){
		return this.till;
	}
	
	
}
