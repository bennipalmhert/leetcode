class Solution {
    public int missingMultiple(int[] nums, int k) {
        int smallest = k;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == smallest) {
                smallest += k;
            }
        }
        return smallest;
    }
}
