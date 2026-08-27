class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        char[] result = new char[n];
        int lastSwapPos = -1;
        int i = 0;

        while (i < n) {
            int targetLetter = target.charAt(i) - 'a';

            boolean hasGreater = false;
            for (int k = targetLetter + 1; k < 26; k++) {
                if (count[k] != 0) {
                    hasGreater = true;
                    break;
                }
            }
            if (hasGreater) {
                lastSwapPos = i;
            }

            if (count[targetLetter] != 0) {
                result[i] = target.charAt(i);
                count[targetLetter]--;
                i++;
            } else {
                break; // i stays at the failure position
            }
        }

        if (lastSwapPos == -1) {
            return "";
        }

        // single, unified undo: releases everything committed from lastSwapPos up to i
        // (i is either the failure position, or n if the loop completed fully)
        for (int j = lastSwapPos; j < i; j++) {
            count[result[j] - 'a']++;
        }

        int targetIdx = target.charAt(lastSwapPos) - 'a';
        int swapLetter = -1;
        for (int c = targetIdx + 1; c < 26; c++) {
            if (count[c] != 0) {
                swapLetter = c;
                break;
            }
        }

        result[lastSwapPos] = (char) ('a' + swapLetter);
        count[swapLetter]--;

        int pos = lastSwapPos + 1;
        for (int c = 0; c < 26; c++) {
            while (count[c] > 0) {
                result[pos] = (char) (c + 'a');
                pos++;
                count[c]--;
            }
        }

        return new String(result);
    }
}
