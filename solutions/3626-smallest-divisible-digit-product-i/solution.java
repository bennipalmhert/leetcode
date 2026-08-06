class Solution {
    public int smallestNumber(int n, int t) {
         while (true) {
            String number = Integer.toString(n);
            int product = 1;
            for (int i = 0; i < number.length(); i++) {
                int digit = number.charAt(i) - '0';
                product *= digit;
            }
            if (product % t == 0) {
                return n;
            }
            n++;
        }
    }
}
