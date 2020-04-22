package Day8;

import java.util.Arrays;

public class GreedyFlorist {
	
	static int getMinimumCost(int k, int[] c) {
		  Arrays.sort(c);
	        int total = 0;
	        for (int i = c.length - 1; i >= 0; --i) {
	            int timesBought = ((c.length - 1) - i) / k;
	            int price = c[i] * (timesBought + 1);
	            total += price;
	        }
	        return total;

		
    }
	
	public static void main(String[] args)
	{
		int[] c = {1,3, 5, 7, 9};
		System.out.println(getMinimumCost(3, c));
	}

}
