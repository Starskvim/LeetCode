
import java.util.stream.IntStream;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("  0000000000012345678"));

    }

    public static int myAtoi(String s) {

        long result = 0l;
        int resultInt = 0;
        String newString = s;
        boolean minMax = false;
        String numChar;


        IntStream streamString = newString.chars();
        String resultString = streamString.filter(c -> Character.isDigit(c) || c == '.').collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        if (resultString.isEmpty()){
            return 0;
        }

        float res = Float.valueOf(resultString);

        System.out.println(res);
        result = (int) res;
        System.out.println(result);

        if (s.contains("-")) {
            result *= -1;
            System.out.println(result);
            numChar = "-";
        } else {
            numChar = "+";
        }



        if (result + 1 >= Integer.MAX_VALUE) {
            resultInt = Integer.MAX_VALUE;
            minMax = true;
        } else if (result - 1 <= Integer.MIN_VALUE) {
            resultInt = Integer.MIN_VALUE;
            minMax = true;
        } else {
            resultInt = (int) result;
            System.out.println(resultInt + " else");
        }

        String trimString = s.trim();
        if (trimString.startsWith(String.valueOf(resultInt)) || minMax || trimString.startsWith(numChar + Math.abs(resultInt))) {
            return resultInt;
        } else {
            return 0;
        }
    }

    public int myAtoi2(String str) {
        int index = 0;
        int sign = 1;
        int total = 0;

        if(str.length() == 0) return 0;

        while(str.charAt(index) == ' ' && index < str.length() -1)
            index ++;

        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    public int myAtoi3(String s) {
        int num = 0;
        int start = 0;
        boolean isNegative = false;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        if (start < s.length() && s.charAt(start) == '-') {
            isNegative = true;
            start++;
        } else if (start < s.length() && s.charAt(start) == '+') {
            start++;
        }

        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            int digit = s.charAt(start++) - '0';
            if ((long)num * 10 + digit > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
        }

        return isNegative ? -num : num;
    }

}
