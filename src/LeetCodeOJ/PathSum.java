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
