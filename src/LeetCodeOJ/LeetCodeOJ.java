package LeetCodeOJ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
    
    /*
     * test function for math problem
     * 2014/12/8
     */
    
    public static void testMathProblem()
    {
    	MathProblem mathProblemInstance = new MathProblem();
    	int [] array = {0,0};
    	
    	System.out.println("input array:");
    	mathProblemInstance.printArray(array);
    	
    	System.out.println("after plus one");
    	mathProblemInstance.printArray(mathProblemInstance.plusOne(array));
    	
    	System.out.println("find one LOCAL peak element index:");
    	System.out.println(mathProblemInstance.findPeakElement(array));
    	
    	/*
    	 * test pow(x,n)
    	 * 2014/12/24
    	 */
    	double x = 2;
    	int n = -2;
    	double result = mathProblemInstance.pow(x, n);
    	System.out.println("pow("+x+","+n+") is: "+result);
    }
    
    /*
     * test binary search problem
     * 2014/12/10
     */
    public static void testBinarySearchProblem(){
    	BinarySerachProblem binarySearchProblemInstance = new BinarySerachProblem();
    	
    	System.out.println("search insert position");
    	int [] array = {3};
    	for(int i = 0;i < 2*array.length;i++){
    		/*
    		 * search insert position
    		 */
    		System.out.print("the index of target " + i + " in array is: "
    				+ binarySearchProblemInstance.searchInsert(array, i));
    		System.out.println();
    	}
    	
		/*
		 * search in rotated sorted array
		 */
    	System.out.println("search in rotated sorted array");
    	//int [] array2 = {4,5,6,7,0,1,3};
    	//int [] array2 = {1,3,5};
    	//int [] array2 = {3,1};
    	//int [] array2 = {1};
    	//int [] array2 = {3,5,1};
    	//int [] array2 = {3,4,5,6,1,2};//2
    	//int [] array2 = {8,9,2,3,4};
    	
    	//int [] array2 = {3,3,5,5,0,2,2,2,2,2,3};
    	//int [] array2 = {3,3};
    	//int [] array2 = {1,3,1,1,1};
    	//int [] array2 = {1,1,3,1,1,1,1};
    	int [] array2 = {1,1,1,3};
		//System.out.print(binarySearchProblemInstance.search(array2,9));
    	for(int i = 0;i < 2*array2.length;i++){
    		/*
    		 * search insert position
    		 */
    		System.out.print("the index of target " + i + " in array is: "
    				+ binarySearchProblemInstance.search(array2,i));
    		System.out.println();
    	}
    	
    	/*
    	 * search the range
    	 * 2014/12/23
    	 */
    	int [] array3 = {5,5,7,7,8,8,10};
    	//int [] array3 = {5,7,7,8,8,8};
    	//int [] array3 = {8};
    	//int [] array3 = {8,8};
    	//int [] array3 = {5,5};
    	//int [] array3 = {1,4};
    	int[] range = binarySearchProblemInstance.searchRange(array3, 8);
    	System.out.print("the range of 8 is: { "+ range[0] +"," + range[1] + " }" );
    	System.out.println();

    	/*
    	 * search the range
    	 * 2014/12/23
    	 */
//    	int [][] matrix = {
//    						{1,3,5,7},
//    						{10,11,16,20},
//    						{23,30,34,50}
//    					};
    	int [][] matrix = {{1}};
    	int target = 1;
    	boolean exist = binarySearchProblemInstance.searchMatrix(matrix, target);
    	System.out.print("the target: "+ target +" is ");
    	if(!exist)
    		System.out.print("NOT ");
    	System.out.println("in the matrix");
    	
    	/*
    	 * test findMedianSortedArrays
    	 * 2014/12/25
    	 * case1:{},{1}
    	 * case2:{1,2},{3,4}
    	 * case3:{1,2,3},{4,5,6}
    	 * case4{1,2},{1,2}
    	 * case5{1,1},{1,2}
    	 * case6{1,2},{1,2,3}
    	 * case 7{2,3}{1,4}
    	 */
    	int [] B = {1,2,6,7};
    	int [] A = {3,4,5,8};
    	double median = binarySearchProblemInstance.findMedianSortedArrays(A, B);
    	System.out.println("The median of array A and B is: "+median);
    	
    	/*
    	 * 2014/12/28
    	 * Find Minimum in Rotated Sorted Array
    	 */
    	//int [] array4 = {3,1,1,1,1};
    	//int [] array4 = {10,10,1,10,10};
    	int [] array4 = {3,3,1,3,3,3,3};
    	System.out.println("search Minimun in rotated sorted array: "
    					+binarySearchProblemInstance.findMin(array4));
    	
    }
    
    public static void testDPProblem(){
    	DPSolution instance = new DPSolution();
    	
    	//String s = "leetcode";
    	String s  = "catsanddog";
    	//String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    	Set<String> dict = new HashSet();
    	//dict.add("leet");
    	//dict.add("code");
    	dict.add("cat");
    	dict.add("cats");
    	dict.add("and");
    	dict.add("sand");
    	dict.add("dog");
//    	dict.add("a");
//    	dict.add("aa");
//    	dict.add("aaa");
//    	dict.add("aaaa");
//    	dict.add("aaaaa");
//    	dict.add("aaaaaa");
//    	dict.add("aaaaaaa");
//    	dict.add("aaaaaaaa");
//    	dict.add("aaaaaaaaa");
//    	dict.add("aaaaaaaaaa");

    	
    	instance.wordBreak(s, dict);
    	
    	List<String> solution = instance.wordBreak2(s, dict);
    	Iterator<String> it = solution.iterator();
    	while(it.hasNext()){
    		String value = it.next();
    		System.out.println(value);
    	}
    	
    	/*
    	 * test  triangle
    	 */
    	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	int [] input = {2,3,4,6,5,7,4,1,8,3};
    	int n = 4;
    	for(int i = 0;i < n;i++){
    		List<Integer> rows = new ArrayList<Integer>();
    		int temp = i*(i+1)/2;
    		for(int j = 0; j <= i;j++){
    			//rows.add((int) (10*Math.random()));
    			rows.add(input[temp+j]);
    		}
    		triangle.add(rows);
    	}
    	
    	
    	System.out.println(instance.minimumTotal(triangle));
    	
    	
    	/*
    	 * test scramble string
    	 */
    	String s1 = "a";
    	String s2 = "a";
    	
//    	String s1 = "abc";
//    	String s2 = "acb";
    	
    	System.out.println(instance.isScramble(s1, s2));
    	
    	
    	/*
    	 * test minpathsum
    	 */
    	int [][] grid = {
			    			{1,2,3},
			    			{2,4,5}
			    		};
    	
    	System.out.println(instance.minPathSum(grid));
    	
    	/*
    	 * test distinct subsequences
    	 * 2015.1.28
    	 */
//    	String S = "rabbbit";
//    	String T = "rabbit";
    	
//    	String S = "ccc";
//    	String T = "c";
    	
//    	String S = "c";
//    	String T = "ccc";
    	String S = "";
    	String T = "";
    	
    	System.out.println("The num of distinct subsequences: " + instance.numDistinct(S, T));
    	
    	/*
    	 * test interleaving string
    	 */
    	String ss1 = "a";
    	String ss2 = "b";
    	String ss3 = "ab";
    	System.out.println("IS interleave string: " + instance.isInterleave(ss1, ss2, ss3));
    	
    	/*
    	 * test best time to sell stock iii
    	 * 2015/1/30
    	 */
    	int [] prices = {1,2,7,3,8,9};
    	//int [] prices = {1,-1,-3,4,9};
    	System.out.println("MAX profits: " + instance.maxProfit3(prices));
    	
    	
    	/*
    	 * test minDistance
    	 */
    	String word1 = "a";
    	String word2 = "abc";
    	
    	System.out.println("Min Distance: " + instance.minDistance(word1, word2));
    	
    	/*
    	 * test isParentheses
    	 */
    	StringProblem stringInstance = new StringProblem();
    	//String brackets = "(){}[][";
    	String brackets = "c";
    	System.out.println("IS brackets matched: " + stringInstance.isValid(brackets));
    	
    	/*
    	 * test excel sheet column number
    	 */
    	String excelTitle = "AAA";
    	System.out.println("The String :"+excelTitle+" 's column number in excel is:" + stringInstance.titleToNumber(excelTitle));
    	
    	/*
    	 * test excel sheet column title
    	 */
    	//int i = 1;
    	//int i = 0;
    	//int i = 2;
    	//int i = 25;
    	//int i = 26;
    	//int i = 27;
    	//int i = 53;
    	int i = 703;
    	System.out.println("Title: "+stringInstance.convertToTitle(i));
    	
    	/*
    	 * test add binary
    	 */
    	String a = "11";
    	String b = "1";
    	System.out.println("BINARY ADD of "+"("+a+","+b+") is:"+stringInstance.addBinary(a, b));
    	
    	/*
    	 * test compare version
    	 */
    	String version1 = "01111";
    	String version2 = "1";
    	System.out.println("version1 VS version2: "+stringInstance.compareVersion(version1, version2));
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
    	//testClimbingStairs();
    	
    	/*
    	 * test plus one problem
    	 * 2014/12/8
    	 */
    	//testMathProblem();
    	
    	/*
    	 * 2014/12/10
    	 */
    	//testBinarySearchProblem();
    	
    	/*
    	 * 2015/1/9
    	 */
    	testDPProblem();
    }
}
