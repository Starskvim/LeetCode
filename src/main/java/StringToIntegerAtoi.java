
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

}
