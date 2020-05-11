package datastructure;

import java.io.Serializable;

import javax.swing.DefaultListModel;

// Java program to implement Max Heap 
	public class MaxHeap implements Serializable  { 
		
		private Node [] heap; // array of heap entries
		private int lastIndex; // index of last entry
		private static final int DEFAULT_INITIAL_CAPACITY = 25;
		
		public MaxHeap () //default constructor
		{
		this (DEFAULT_INITIAL_CAPACITY); // call next constructor
		}
		
		public MaxHeap (int initialCapacity)
		{
			heap = new Node[initialCapacity+1];
			lastIndex = 0;
		}
		
		public void add (Node newEntry){
			lastIndex++;
			int newIndex = lastIndex;
			int parentIndex = newIndex / 2;
			while ((parentIndex > 0) && newEntry.compareTo (heap [parentIndex]) > 0){
				heap [newIndex] = heap [parentIndex];
				newIndex = parentIndex;
				parentIndex = newIndex / 2;
				}
			heap [newIndex] = newEntry;
		}
		
		public Node removeMax (){
			Node root = null;
			if (!isEmpty ()){
				root = heap [1]; // return value
				heap [1] = heap [lastIndex]; // form a semiheap
				lastIndex--; // decrease size
				reheap (1); // transform to a heap
				}
			return root;
		}
		
		public boolean isEmpty() {
			return (heap[1]==null);
		}
		
		
		private void reheap (int rootIndex){
			boolean done = false;
			Node orphan = heap [rootIndex];
			int leftChildIndex = 2 * rootIndex;
			while (!done && (leftChildIndex <= lastIndex)){
				int largerChildIndex = leftChildIndex; // assume larger
				int rightChildIndex = leftChildIndex + 1;
				if ((rightChildIndex <= lastIndex) && 
						heap [rightChildIndex].compareTo (heap[largerChildIndex]) > 0){
					largerChildIndex = rightChildIndex;
					}
				if (orphan.compareTo (heap [largerChildIndex]) < 0){
					heap [rootIndex] = heap [largerChildIndex];
					rootIndex = largerChildIndex;
					leftChildIndex = 2 * rootIndex;
					}
				else
					done = true;
				}
			heap [rootIndex] = orphan;
		}
		

		public String  Print() {
			String s="";
			for (int i = 1; i < heap.length; i++)
				if(heap[i]!= null) {
				System.out.println(heap[i].toString());
				s = s + heap[i].toString();
				}
			;
			return s;
		}
	
}
