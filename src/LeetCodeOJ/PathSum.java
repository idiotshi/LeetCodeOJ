package LeetCodeOJ;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 * recursion version 
 * idiotshi
 * 2014/12/2
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
    	
    	if(root == null) return false;
    	if(root.left == null && root.right == null)
    		if(root.val == sum) return true;
    	if(hasPathSum(root.left,sum - root.val)) return true;
    	if(hasPathSum(root.right,sum - root.val)) return true;
    	return false;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x;}
}

class BinaryTree {
	
	TreeNode root;
	
	public void insert(int val)
	{
		root = insert(val,root);
	}
	private TreeNode insert(int val,TreeNode node )
	{
		if(node == null)
			return new TreeNode(val);
		
		if(val < node.val)
			node.left = insert(val,node.left);
		else if(val > node.val)
			node.right = insert(val,node.right);
		else
			;
		return node;
	}
	
	/*
	 * preorder traversal
	 * for print
	 */
	public void preOrderTraversal(TreeNode root)
	{
		if(root == null) return;
		System.out.println(root.val);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
}
