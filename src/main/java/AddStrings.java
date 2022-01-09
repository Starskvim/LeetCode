public class AddStrings {
    public static void main(String[] args) {

        System.out.println(addStrings("11", "123"));

    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int k = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || k >= 0){
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            i--;
            int n2 = k < 0 ? 0 : num2.charAt(k) - '0';
            k--;
            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum > 9 ? 1 : 0;
        }
        if(carry > 0)
            sb.append(1);
        return sb.reverse().toString();
    }
}
