package LeetCodeOJ;

public class MergeSortedArray {
	public void merge(int A[],int m,int B[],int n){
		int i = m-1,j = n-1,k = m + n -1;
		while(i >= 0 && j >= 0){
			if(A[i] > B[j]){
				A[k] = A[i];
				i--;
				k--;
			}else if(A[i] < B[j]){
				A[k] = B[j];
				j--;
				k--;
			}else{
				A[k] = B[j];
				j--;
				k--;
			}
		}
		if(i < 0){
			while(j >=0){
				A[k] = B[j];
				j--;
				k--;
			}
		}
	}
}