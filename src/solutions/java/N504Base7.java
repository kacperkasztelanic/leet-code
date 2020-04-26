package solutions.java;

public class N504Base7 {

    public String convertToBase7(int num) {
        int radix = 7;
        StringBuilder result = new StringBuilder();
        int numCopy = num;
        while (numCopy != 0) {
            result.append(Math.abs(numCopy % radix));
            numCopy /= radix;
        }
        if (num == 0) {
            return "0";
        }
        return ((num < 0) ? "-" : "") + result.reverse().toString();
    }
}
