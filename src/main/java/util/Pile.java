package util;

import java.util.ArrayList;

public class Pile {
	private ArrayList<Node> list;
	
	
	
	public Pile() {
		list = new ArrayList<>();
	}
	
	
	private ArrayList<Node> sort() {
		 ArrayList<Node> nodes = list;
		 int n =nodes.size();
		 
		 for(int i=1;i<n;++i) {
			 Node key = nodes.get(i);
			 int j = i-1;
			 while ( j>=0 &&  nodes.get(j).f()<key.f()) {
				nodes.set(j+1, nodes.get(j));
				j=j-1;
			}
			 nodes.set(j+1,key);
		 }
		 return nodes;
	 }
	
	
	public Node pop() {
		Node node = list.get(size()-1);
		list.remove(size()-1);
		return node;
	}
	
	public void push(Node node) {
		list.add(node);
		sort();
	}
	
	public void push(Pile p) {
		for(Node n:p.list) 	push(n);
	}
	
	
	public boolean isEmpty() {
		
		return false;
	}
	
	ArrayList<Node> toArrayList(){
		return list;
	}
	
	
	public void  print() {
		for(Node n:list) System.out.println(n);
	}
	
	public int size() {
		
		return list.size();
	}
}
