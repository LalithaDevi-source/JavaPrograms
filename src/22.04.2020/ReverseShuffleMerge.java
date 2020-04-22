package Day9;

import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ReverseShuffleMerge {

    static String reverseShuffleMerge(String s) {
    
    	String word = "";
    	int length = s.length()/2;
    	SortedMap<Character, Integer> letterMap = new TreeMap<>();
    	for(char c : s.toCharArray()){
    		Integer cnt = letterMap.get(c);
    		if(cnt == null){
    			cnt = 0;
    		}
    		letterMap.put(c, cnt+1);
    	}  
    	int[] lettersForShuffle = new int[26];     
    	for(Map.Entry<Character, Integer> entry : letterMap.entrySet()){
    		lettersForShuffle[entry.getKey()-'a'] = entry.getValue()/2;
    	}
    	int[] lettersForWord = Arrays.copyOf(lettersForShuffle, lettersForShuffle.length);
    	int index = s.length()-1;
    	int minIndex = s.length()-1;
    
    	int[] tmpLetters = Arrays.copyOf(lettersForShuffle, lettersForShuffle.length);
    	while(index >= 0){
    		char ci = s.charAt(index);
    		if((minIndex == -1 ||ci < s.charAt(minIndex)) && lettersForWord[ci-'a'] > 0){
    			minIndex = index;
    			tmpLetters = Arrays.copyOf(lettersForShuffle, lettersForShuffle.length);
    		}
    		index--;
    		if(lettersForShuffle[ci-'a'] == 0){
    			char minChar = s.charAt(minIndex);
    			word += minChar;
    			lettersForWord[minChar-'a']--;
    			if(word.length() == length){
    				return word;
    			}
    			s = s.substring(0, minIndex);
    			lettersForShuffle = Arrays.copyOf(tmpLetters, tmpLetters.length);
    			index = s.length() - 1;
    			minIndex = - 1;
    		} else {
    			lettersForShuffle[ci-'a']--;
    		}
        }
    	return word;
    }
	// Complete the reverseShuffleMerge function below.
    /*static String reverseShuffleMerge(String s) {
            int a = 'a';
    int m = 'z' - a + 1;
    int[] frequency = new int[m];
    s.chars().forEach(c -> frequency[c - a]++);
    int[] count = Arrays.stream(frequency).map(f -> f / 2).toArray();

    int top = -1;
    int[] stack = new int[s.length()];
    for(int n = s.length(); --n >= 0; ) {
        int c = s.charAt(n) - a;
        frequency[c]--;
        if(count[c] < 1) continue;

        count[c]--;
        while(top >= 0 &&
            stack[top] > c &&
            frequency[stack[top]] > count[stack[top]]) {
                count[stack[top--]]++; // Increment and then pop the stack
        }
        stack[++top] = c; // Push c on to the stack
    }

    return java.util.stream.IntStream.rangeClosed(0, top)
        .mapToObj(c -> Character.toString((char)(stack[c] + a)))
        .collect(java.util.stream.Collectors.joining(""));
        
        


    }
*/
}
