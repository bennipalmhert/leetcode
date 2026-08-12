class Solution {
    public int missingInteger(int[] nums) {
        // actually missing values that can be returned
        int missing = 0;
        // longest length
        int longestSeq = 0;
        // values we have already seen in nums
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int sum = nums[0];
        int i = 1;
        while (i < nums.length && nums[i] == nums[i-1] + 1){
            sum += nums[i];
            i++;
        }

        while (seen.contains(sum)) {
            sum ++;
        }
        missing = sum;
        return missing;
    }
}
