import java.util.Stack;

public class BalancedBrackets {
	
    static String isBalanced(String s) {
    	
    	Stack<Character> st = new Stack<>();
    	
    	for(int i = 0 ; i< s.length() ; i++)
    	{
    		if(s.charAt(i) == '{')
    			st.push('}');
    		if(s.charAt(i) == '[')
    			st.push(']');
    		if(s.charAt(i) == '(')
    			st.push(')');
    		
    		if(s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')')
			{
    			if(!st.empty() && st.peek() == s.charAt(i))
    				st.pop();
    			else
    				return "NO";
			}    			
    			
    	}
    
    	if(st.empty())
    		return "YES";
    	else
    		return "NO";
    }

	
	public static void main(String[] args)
	{
		System.out.println(isBalanced("}([[{)[]))]{){}["));
	}

}
