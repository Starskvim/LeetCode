import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));

    }

    public static int lengthOfLongestSubstring(String s) {

        char[] charsInput = s.toCharArray();
        int maxResult = 0;
        int currentResult = 0;
        HashSet<Character> memory = new HashSet<>();


        for (char ch: charsInput){
            if(!memory.contains(ch)){
                memory.add(ch);
                currentResult += 1;
            } else {
                memory.clear();
                if(currentResult > maxResult) {
                    maxResult = currentResult;
                }
                memory.add(ch);
                currentResult = 1;
            }
        }
        if(currentResult > maxResult) {
            maxResult = currentResult;
        }
        return maxResult;
    }

    public static int lengthOfLongestSubstring2(String s) {

        Queue<Character> queue = new LinkedList<>();

        int maxResult = 0;

        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);

            maxResult = Math.max(maxResult, queue.size());
        }
        return maxResult;
    }
}
