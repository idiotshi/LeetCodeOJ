package LeetCodeOJ;
import java.util.*;
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
		System.out.print(root.val + " ");
		
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
	
	/*
	 * Binary tree level order traversal
	 * idiotshi
	 * 2014/12/3 
	 */
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null)
			return result;
		
		List<Integer> level = new ArrayList<Integer>();
		LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		
		TreeNode current = root;
		TreeNode levelLast = root;
		
		nodeQueue.offer(root);
		
		
		while( !nodeQueue.isEmpty()){
			current = nodeQueue.poll();
			level.add(current.val);
			
			if(current.left != null)
				nodeQueue.offer(current.left);
			if(current.right != null)
				nodeQueue.offer(current.right);
			
			if(current == levelLast){
				result.add(level);
				level = new ArrayList<Integer>();
				levelLast = nodeQueue.peekLast();
			}
		}
		return result;
	}
	
	/*
	 * do NOT complete
	 * dont know how to 
	 */
	public List<List<Integer>> levelOrderDfs(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		
		dfsLevelOrder(root,0,result);
		return result;
	}
	private void dfsLevelOrder(TreeNode root,int level,List<List<Integer>> result)
	{
		if(root == null)
			return;
		//while(result.size() <= level)
			//result.add(new ArrayList<Integer>());
		List<Integer> row;
		if(level == 0){
			row = new ArrayList<Integer>();
			row.add(root.val);
		}else{
			row = result.get(level);
			row.add(root.val);
		}
		result.add(level, row);
		dfsLevelOrder(root.left,level+1,result);
		dfsLevelOrder(root.right,level+1,result);
	}
}
