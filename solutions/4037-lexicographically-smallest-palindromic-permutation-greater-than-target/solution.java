class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int oddCount = 0;
        for (int x : count) {
            if (x % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount > 1) {
            return "";
        }

        int[] half = new int[26];
        int midLetter = -1;
        int x = 0;
        while (x < count.length) {
            half[x] = count[x] / 2;
            if (count[x] % 2 != 0) {
                midLetter = x;
            }
            x++;
        }

        char[] result = new char[n];
        int i = 0;
        int h = n / 2;
        int lastSwapPos = -1;

        while (i < h) {
            int targetLetter = target.charAt(i) - 'a';
            boolean hasGreater = false;
            for (int k = targetLetter + 1; k < 26; k++) {
                if (half[k] != 0) {
                    hasGreater = true;
                    break;
                }
            }
            if (hasGreater) {
                lastSwapPos = i;
            }
            if (half[targetLetter] != 0) {
                result[i] = target.charAt(i);
                half[targetLetter]--;
                i++;
            } else {
                break;
            }
        }
        if (i == h) {
            if (midLetter != -1) {
                result[h] = (char) (midLetter + 'a');
            }
            for (int k = h; k < n; k++) {
                result[k] = result[(n - k) - 1];
            }
            String candidate = new String(result);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }
        if (lastSwapPos == -1) {
            return "";
        }
        for (int j = lastSwapPos; j < i; j++) {
            half[result[j] - 'a']++;
        }

        int targetIdx = target.charAt(lastSwapPos) - 'a';
        int swapLetter = -1;
        for (int c = targetIdx + 1; c < 26; c++) {
            if (half[c] != 0) {
                swapLetter = c;
                break;
            }
        }
        result[lastSwapPos] = (char) ('a' + swapLetter);
        half[swapLetter]--;

        int pos = lastSwapPos + 1;
        for (int c = 0; c < 26; c++) {
            while (half[c] > 0) {
                result[pos] = (char) (c + 'a');
                pos++;
                half[c]--;
            }
        }

        if (midLetter != -1) {
            result[h] = (char) (midLetter + 'a');
        }
        for (int k = h; k < n; k++) {
            result[k] = result[(n - k) - 1];
        }

        return new String(result);
    }
}
