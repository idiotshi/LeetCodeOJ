package LeetCodeOJ;

import java.util.Random;

public class IntersectionOfLinkedList {
	public static boolean isIntersecedNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;
        
        while(head1.next != null)
        {
        	head1 = head1.next;
        }
        
        while(head2.next != null){
        	head2 = head2.next;
        }
        
        if(head1 == head2)
        	return true;
        else
        	return false;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	int lengthA = 1;
    	int lengthB = 1;
    	
    	if(headA == null || headB == null)
    	    return null;
    	
    	ListNode tmpA = headA;
    	ListNode tmpB = headB;
    	while(tmpA.next != null){
    		tmpA = tmpA.next;
    		lengthA++;
    	}
    	while(tmpB.next != null){
    		tmpB = tmpB.next;
    		lengthB++;
    	}
    	tmpA = headA;
    	tmpB = headB;
    	if(lengthA - lengthB >= 0)
    	{
    		int delta = lengthA - lengthB;
    		while(delta > 0)
    		{
    			tmpA = tmpA.next;
    			delta--;
    		}
    	}
    	else
    	{
    		int delta = lengthB - lengthA;
    		while(delta > 0)
    		{
    			tmpB = tmpB.next;
    			delta--;
    		}
    	}
    	
    	while(tmpA != tmpB )
    	{
    		if(tmpA.next == null || tmpB.next == null)
    			return null;
    		tmpA = tmpA.next;
    		tmpB = tmpB.next;
    	}
    	return tmpA;		   
    }
    
	/*
	 * �򻯵��㷨�����ü�������ĳ���
	 * ʱ�临�Ӷ�O(n+m)���ռ临�Ӷ�O��1��
	 * 1����������A��B��ÿ�θ�һ��
	 * 2.���A���������β������ָ��B���ǵģ���B�������Ƶĵ�B���������βʱ������ָ������A
	 * 3.������κ�һ����A��B��������ĵ���ǽ����
	 */
    
    public static ListNode getIntersectionNode2(ListNode headA,ListNode headB)
    {
    	if(headA == null || headB == null)
    		return null;
    	
    	ListNode pNodeA = headA;
    	ListNode pNodeB = headB;
    	
    	while(pNodeA != pNodeB )
    	{
    		ListNode pNodeAEnd = null;
    		ListNode pNodeBEnd = null;
    		if(pNodeA.next == null)
    		{
    			pNodeAEnd = pNodeA;
    			pNodeA = headB;
    		}
    		if(pNodeB.next == null)
    		{
    			pNodeBEnd = pNodeB;
    			pNodeB = headA;
    		}
    		
    		if(pNodeAEnd != null && pNodeBEnd != null)
    			if(pNodeAEnd != pNodeBEnd)
    				return null;
    		
    		pNodeA = pNodeA.next;
    		pNodeB = pNodeB.next;	
    	}
    	return pNodeA;
    }
    /*
     * �����ȡ�ַ���
     * �����Ժ����ɿ�
     */
    public static String getRandomString(int length) { 
    	//length��ʾ�����ַ����ĳ���  
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();     
     }
    
    public static ListNode creatRandomLinkedList(String head)
    {
	    ListNode head1 = new ListNode(head,null);
		//ListNode head2 = new ListNode("head2",null);
		final ListNode intersectedNode = new ListNode("IntersectedNode",null);
		
		/*
		 * �½���һ��������
		 */
		int listLength = (int)(Math.random()*10);
		while(listLength-- > 0)
			head1.insert(new ListNode(getRandomString(4),null));
		
		//listLength = (int)(Math.random()*10);
		//while(listLength-- > 0)
		//	head2.insert(new ListNode(getRandomString(4),null));
		
		head1.printNode();
		//head2.printNode();
		/*
		 * insert intersectedNode to the end of head1 and head2
		 */
		head1.insert(intersectedNode);
		//head2.insert(intersectedNode);
		
		
		listLength = 1 + (int)(Math.random()*10);
		while(listLength-- > 0)
			intersectedNode.insert(new ListNode(getRandomString(4),null));
		
		head1.printNode();
		//head2.printNode();
		
		return head1;
    }
    
}
