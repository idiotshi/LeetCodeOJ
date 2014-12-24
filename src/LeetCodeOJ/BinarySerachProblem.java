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
	
	/*
	 * suppose a sorted array is rotated at some pivot unkonw to you
	 * return the index of the target
	 * 2014/12/10
	 */
	public int search(int [] A,int target){
		if(A == null ) return 0;
		int left = 0;
		int right = A.length-1;
		
		//consider all elements are duplicates
		if(left == right)
			return A[left] == target ? left:-1;
		if(A[left] == target)
			return left;
		if(A[right] == target)
			return right;
			
		/*
		 * find the pivot point
		 */
		int pivot = findPivot(A,left,right);
		
		if(target < A[A.length-1])
			return helper(A,pivot+1,A.length-1,target);
		else
			return helper(A,0,pivot,target);
	}
	
	int findPivot(int [] A,int left,int right){
		if(right -left < 2)
			return left;
		if(A[left] < A[right])
			return left;

		while(left < right){
			if(right -left < 2)
				return A[left] > A[right] ? left:right;
			int mid = (left + right)/2;
			
			/*consider duplicates exists,add equal 
			* if A[mid] == A[left],we dont know which side the pivot is locate,e.g 
			* {1,1,3,1,1,1,1} ,A[mid] = A[3] = 1 == A[left] = A[0],in this case we should locate the left side of
			* the mid,that should be right = mid-1;
			* but given {1,1,1,3},A[mid] = 1 == A[left] = A[0],in this case we should locate the right
			* side of the mid
			* we should locate the both sides!!
			*/
			if(A[mid] >= A[mid -1] && A[mid] > A[mid+1])
				return mid;
			else if(A[mid] > A[left])
				left = mid + 1;
			else if(A[mid] < A[left])
				right = mid -1;
			else
				left++;
		}
		return left;
	}
	int helper(int [] A,int left,int right,int target){
		if(target < A[left] || target > A[right])
			return -1;
		if(right -left < 2){
			if(A[left] == target)
				return left;
			else if(A[right] == target)
				return right;
			else
				return -1;
		}
		while(left <= right){
			if(left == right)
				return A[left] == target ? left:-1;
			int mid = left + (right - left)/2;
			if(A[mid] == target)
				return mid;
			else if(target < A[mid])
				right = mid -1;
			else 
				left = mid + 1;
		}
		return -1;
	}
	
	/*
	 * 2014/12/23
	 * return the range of the target in a array,[start,end]
	 */
	public int[] searchRange(int[] A, int target) {  
        
		int [] range = {-1,-1};
        int left = 0;
        int right = A.length - 1;
        
//        if(A.length == 1){
//        	if(A[0] == target){
//	        	range[0] = 0;
//	        	range[1] = 0;
//	        	return range;
//        	}else {
//            	return range;
//            }
//        }
        if(hasTarget(A,target)){
        	range[0] = 1 + binarySearchRange(A,(double)(target - 0.5));
        	range[1] = binarySearchRange(A,(double)(target + 0.5));
        }
        
        return range;
    }
	
	public int binarySearchRange(int [] A,double target){
        int left = 0;
        int right = A.length - 1;
        
        while(left <= right) {
        	//{1,4},target 4
        	//{5,7,7,8,8,10},tartet 8
//        	if(left == right)
//        		return target < A[left] ? left -1:left;
        	int mid = (left + right)/2;
//        	if(target < A[left])
//        		return left;
//        	if(target > A[right])
//        		return right;
        	if(target < A[mid])
        		right = mid -1;
        	else
        		left = mid + 1;
        }
        return right;
	}
	
	public boolean hasTarget(int [] A,double target){
        int left = 0;
        int right = A.length - 1;
        
        while(left <= right) {
        	int mid = (left + right)/2;
        	if(target == A[mid])
        		return true;
        	if(target < A[mid])
        		right = mid -1;
        	else
        		left = mid + 1;
        }
        return false;
	}
	
	
	/*
	 * search matrix
	 * 2014/12/24
	 */
	public boolean searchMatrix(int [][] matrix,int target){
		int rows = matrix.length;
		int lines = matrix[0].length;
		
		int left = 0;
		int right = rows -1;
		int mayExistRow = -1;
		while(left <= right){
			int mid = (left + right)/2;
			//use (mid+1)*lines-1 to avoid exceed the array boundary
			if(matrix[mid][0] <= target 
					&& target <= matrix[mid][lines-1]){
				mayExistRow = mid;
				break;
			}
			else if(matrix[mid][0] < target)
				left = mid + 1;
			else
				right = mid-1;
		}
		
		if(mayExistRow >= 0){
			left = 0;
			right = lines -1;
			while(left <= right){
				int mid = (left + right)/2;
				if(matrix[mayExistRow][mid] == target)
					return true;
				else if(matrix[mayExistRow][mid] < target)
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return false;
	}
}
