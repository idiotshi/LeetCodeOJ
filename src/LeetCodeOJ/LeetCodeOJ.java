package LeetCodeOJ;

import java.util.Random;

public class LeetCodeOJ {
 
    public static void testIntersectionLinkedList()
    {
    	/*
    	 * test case for intersection linked list
    	 * @idiotshi
    	 * @2014/11/30
    	 */
    	IntersectionOfLinkedList testInstance = new IntersectionOfLinkedList();
    	ListNode head1 = testInstance.creatRandomLinkedList("head1");
    	ListNode head2 = testInstance.creatRandomLinkedList("head2");
    	
    	System.out.print("head1 and head2");
    	if(testInstance.isIntersecedNode(head1, head2)==true)
    		System.out.print(" ARE ");
    	else
    		System.out.print(" ARE NOT ");
    	
    	System.out.println("intersected");
    	
    	ListNode result = testInstance.getIntersectionNode2(head1,head2);
    	if(result != null)
    		System.out.println(result.value);
    	else
    		System.out.println("null");
    }
    
    public static void main(String [] args)
    {
    	//test case for intersectionLinkedList
    	testIntersectionLinkedList();
    		
    }
}
