package LeetCodeOJ;

import java.util.Stack;

public class StringProblem {
	
	
	/*
	 * valid parentheses
	 * 2015/2/4
	 */
	public boolean isValid(String s){
		char [] characters = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		char check;
		for(char c : characters){
			if(c == '{' || c == '(' || c == '['){
				stack.push(c);
			}else{
				if(!stack.isEmpty()){
					check = stack.pop();
					if(!isMatch(check,c))
						return false;
				}else
					return false;
			}
		}
		return stack.isEmpty();
	}
	
	private boolean isMatch(char c1,char c2){
		if(c1 == '{' && c2 == '}')
			return true;
		if(c1 == '(' && c2 == ')')
			return true;
		if(c1 == '[' && c2 == ']')
			return true;
		return false;
	}
	
	/*
	 * excel sheet column number
	 * 2015/2/4
	 */
	public int titleToNumber(String s){
		if(s.length() <= 0)
			return 0;
		int num = 0;

		for(int i = s.length() -1;i >= 0;i--){
			if(((int)s.charAt(i)) >=65 && ((int)s.charAt(i)) <= 95)
				num += ((int)s.charAt(i) - 64)*Math.pow(26, (s.length()-1-i));
		}
		return num;
	}
	
	/*
	 * Excel Sheet Column Title 
	 */
	public String convertToTitle(int n){
		if(n < 1)
			return "";
		String title = "";

		int divide = n;
		do{
			int mod = (divide-1) % 26;
			divide = (divide-1)/26;
			title += (char) (mod+65);
			if(divide < 26 && divide > 0)
				title += (char)(divide+64);
		}while(divide >= 26);
		return new StringBuilder(title).reverse().toString();
	}
	
	/*
	 * add binary
	 */
	public String addBinary(String a,String b){
		int m = a.length();
		int n = b.length();
		int carry = 0;
		String result = "";
		
		for(int i = 0;i<Math.max(n, m);i++){
			int p = i < m ? a.charAt(m - 1 -i) - '0' : 0;
			int q = i < n ? b.charAt(n - 1 -i) - '0' : 0;
			int tmp = p+q+carry;
			carry = tmp/2;
			result = tmp%2 + result;
		}
		return (carry == 1)? "1"+result : result;
	}
	
	/*
	 * compare two version number
	 */
	public int compareVersion(String version1,String version2){
		String [] num1 = version1.split("\\.");
		String [] num2 = version2.split("\\.");
		int m = num1.length;
		int n = num2.length;
		int maxLen = Math.max(m, n);
		
		for(int i = 0; i < maxLen;i++){
			int p = i < m ? Integer.parseInt(num1[i]) : 0;
			int q = i < n ? Integer.parseInt(num2[i]) : 0;
			
			if(p < q) 
				return -1;
			if(p > q) 
				return 1;
		}
		return 0;
	}
	
	/*
	 *ZigZag Conversion
	 *寻找下标规律
	 */
	public String zigZagConvert(String s,int nRows){
		if(nRows <= 1 || s.length() == 0)
			return s;
		
		String res = "";
		int len = s.length();
		
		for(int i = 0;i < nRows && i < len;i++){
//			if(i >= len)
//				break;
			
			int idx = i;
			res += s.charAt(idx);
			for(int k = 1;idx < len;k++){
				if(i == 0 || i == nRows -1)
					idx += 2*(nRows-1);
				else{
					if((k & 0x1) == 1)
						idx += 2*(nRows - i -1);
					else
						idx += 2*i;
				}
				if(idx < len)
					res += s.charAt(idx);	
			}
		}
		return res;
	}
	
	/*
	 * simplify unix path
	 * 2015/2/10
	 */
	public String simplifyPath(String path){
		Stack<String> stack = new Stack();
		int len = path.length();
		int pos = 0;
		
		while(pos < len){
			while(pos < len && path.charAt(pos) == '/')
				pos++;
			
			int start = pos;
			while(pos < len && path.charAt(pos) != '/')
				pos++;
			
			if(start == pos)
				break;
			String tmp = path.substring(start, pos);
			
			if(tmp.equals("."))
				continue;
			else if(tmp.equals("..")){
				if(!stack.isEmpty()){
					stack.pop();
				}
			}else
				stack.push(tmp);
		}			
		String res = "";
		while(!stack.isEmpty()){
			res = "/" + stack.pop() + res;
		}
		if(res == "") 
			res = "/";
		return res;
	}
	
	/*
	 * 2015/2/10
	 * longest common prefix
	 */
	public String longestCommonPrefix(String [] strs){
		if(strs.length <= 0)
			return "";
		String prefix = strs[0];
		for(int i = 1; i < strs.length;i++){
			if(prefix.length() == 0 || strs[i].length() == 0)
				return "";
			
			int len = Math.min(prefix.length(), strs[i].length());
			int j = 0;
			for(j = 0;j < len;j++){
				if(prefix.charAt(j) != strs[i].charAt(j)){
					break;
				}
			}
			prefix = prefix.substring(0,j);
			
		}
		return prefix;
	}
	
	public int lengthOfLastWord(String s){
		int len = s.length();
		int lastWordLen = 0;
		boolean newWorld = false;
		for(int i = 0;i < len;i++){
			if(s.charAt(i) != ' '){
				if(newWorld){
					lastWordLen = 1;
					newWorld = false;
				}else
					lastWordLen++;
			}	
			else
				newWorld = true;
		}
		return lastWordLen;
	}
}
