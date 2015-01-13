package LeetCodeOJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
}
