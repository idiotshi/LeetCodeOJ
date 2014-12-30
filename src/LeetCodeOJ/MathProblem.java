package LeetCodeOJ;

public class MathProblem {
	public int [] plusOne(int [] digits){
		int carry = 1;
		for(int i = digits.length - 1;i >=0;i--){
			if(carry > 0){
				int tmp = (digits[i] + carry)%10;
				carry =  (digits[i] + carry)/10;
				digits[i] = tmp;
			}else
				return digits;
		}
		if(carry > 0){
			int [] newArray = new int [digits.length + 1];
			newArray[0] = carry;
			for(int i = 0;i < digits.length;i++)
				newArray[i+1] = digits[i];
			
			return newArray;
		}else
			return digits;
	}
	
	public void printArray(int [] array){
		//if(array == null) return;
		for(int i = 0;i < array.length;i++)
			System.out.print(array[i]+" ");
		
		System.out.println();
	}
	
	/*
	 * find pead element
	 * 2014/12/10
	 */
	public int findPeakElement(int [] num){
		if(num.length == 0) return 0;
		int left = 0;
		int right = num.length - 1;
		while(left < right){
			if(num[(left+right)/2 + 1] > num[(left+right)/2])
				left = (left+right)/2 + 1;
			else
				right = (left+right)/2;
		}
		return left;
	}
	
	/*
	 * pow(x,n)
	 * 2014/12/24
	 */
	public double pow(double x,int n){
		if(n == 0)
			return 1;
		if(x == 0)
			return 0;
		if(n < 0){
			n = -n;
			x = 1/x;
		}		
		double tmp = x;	
		double result = 1;
		while( n != 0){
			if(n % 2 != 0)
				result = result * tmp;
			n = n/2;
			tmp = tmp*tmp;
		}
		
		return result;
	}
}
