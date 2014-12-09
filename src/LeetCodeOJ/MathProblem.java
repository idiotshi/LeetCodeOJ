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
	}
}
