class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) != null && map.get(chars[i]) >= left) {
                left = map.get(chars[i]) + 1;
            }
            map.put(chars[i], i);

            if (i - left + 1 > result) {
                result = i - left + 1;
            }
        }

        return result;
    }
}
