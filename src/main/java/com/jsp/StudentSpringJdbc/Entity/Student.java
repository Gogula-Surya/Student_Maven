package com.jsp.StudentSpringJdbc.Entity;

public class Student 
{
	private int sId; 
	private String sName; 
	private double sPer;
	private String sStream;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public double getsPer() {
		return sPer;
	}
	public void setsPer(double sPer) {
		this.sPer = sPer;
	}
	public String getsStream() {
		return sStream;
	}
	public void setsStream(String sStream) {
		this.sStream = sStream;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sPer=" + sPer + ", sStream=" + sStream + "]";
	}
	
}
