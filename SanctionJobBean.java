package mnregapkg;

public class SanctionJobBean {
	private String name;
	private String email;
	private String jobname;
	private int jobid;
	
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
	
	public void setjobname(String jobname){
		this.jobname=jobname;
	}
	public String getjobname(){
		return this.jobname;
	}
	public void setjobid(int jobid) {
		this.jobid=jobid;
	}
	public int getjobid(){
		return this.jobid;
	}
}
