package Day9;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
	
	static int minimumAbsoluteDifference(int[] arr) {
		
		Arrays.sort(arr);
		
		int min = Integer.MAX_VALUE;
		
			for(int j = 0 ; j < arr.length; j++)
			{
				if(j+1< arr.length)
				{
					int newMin = Math.abs(arr[j]-arr[j+1]);
					min = Math.min(newMin, min);
				}
			}
		return min;
    }
	
	public static void main(String[] args)
	{
		int[] arr = {3, -7, 0};
		System.out.println(minimumAbsoluteDifference(arr));
	}

}
