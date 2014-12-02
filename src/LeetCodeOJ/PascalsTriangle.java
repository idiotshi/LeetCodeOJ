package LeetCodeOJ;
import java.util.*;

public class PascalsTriangle {
	
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> trangle = new ArrayList<List<Integer>>();
		
		if(numRows == 0) return trangle;
		
		for(int i = 0;i < numRows;i++){
			List<Integer> rows = new ArrayList<Integer>();
			for(int j = 0;j < i + 1;j++){
				if(j == 0 || j == i)
					rows.add(1);
				else
					rows.add(trangle.get(i-1).get(j-1) + trangle.get(i-1).get(j));
			}
			trangle.add(rows);
		}
		return trangle;
	}
}
