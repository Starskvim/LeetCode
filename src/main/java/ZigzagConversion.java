public class ZigzagConversion {

    public static void main(String[] args) {

        String s1 = "helloWorldIamSmallCatInBigWorld";
        String s2 = "PAYPALISHIRING";

        System.out.println(convert(s2, 3));

    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= numRows; i++) {
            int ind = i - 1;
            boolean up = true;
            while (ind < s.length()) {
                builder.append(s.charAt(ind));
                if (i == 1) {
                    ind += 2 * (numRows - i);
                } else if (i == numRows) {
                    ind += 2 * (i - 1);
                } else {
                    ind += up ? 2 * (numRows - i) : 2 * (i - 1);
                    up = !up;
                }
            }
        }
        return builder.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows == 1) return s;
        int x = 2 * (numRows - 1);
        int len = s.length();
        char[] c = new char[len];
        int k = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j = j + x) {
                c[k++] = s.charAt(j);
                if (i > 0 && i < numRows - 1 && j + x - 2 * i < len) {
                    c[k++] = s.charAt(j + x - 2 * i);
                }
            }
        }
        return new String(c);
    }

}
