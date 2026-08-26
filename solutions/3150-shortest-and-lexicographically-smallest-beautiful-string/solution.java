class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }
        if (ones.size() < k) {
            return "";
        }
        String result = null;
        for (int j = 0; j <= ones.size() - k; j++) {
            int start = ones.get(j);
            int end = ones.get(j + k - 1);
            String candidate = s.substring(start, end+1);
            if (result == null || candidate.length() < result.length() || candidate.length() == result.length() && candidate.compareTo(result) < 0) {
                result = candidate;
            }
        }
        return result;
    }
}
