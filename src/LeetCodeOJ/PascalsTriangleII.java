package LeetCodeOJ;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
	        
	        List<Integer> rows = new ArrayList<Integer>();
	        if(rowIndex < 0) return rows;
	        
	        for(int i = 0;i < rowIndex + 1;i++)
	        {
	        	rows.add(0, 1);
	        	for(int j = 1;j < rows.size()-1;j++)
	        	{
	        		rows.set(j, rows.get(j) + rows.get(j+1));
	        	}
	        }
	        
	        return rows;
	
	    }

}
