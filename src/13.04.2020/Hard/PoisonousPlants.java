
import java.util.Stack;

public class PoisonousPlants {
	
	static class Pair {
	    int val, count;
	    public Pair(int val, int count) {
	        this.val = val;
	        this.count = count;
	    }
	}

	// Complete the poisonousPlants function below.
	static int poisonousPlants(int[] p) {
	    Stack<Pair> stack = new Stack<>();
	    int days = 0;
	    for (int i = p.length - 1; i >= 0; i--) {
	        int temp = 0;
	        while (!stack.empty() && p[i] < stack.peek().val) {
	            temp++;
	            Pair pair = stack.pop();
	            temp = Math.max(temp, pair.count);
	        }
	        days = Math.max(days, temp);
	        stack.push(new Pair(p[i], temp));
	    }
	    return days;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {6, 5, 8, 4, 7, 10, 9};
		
		System.out.println(poisonousPlants(arr));
		
	}

}