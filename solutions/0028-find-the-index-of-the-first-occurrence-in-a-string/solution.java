class Solution {
    public int strStr(String haystack, String needle) {
        int window = needle.length();
        int occurence = -1;
        for (int i = 0; i <= haystack.length() - window; i++) {
            int k = 0;
            for (int j = i; j < i + window; j++){
                if (haystack.charAt(j) == needle.charAt(k)) {
                    occurence = i;
                    k++;
                } else {
                    occurence = -1;
                    break;
                }
            }
            if (occurence != -1) {
                return occurence;
            }
        }
        return occurence;
    }
}
