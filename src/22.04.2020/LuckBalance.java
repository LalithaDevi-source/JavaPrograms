package Day9;

import java.util.ArrayList;
import java.util.Collections;

public class LuckBalance {
	
	  static int luckBalance(int k, int[][] contests) {
		  
		  int max_luck = 0;
		  
		  ArrayList<Integer> imp = new ArrayList<>();
		  
		  for(int i = 0 ; i < contests.length ; i++)
		  {
			  for(int j = 0 ; j < contests[0].length; j++)
			  {
				  if(contests[i][j+1] == 1)
				  {
					  imp.add(contests[i][j]);
				  }
				  else
					  max_luck += contests[i][j];
				  j++;
			  }
		  }
		  
		  Collections.sort(imp);
		  
		  for(int i = 0; i < imp.size(); i++)
		  {
			  if(i < imp.size()-k)
				  max_luck -= imp.get(i);
			  else
				  max_luck += imp.get(i);
		  }
		  
		  return max_luck;

	    }
	  
	  public static void main(String[] args)
	  {
		  int[][] contests = {{5, 1},
				  {2, 1},
				  {1, 1},
				  {8 ,1},
				  {10, 0},
				  {5, 0}};
		  System.out.println(luckBalance(3, contests));
	  }


}
