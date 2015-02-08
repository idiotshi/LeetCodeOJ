package LeetCodeOJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DPSolution {
	/*
	 * 2015/1/9
	 * Wildcard Matching
	 * NOT complete
	 */
	 public boolean isMatch(String s, String p) {
	       return false; 
	 }
	 
	 /*
	  * 2015/1/9
	  * word break
	  */
	 public boolean wordBreak(String s,Set<String> dict) {
		 
		 boolean [] canBreak = new boolean[s.length()+1];
		
		 canBreak[0] = true;
		 for(int i = 1;i <= s.length();i++){
			 for(int j = 0;j < i;j++){
				 if(canBreak[j] && dict.contains(s.substring(j, i))){
					 canBreak[i] = true;
					 break;
				 }
			 }
		 }
		 
		 return canBreak[s.length()];
	 }
	 
	 /*
	  * world break ii
	  * 2015/1/9
	  */
	 public List<String> wordBreak2(String s,Set<String> dict) {
		 Map<Integer,List<String>> validMap = new HashMap<Integer,List<String>>();
		 

	     // initialize the valid values
	     List<String> l = new ArrayList<String>();
	     l.add("");
	     validMap.put(0, l);
	     
//		 boolean [] canSpace = new boolean[s.length() + 1];
//		 canSpace[0] = true;
//	     for(int i = 1;i <= s.length();i++){
//	    	 for(int j = 0;j < i;j++){
//	    		 if(canSpace[j] && dict.contains(s.substring(j, i))){
//	    			 canSpace[i] = true;
//	    			 break;
//	    		 }
//	    	 }
//	     }
	     //if(canSpace[s.length()] = true){
			 for(int i = 1;i <= s.length();i++){
				 List<String> values = new ArrayList<String>();
				 for(int j = i-1;j >= 0;j--){
					 if(dict.contains(s.substring(j, i))){
						 for(String word : validMap.get(j)){
							 values.add(word + (word.isEmpty() ? "" : " ")
								 + s.substring(j, i));
						 }
					 }
				 }
				 validMap.put(i, values);
			 }
			 return validMap.get(s.length());
		// }
	   //  return null;
	 }
	 
	 /*
	  * uniquePath
	  * 2015/1/13
	  */
	 public int uniquePaths(int m,int n) {
		 
		 if(m <= 0 || n <= 0)
			 return 0;
		 int [][] paths = new int[m][n];
		 for(int i = 0;i < m ;i++){
			 paths[i][0] = 1;
		 }
		 for(int i = 0;i < n;i++){
			 paths[0][i] = 1;
		 }
		 
		 for(int i = 1;i < m;i++){
			 for(int j = 1;j < n;j++){
				 paths[i][j] = paths[i-1][j] + paths[i][j-1];
			 }
		 }
		 
		 return paths[m-1][n-1];
	 }
	 
	 /*
	  * uniquePaths with obstacles
	  * 2015/1/13
	  */
	 public int uniquePathWithObatacles(int [][] obstacleGrid){
		 int rows = obstacleGrid.length;
		 int cols = obstacleGrid[0].length;
		 
		 if(rows <= 0 && cols <= 0)
			 return 0;

		 for(int i = 0;i < rows;i++){
			 for(int j = 0;j < cols;j++){
				 if(obstacleGrid[i][j] == 1)
					 obstacleGrid[i][j] = 0;
				 else if(i ==0 && j == 0)
					 obstacleGrid[i][j] = 1;
				 else if(i == 0)
					 obstacleGrid[i][j] = obstacleGrid[i][j-1];
				 else if(j == 0)
					 obstacleGrid[i][j] = obstacleGrid[i-1][j];
				 else
					 obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
			 }
		 }
		 return obstacleGrid[rows-1][cols-1];
	 }
	 
	 /*
	  * unique binary tree
	  * 
	  */
	 public int numTrees(int n){
		 int [] num = new int[n+1];
		 num[0] = 1;
		 
		 for(int i = 1;i <= n;i++){
			 for(int j = 0;j < i;j++){
				 num[i] += num[j] * num[i-1-j];
			 }
		 }
		return num[n];
	 }
	 
	 
	 /*
	  * triangle
	  * Given a triangle, find the minimum path sum from top to bottom.
	  *  Each step you may move to adjacent numbers on the row below.
	  *  2015/1/16
	  */
	 public int minimumTotal(List<List<Integer>> triangle){
		 int rows = triangle.size();
		 List<Integer> minPathSum = new ArrayList<Integer>();
		 minPathSum.addAll(triangle.get(rows-1));
		 
		 for(int i = rows -2;i >= 0;i--){
			 for(int j = 0;j <= i;j++){
				 int sum = Math.min(minPathSum.get(j), minPathSum.get(j+1)) + triangle.get(i).get(j);
				 minPathSum.set(j, sum);
			 }
		 }
		 return minPathSum.get(0);
	 }
	 
	 /*
	  * Scramble String
	  * 2015/1/23
	  */
	 public boolean isScramble(String s1,String s2){
		 if(s1.length() != s2.length())
			 return false;
		 int len = s1.length();
		 boolean opt[][][] =  new boolean[len+1][len][len];
		 
//		 for(int i = len - 1;i >= 0;i--){
//			 for(int j = len - 1;j >= 0;j--){
//				 opt[i][j][1] = s1.substring(i, i+1).equals(s2.substring(j, j+1)) ? true : false;
//				 for(int l = 2; (i + l) <= len && (j + l) <= len;l++){
//					 for(int n = 1;n < l;n++){
//						 opt[i][j][l] = (opt[i][j][n] && opt[i+n][j+n][l-n])
//								 || (opt[i][j+l-n][n] && opt[i+n][j][l-n]);
//					 }
//				 }
//			 }
//		 }
		 
		 for(int i = 0;i < len;i++){
			 for(int j = 0;j < len;j++){
				 opt[1][i][j] = s1.substring(i, i+1).equals(s2.substring(j, j+1)) ? true : false;
			 }
		 }
		 
		 for(int n = 2;n <= len;n++){
			 for(int i = 0;i + n <= len;i++){
				 for(int j = 0;j + n <= len;j++){
					 for(int k = 1;k < n;k++){
						 if((opt[k][i][j] && opt[n-k][i+k][j+k]) || (opt[k][i][j+n-k] && opt[n-k][i+k][j]))
							 opt[n][i][j] = true;
					 }
				 }
			 }
		 }
		 
		 return opt[len][0][0];
	 }
	 
	 /*
	  * minimum path sum
	  * 2015/1/26
	  */
	 public int minPathSum(int [][] grid) {
		 int rows = grid.length;
		 int cols = grid[0].length;
		 if(rows <= 0 || cols <= 0)
			 return 0;
		 int [][] opt = new int[rows][cols];
		 opt[0][0] = grid[0][0];
		 for(int i = 1; i < rows;i++){
			 opt[i][0] = opt[i-1][0] + grid[i][0];
		 }
		 for(int i = 1; i < cols;i++){
			 opt[0][i] = opt[0][i-1] + grid[0][i];
		 }
		 
		 for(int i = 1; i < rows;i++){
			 for(int j = 1; j < cols;j++){
				 opt[i][j] = Math.min(opt[i-1][j], opt[i][j-1]) + grid[i][j];
			 }
		 }
		 return opt[rows-1][cols-1];
	 }
	 
	 
	 /*
	  * 2015.1.28
	  * Distinct subsequences
	  */
	 public int numDistinct(String S,String T){
		 int [][] opt = new int[S.length()+1][T.length()+1];
		 for(int i = 0;i < S.length();i++){
		 	opt[i][0] = 1;
		 }
		 
		 for(int i = 1;i <= S.length();i++){
			 for(int j = 1;j <= T.length();j++){
				 if(S.charAt(i-1) == T.charAt(j-1))
					 opt[i][j] = opt[i-1][j-1] + opt[i-1][j];
				 else
					 opt[i][j] = opt[i-1][j];
			 }
		 }
		 
		 return opt[S.length()][T.length()];
	 }
	 
	 /*
	  * 2015/1/28
	  * max subarray
	  */
	 public int maxSubArray(int [] A){
		 int result = Integer.MIN_VALUE; int sum = 0;
		 for(int i = 0;i < A.length;i++){
			 if(sum < 0)
				 sum = A[i];
			 else
				 sum += A[i];
			 if(result < sum)
				 result = sum;
		 }
		 return result;
	 }
	 
	 /*
	  * 2015/1/28
	  * Interleaving string
	  */
	public boolean isInterleave(String s1,String s2,String s3){
		if(s3.length() != (s1.length() + s2.length()))
			return false;
		
		boolean [][] opt = new boolean[s1.length()+1][s2.length()+1];
		
		opt[0][0] = true;
		for(int i = 1;i <= s1.length();i++){
			opt[i][0] = opt[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1)); 
		}
		for(int i = 1;i <= s2.length();i++){
			opt[0][i] = (opt[0][i-1] && (s2.charAt(i-1)) == (s3.charAt(i-1))); 
		}
		
		for(int i = 1;i <= s1.length();i++){
			for(int j = 1;j <= s2.length();j++){
				if(s1.charAt(i-1) == s3.charAt(i+j-1))
					opt[i][j] = opt[i-1][j];
				if(s2.charAt(j-1) == s3.charAt(i+j-1))
					opt[i][j] = opt[i][j-1];
			}
		}
		
		return opt[s1.length()][s2.length()];
	}
	
	
	/*
	 * Best Time to Buy and Sell Stock
	 * 2015/1/30
	 */
	public int maxProfit(int [] prices){
        if(prices.length <= 0)
            return 0;
		int min = prices[0];
		int maxProfit = 0;
		
		for(int i = 1;i < prices.length;i++){
			min = Math.min(min, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - min);
		}
		return maxProfit;
	}
	
	/*
	 * Best Time to Buy and Sell Stock iii
	 * 2015/1/30
	 */
	public int maxProfit3(int [] prices){
		if(prices.length <= 1)
			return 0;
		
		/*
		 * Time Limit Exceeded
		 * Last executed input:	[10000,9999,9998,9997,9996,9995,9994,9993,9992,9991,9990,9989,9988,9987,9986,9985,9984...
		 */
		/*
		int min = prices[0];
		int [] profit = new int[prices.length];
		//int maxProfitLeft = 0;
		int maxProfitRight = 0;
		int totalMaxProfit = 0;
		
		for(int i = 1;i < prices.length;i++){
			min = Math.min(min, prices[i]);
			profit[i] = Math.max(profit[i], prices[i] - min);
			//profit[i] = maxProfitLeft;
			int max = prices[i];
			for(int j = i;j > 1;j--){
				max = Math.max(max, prices[j]);
				maxProfitRight = Math.max(maxProfitRight, max - prices[j]);
				totalMaxProfit = Math.max(totalMaxProfit, profit[j-1]+maxProfitRight);
			}
		}
		return totalMaxProfit;
		*/
		int min = prices[0];
		int [] profitLeft = new int[prices.length];
		int [] profitRight = new int[prices.length];
		
		for(int i = 1;i < prices.length;i++){
			min = Math.min(min, prices[i]);
			profitLeft[i] = Math.max(profitLeft[i-1], prices[i] - min);
		}
		int max = prices[prices.length-1];
		for(int i = prices.length - 2;i > 0;i--){
			max = Math.max(max, prices[i]);
			profitRight[i] = Math.max(profitRight[i+1], max - prices[i]);
		}
		
		max = 0;
		for(int i = 1;i < prices.length;i++){
			max = Math.max(max,profitLeft[i] +  profitRight[i]);
		}
		return max;
	}
	
	/*
	 * edit distance
	 * 2015/2/2
	 */
	public int minDistance(String word1,String word2){
		

		if(word1.length() == 0)
			return word2.length();
		if(word2.length() == 0)
			return word1.length();
		
		int [][] opt = new int [word1.length()+1][word2.length()+1];
		
		for(int i = 0;i <= word1.length();i++){
			opt[i][0] = i;
		}
		for(int i = 0;i <= word2.length();i++){
			opt[0][i] = i;
		}
		
		for(int i = 1;i <= word1.length();i++){
			//opt[i-1][0] = i-1;
			for(int j = 1;j <= word2.length();j++){
				//opt[0][j-1] = j-1;
				if(word1.charAt(i-1) == word2.charAt(j-1))
					opt[i][j] = opt[i-1][j-1];
				else
					opt[i][j] = Math.min(opt[i-1][j-1], Math.min(opt[i][j-1], opt[i-1][j])) + 1;
			}
		}
		return opt[word1.length()][word2.length()];
	}  
}
