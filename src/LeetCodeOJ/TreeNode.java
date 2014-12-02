package LeetCodeOJ;

public class TreeNode {
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
	
	
	/*
	 * Minimum depth of binary tree
	 * 2014/12/2
	 * idiotshi
	 */
	public int minDepth(TreeNode root){
			if(root == null) return 0;
			
			int leftDepth = minDepth(root.left);
			int rightDepth = minDepth(root.right);
			
			if(leftDepth == 0)
				return rightDepth + 1;
			if(rightDepth == 0)
				return leftDepth + 1;
			return leftDepth < rightDepth ? leftDepth + 1 : rightDepth + 1;
			
			/*
			if(root.left != null && root.right != null){
				if(leftDepth < rightDepth)
					return (leftDepth + 1);
				else
					return (rightDepth + 1);
			}
			if(root.left == null && root.right != null){
				return (rightDepth + 1);
			}
			if(root.left != null && root.right == null){
				return ( leftDepth + 1);
			}
			if(root.left == null && root.right == null){
				return 1;
			}
			return 0;
			*/
	}
	
	/*
	 * non-recrusive mode
	 */
	
	/*
	 * is Balanced Binary Tree
	 * 2014/12/2
	 * idiotshi
	 */
	public boolean isBalanced(TreeNode root)
	{
		if(root == null)
			return true;
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		
		return (Math.abs(leftDepth - rightDepth) < 2 ) 
				&& isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int getDepth(TreeNode root)
	{
		if(root == null) return 0;
		return 1 + Math.max(getDepth(root.left), getDepth(root.right));
	}
}
