package datastructure;

import java.io.Serializable;
import java.util.ArrayList;

public class Node implements Serializable, Comparable<Node> {
	String GPA;
	String Fname;
	String Lname;
	String DepartmentSelection;
	String email;
	Node link;
	
	public Node() {
		GPA="";
		Fname="";
		Lname="";
		DepartmentSelection="";
		email="";
		link= null;
	}

	public Node(String gPA, String fname, String lname, String departmentSelection, String email) {
		super();
		GPA = gPA;
		Fname = fname;
		Lname = lname;
		DepartmentSelection = departmentSelection;
		this.email = email;
		link=null;
	}

	public Node(String gPA, String fname, String lname, String departmentSelection, String email, Node link) {
		super();
		GPA = gPA;
		Fname = fname;
		Lname = lname;
		DepartmentSelection = departmentSelection;
		this.email = email;
		this.link = link;
	}

	public String getGPA() {
		return GPA;
	}

	public void setGPA(String gPA) {
		GPA = gPA;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getDepartmentSelection() {
		return DepartmentSelection;
	}

	public void setDepartmentSelection(String departmentSelection) {
		DepartmentSelection = departmentSelection;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
	
	
	@Override
	public String toString() {
		return  Fname+"\t"+Lname+"\t"+ DepartmentSelection +"  "+ GPA + "  "+ email+ "\n";
	}

	@Override
	public int compareTo(Node other) {
		if(Double.parseDouble(getGPA()) > Double.parseDouble(other.getGPA()))
		return 1;
		else if (Double.parseDouble(getGPA()) < Double.parseDouble(other.getGPA()))
			return -1;
		else 
			return 0;
	}
	
}
