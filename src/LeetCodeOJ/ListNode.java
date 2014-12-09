package LeetCodeOJ;

public class ListNode {
	Object value;
	/*
	 * different problem has different ListNode definition
	 */
	int val;
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
	
	/*
	 * Remove Duplicates from Sorted List
	 * 2014/12/8
	 */
	public ListNode deleteDuplicates(ListNode head){
	   	if(head == null) return head;
    	ListNode node = head;
		while(node != null && node.next != null){//{1}
			if(node.value == node.next.value)
				node.next = node.next.next;
			else
			    node = node.next;//{1,1,1}
		}
		
		return head;
	}
	
	
	/*
	 * 2014/12/10
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2 == null) return l1;
        if(l1 == null) return l2;
        
        ListNode head = null;
        if(l1.val < l2.val){
        	head = l1;
        	l1 = l1.next;
        }else{
        	head = l2;
        	l2 = l2.next;
        }
        
        ListNode preNode = head;
        while(l1 != null && l2 != null){
        	if(l1.val < l2.val){
        		preNode.next = l1;
        		l1 = l1.next;
        	}else{
        		preNode.next = l2;
        		l2 = l2.next;
        	}
        	preNode = preNode.next;
        }
        
        if(l1 == null)
        	preNode.next = l2;
        else
        	preNode.next = l1;
        
        return head;  
    }
}
