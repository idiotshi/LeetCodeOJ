package LeetCodeOJ;

public class ClimbingStairs {
	public int climbStairs(int n){
		if(n <= 0) return 0;
		int [] stairs = {1,2};
		for(int i = 2;i < n;i++){
			stairs[i%2] = stairs[0]+stairs[1];
		}
		
		return n % 2 == 0 ? stairs[1]:stairs[0];
	}
}
