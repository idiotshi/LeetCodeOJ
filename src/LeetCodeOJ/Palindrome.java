package LeetCodeOJ;

public class Palindrome {
	public boolean isPalindrome(String s){
		int index = 0;
		int index2 = 0;
		
		if(s == null || s.length() < 2) return true;
		
		char [] buf = new char[s.length()];
		for(index = 0;index < s.length();index++){
			//delete non-alphanumeric characters
			if(Character.isLetterOrDigit(s.charAt(index)))
				buf[index2++] = Character.toLowerCase(s.charAt(index));
		}
		index = 0;
		while(index < index2){	
			if(buf[index] != buf[index2 -1])
				return false;
			index++;
			index2--;
		}
		return true;		
	}
	
	/*
	 * do not construct another string buf
	 */
	public boolean isPalindrome2(String s){
		
		if(s == null || s.length() < 2) 
			return true;
		
		int index = 0;
		int index2 = s.length() - 1;

		while(index < index2){
			if(Character.isLetterOrDigit(s.charAt(index))){
				if(Character.isLetterOrDigit(s.charAt(index2))){
					if(Character.toLowerCase(s.charAt(index)) 
							!= Character.toLowerCase(s.charAt(index2)))
						return false;
					index++;
					index2--;
				}else{
					index2--;
				}
			}else{
				index++;
			}
		}
		return true;		
	}
}
