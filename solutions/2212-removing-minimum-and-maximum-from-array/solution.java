class Solution {
    public int minimumDeletions(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int minPos = 0;
        int maxPos = 0;
        int half = nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minPos = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }
        int k = Math.min(minPos, maxPos);
        int j = Math.max(minPos, maxPos);
        int n = nums.length;
        int delete = Math.min(j + 1, Math.min(n - k, (k + 1) + (n - j)));
        return delete;
    }
}
