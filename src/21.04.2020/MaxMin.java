package Day8;

import java.util.Arrays;

public class MaxMin {
	
	static int maxMin(int k, int[] arr) {

	    Arrays.sort(arr);
	    int minu = arr[arr.length-1];
	    int num=0;
	    for(int i =0;i<=arr.length-k;i++)
	    {
	        num = arr[i+k-1] - arr[i];
	        if(num <= minu)
	        {
	            minu = num;
	        }
	    }

	    return minu;
    }
	public static void main(String[] args)
	{
//		int[] arr = {4504,1520,5857,4094,4157,3902,822,6643,2422,7288,8245,9948,2822,1784,7802,3142,9739,5629,5413,7232};
		int[] arr = {10,
				100,
				300,
				200,
				1000,
				20,
				30};
		System.out.println(maxMin(3, arr));
		
		
	}
}
