class Solution {
    public String longestCommonPrefix(String[] strs) {
        char current = 0;
        StringBuilder sb = new StringBuilder();
        boolean correct = false;
        for (int i = 0; i < strs[0].length(); i++) {
            current = strs[0].charAt(i);
            for (String word : strs) {
                if (i < word.length() && word.charAt(i) == current) {
                    correct = true;
                } else {
                    correct = false;
                    break;
                }
            }
            if (correct) {
                sb.append(current);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
