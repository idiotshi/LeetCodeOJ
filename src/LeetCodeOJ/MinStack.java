package LeetCodeOJ;

import java.util.Stack;

public class MinStack {
	
	/*
	 * first methord
	 * use to stack ,one for value,the other for relative min value
	 */
	private Stack<Integer> s = new Stack<Integer> ();
	private Stack<Integer> mins= new Stack<Integer> ();
	
	public void push(int x){
		if(mins.isEmpty() || x <= mins.peek())
			mins.push(x);
		s.push(x);
	}
	
	public void pop(){
		if(s.isEmpty()) return;
		if(s.peek().equals(mins.peek()))
			mins.pop();
		s.pop();
	}
	public int top(){
		return s.peek();
	}
	public int getMin(){
		return mins.peek();
	}
}
