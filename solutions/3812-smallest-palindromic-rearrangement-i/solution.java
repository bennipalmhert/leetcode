class Solution {
    public String smallestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        char middle = '\0';
        boolean hasMiddle = false;

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (count[i] % 2 == 1) {
                // odd count -> this is the middle char (only one such char can exist)
                middle = c;
                hasMiddle = true;
            }
            for (int j = 0; j < count[i] / 2; j++) {
                half.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(half);
        if (hasMiddle) {
            result.append(middle);
        }
        result.append(half.reverse());

        return result.toString();
    }
}
