class Solution {
    public boolean isPalindrome(int x) {
        int remainder = 0;
        int reversed = 0;
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        } else if (x == 0) {
            return true;
        }
        while (x > reversed) {
            remainder = x % 10;
            reversed = reversed * 10 + remainder;
            x = (x/10);
        }
        return (reversed == x || x == reversed/10);
    }
}
