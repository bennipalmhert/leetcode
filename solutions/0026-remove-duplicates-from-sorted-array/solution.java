class Solution {
    public int removeDuplicates(int[] nums) {
        int end = nums.length;
        int k = 1;
        for (int i = 0; i < end; i++) {
            if (k < end && nums[i] != nums[k-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
