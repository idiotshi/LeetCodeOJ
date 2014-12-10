package LeetCodeOJ;

public class BinarySerachProblem {
	
	/*
	 * given a sorted array,return the index of the target if it exist
	 * or return the index if the target would be insert to
	 * assume that no duplicates in the array
	 * 2014/12/10
	 */
	public int searchInsert(int[] A, int target) {
        if(A == null) return 0;
        if(A.length == 0) return 0;
        
        int left = 0;
        int right = A.length - 1;
       
        while( left <= right ){
        	if(target == A[(left + right)/2])
        		return (left + right)/2;
        	else if(target < A[(left + right)/2])
        		right = (left + right)/2 - 1;
        	else
        		left = (left + right)/2 + 1;
        }
        
        return left < 0 ? 0 : left;  
    }
}
