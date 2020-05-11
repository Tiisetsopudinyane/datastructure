package datastructure;


import java.io.Serializable;

import javax.swing.JOptionPane;

public class LinkedList implements Serializable {
	Node first;
	Node last;
	
	public boolean isEmpty() {
		if(first==null) {return true;}
		else 
			return false;
	}
	public void insertFirst(String gPA, String fname, String lname, String departmentSelection, String email) {
		if(isEmpty()) {
			first=last= new Node(gPA,fname,lname,departmentSelection,email, first);
		}
		else {
			first= new Node( gPA,fname,lname,departmentSelection,email,first);
		}
	}
	
	public void insertLast(String gPA, String fname, String lname, String departmentSelection, String email) {
		if(isEmpty()) {
			first=last= new Node (gPA, fname, lname, departmentSelection,  email, first);
		}
		else {
			last.setLink(new Node(gPA,  fname, lname, departmentSelection,  email));
			last=last.getLink();
		}	
	}
	
	public void print() {
		Node n = first;
		while(n!=null) {
			
			System.out.println(n.toString());
			n=n.getLink();
		}
	}
	
	public void  removeFirst() {
		if (isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "The list is empty");
		}
		else {
			first= first.getLink();
		}
	}
	
	public void removeLast() {
		Node current;
		if(isEmpty()==true) {
			System.out.println("Nothing to delete");
		}
		else {
			current= first;
			while(current.getLink()!=last){
				current=current.getLink();
			}
			last = current;
			current.setLink(null);
		}
	}
	
	public int size() {
		int count = 0;
		Node n = first;
		while(n!=null) {
			count++;
			n= n.getLink();
		}
		return count;
	}
	
	public void Add(Node s) {
		Node newNode = new Node(null, null, null, null, null, s);
		if(first == null){
			//The list is empty
			first = newNode;
		}else{
			//The list has elements.
			//Firstly, find the last element of the list.
			//Then, you can add new node at the end of the list.
			Node current = first;
			while(current.link != null)
				current = current.link;
			current.link= newNode;
		}
		
	}
	
	public Node find(String Department) {
		Node n = first;
		String itemAtN;
		
		while(n!=null) {
			itemAtN = n.getDepartmentSelection();
			if(itemAtN.equalsIgnoreCase(Department)) {
				return n;
			}
			else
				n=n.getLink();
		}
		JOptionPane.showMessageDialog(null, Department + "is not found");
		return null;
	}

}

			




