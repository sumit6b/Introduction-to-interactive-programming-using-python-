package mnregapkg;

public class JobsBean {
	private int jobid;
	private String availibility;
	private int expiryon;
	private String jobname;
	
	public void setjobid(int id){
		this.jobid=id;
	}
	public int getjobid(){
		return this.jobid;
	}
	
	public void availibility(String av){
		this.availibility=av;
	}
	public String availibility(){
		return this.availibility;
	}
	
	public void expiryon(int ex){
		this.expiryon=ex;
	}
	public int getexpiryon(){
		return this.expiryon;
	}
	
	public void setjobname(String jbname){
		this.jobname=jbname;
	}
	public String getjobname(){
		return this.jobname;
	}
}
