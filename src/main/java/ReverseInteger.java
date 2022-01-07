import java.util.Arrays;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse3(-5369));

    }

    public static int reverse(int x) {


        if(x >= 0){
            StringBuilder stringBuilder = new StringBuilder(x + "").reverse();

            int result = Long.parseLong(stringBuilder.toString()) > Integer.MAX_VALUE ? 0 : Integer.parseInt(stringBuilder.toString());

            return result;
        } else {
            StringBuilder stringBuilder = new StringBuilder((x + "").substring(1)).reverse();

            int result = Long.parseLong(stringBuilder.toString()) / -1 < Integer.MAX_VALUE ? 0 : Integer.parseInt(stringBuilder.toString())/-1;

            return result;
        }


    }

    public static int reverse2(int x) {
        if (x >= 0) {
            StringBuilder stringBuilder = new StringBuilder(x + "").reverse();
            return Long.parseLong(stringBuilder.toString()) > Integer.MAX_VALUE ? 0 : Integer.parseInt(stringBuilder.toString());
        } else {
            StringBuilder stringBuilder = new StringBuilder((x + "").substring(1)).reverse();
            return Long.parseLong(stringBuilder.toString())/-1 < Integer.MIN_VALUE ? 0 : Integer.parseInt(stringBuilder.toString())/-1;
        }
    }

    public static int reverse3(int x) {
        int rev=0;
        while(x!=0){
            int carry= x %10;

            System.out.println(carry);

            x/=10;

            if(rev>Integer.MAX_VALUE/10)
                return 0;
            if(rev<Integer.MIN_VALUE/10)
                return 0;
            rev=rev*10+carry;

        }


        return rev;
    }
}
