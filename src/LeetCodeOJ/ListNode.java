package LeetCodeOJ;

public class ListNode {
	Object value;
	ListNode next;

	
	ListNode(Object o,ListNode n)
	{
		value = o;
		next = n;
	}
	
	ListNode(Object o){
		this(o,null);
	}
	
	ListNode insert(ListNode node)
	{
		if(node == null)
			return null;
		
		
		ListNode tmp = this;
		while(tmp.next != null)
			tmp = tmp.next;
		
		tmp.next = node;
		tmp.next.next = null;
		
		return this;
	}
	void printNode()
	{
		ListNode tmp = this;
		while(tmp.next != null)
		{
			System.out.print(tmp.value);
			System.out.print(" ");
			tmp = tmp.next;
		}
		System.out.print(tmp.value);
		System.out.println();
	}
}
