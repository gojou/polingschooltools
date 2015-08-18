package net.gojou.ast.data;


public class registration {
	
	private static final String KIND = "registration";
	
	private boolean txSuccess = false;
	
	public String getKind(){
		return registration.KIND;
	}
	
	public boolean isTxSuccess() {
		return txSuccess;
	}


	public void setTxSuccess(boolean txSuccess) {
		this.txSuccess = txSuccess;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	private String accountId;
	private String studentId;
	private String courseId;
	
	public registration(){
	}
		
	
	public boolean create(String id){
		return txSuccess;
	}
	
	public boolean get(String id){
		return txSuccess;
	}
	
	public boolean set(String id){
		return txSuccess;
	}
	
	public boolean delete(String id){
		return txSuccess;
	}

}
