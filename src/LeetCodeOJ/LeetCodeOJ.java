package LeetCodeOJ;

import java.util.Random;

public class LeetCodeOJ {

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
	 * 简化的算法，不用计算链表的长度
	 * 时间复杂度O(n+m)，空间复杂度O（1）
	 * 1。遍历链表A和B，每次各一步
	 * 2.如果A到达链表结尾，重新指向B（是的，是B）；类似的当B到达链表结尾时，重新指向链表A
	 * 3.如果在任何一点上A与B相遇，则改点就是交叉点
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
     * 随机获取字符串
     * 考虑以后做成库
     */
    public static String getRandomString(int length) { 
    	//length表示生成字符串的长度  
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();     
     }   

    
    public static void main(String [] args)
    {
    	ListNode head1 = new ListNode("head1",null);
    	ListNode head2 = new ListNode("head2",null);
    	ListNode intersectedNode = new ListNode("IntersectedNode",null);
    	
    	/*
    	 * 新建第一个单链表
    	 */
    	int listLength = (int)(Math.random()*10);
    	while(listLength-- > 0)
    		head1.insert(new ListNode(getRandomString(4),null));
    	
    	listLength = (int)(Math.random()*10);
    	while(listLength-- > 0)
    		head2.insert(new ListNode(getRandomString(4),null));
    	
    	head1.printNode();
    	head2.printNode();
    	/*
    	 * insert intersectedNode to the end of head1 and head2
    	 */
    	head1.insert(intersectedNode);
    	head2.insert(intersectedNode);
    	
    	
    	listLength = 1 + (int)(Math.random()*10);
    	while(listLength-- > 0)
    		intersectedNode.insert(new ListNode(getRandomString(4),null));
    	
    	head1.printNode();
    	head2.printNode();
    	
    	System.out.print("head1 and head2");
    	if(isIntersecedNode(head1,head2)==true)
    		System.out.print(" ARE ");
    	else
    		System.out.print(" ARE NOT ");
    	
    	System.out.println("intersected");
    	
    	ListNode result = getIntersectionNode2(head1,head2);
    	if(result != null)
    		System.out.println(result.value);
    	else
    		System.out.println("null");
    		
    }
}
