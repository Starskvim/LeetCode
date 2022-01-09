import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("56"));
    }

    public static List<String> letterCombinations(String digits) {

        LinkedList<String> result = new LinkedList<>();

        if(digits.isEmpty()) return result;

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        while(result.peek().length()!=digits.length()){
            String remove = result.remove();

            String map = mapping[digits.charAt(remove.length()) - '0'];
            for(char c: map.toCharArray()){
                result.addLast(remove+c);
            }
        }
        return result;
    }
}
