package LeetCodeOJ;

public class LeetCodeOJ {
 
    public static void testIntersectionLinkedList()
    {
    	/*
    	 * test case for intersection linked list
    	 * @idiotshi
    	 * @2014/11/30
    	 */
    	ListNode head1 = IntersectionOfLinkedList.creatRandomLinkedList("head1");
    	ListNode head2 = IntersectionOfLinkedList.creatRandomLinkedList("head2");
    	
    	System.out.print("head1 and head2");
    	if(IntersectionOfLinkedList.isIntersecedNode(head1, head2)==true)
    		System.out.print(" ARE ");
    	else
    		System.out.print(" ARE NOT ");
    	
    	System.out.println("intersected");
    	
    	ListNode result = IntersectionOfLinkedList.getIntersectionNode2(head1,head2);
    	if(result != null)
    		System.out.println(result.value);
    	else
    		System.out.println("null");
    }
    
    public static void testMinStack()
    {
    	int len = 10;
    	MinStack minStackInstance = new MinStack();
    	
		while(len-- > 0){
			int x = (int)(Math.random()*100);
			minStackInstance.push(x);
			System.out.print(x+" ");
		}
    	
    	//minStackInstance.top();
    	System.out.println("MinElement:" + minStackInstance.getMin());
    }
    
    /*
     * test function for Palindrome class
     * 2014/12.1
     * @idiotshi
     */
    public static void testPalindrome()
    {
    	//String testString = "A man, a plan, a canal: Panama";
    	//String testString = "race a car";
    	String testString = null;
    	Palindrome palindromeInstance = new Palindrome();
    	System.out.println(palindromeInstance.isPalindrome(testString) ? "YES":"NO");
    	System.out.println(palindromeInstance.isPalindrome2(testString) ? "YES":"NO");
    }
    
    public static void main(String [] args)
    {
    	//test case for intersectionLinkedList
    	//testIntersectionLinkedList();
    	
    	//test case for MinStack
    	//testMinStack();
    	
    	//test case for Palindrome
    	testPalindrome();
    		
    }
}
