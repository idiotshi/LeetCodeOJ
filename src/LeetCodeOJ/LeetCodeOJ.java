package LeetCodeOJ;

import java.util.List;

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
    
    /*
     * test function for pascal's triangle
     * 2014/12/2
     * idiotshi
     */
    public static void testPascalsTriangle()
    {
    	PascalsTriangle triangleInstance = new PascalsTriangle();
    	//PascalsTriangleII
    	PascalsTriangleII rowsTnstance = new PascalsTriangleII();

    	int testRows = (int)(Math.random()*20);
    	
		List<List<Integer>> triangle = triangleInstance.generate(testRows);
		
    		
		for(int i = 0;i < testRows;i++)
		{
			for(int j = 0;j < triangle.get(i).size();j++)
			{
				System.out.print(" "+triangle.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
		/*
		 * output Pascal's Triangle II
		 */
		List<Integer> rows = rowsTnstance.getRow(testRows-1); 
		for(int j = 0;j < rows.size();j++)
		{
			System.out.print(" "+rows.get(j)+" ");
		}
		System.out.println();
    		
    	//}
    }
    
    /*
     * test function for binary tree related prob
     * idiotshi
     * 2014/12/2
     */
    public static void binaryTreeRelatedTest()
    {
    	BinaryTree binaryTree = new BinaryTree();
    	PathSum pathSumInstance = new PathSum();
    	
    	binaryTree.insert(5);
    	binaryTree.insert(3);
    	binaryTree.insert(8);
    	binaryTree.insert(2);
    	binaryTree.insert(4);
    	binaryTree.insert(7);
    	binaryTree.insert(10);
    	
    	/*
    	 * test hasPathSum
    	 */
    	System.out.print("hasPathSum: ");
    	if(pathSumInstance.hasPathSum(binaryTree.root, 1))
    		System.out.println("YES");
    	else
    		System.out.println("No");
    	
    	/*
    	 * test preOrderTraversal
    	 */
    	System.out.print("preOrderTraversal: ");
    	binaryTree.preOrderTraversal(binaryTree.root);
    	System.out.println();
    	
    	/*
    	 * test minimum depth
    	 */
    	System.out.print("minDepth: ");
    	System.out.println(binaryTree.minDepth(binaryTree.root));
    	
    	/*
    	 * test isBalanced
    	 */
    	System.out.print("isBalanced: ");
    	System.out.println(binaryTree.isBalanced(binaryTree.root) ? "YES":"No");
    	
    	/*
    	 * test level order
    	 */
    	List<List<Integer>> levelOrderResult = binaryTree.levelOrder(binaryTree.root);
    	System.out.print("levelOrderResult: ");
    	System.out.println(levelOrderResult);
    	
    	//List<List<Integer>> levelOrderResultDfs = binaryTree.levelOrderDfs(binaryTree.root);
    	//System.out.print("levelOrderDfsResult: ");
    	//System.out.println(levelOrderResultDfs);
    	
    }
    
    /*
     * test function for ClimbingStairs
     * 2014/12/8
     */
    public static void testClimbingStairs()
    {
    	ClimbingStairs climbStairInstance = new ClimbingStairs();
    	for(int n = -1;n < 20;n++)
    		System.out.println(climbStairInstance.climbStairs(n)+" ways to climb "+n+" stairs");
    }
    
    
    public static void main(String [] args)
    {
    	//test case for intersectionLinkedList
    	//testIntersectionLinkedList();
    	
    	//test case for MinStack
    	//testMinStack();
    	
    	//test case for Palindrome
    	//testPalindrome();
    	
    	/*
    	 * testPascalsTriangle
    	 */
    	//testPascalsTriangle();
    	
    	
    	/*
    	 * binary tree related prob test
    	 */
    	//binaryTreeRelatedTest();
    	
    	/*
    	 * testClimbingStairs
    	 * 2014/12/8
    	 */
    	testClimbingStairs();
    }
}
