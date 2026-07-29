import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int lookup = target - nums[i];
            if (numbers.get(lookup) != null) {
                // what two things do you want in result here, and from where?
                return new int[]{numbers.get(lookup), i};
            }
            // when should you .put() the current number into the map, and with what key/value?
            numbers.put(nums[i], i);
        }
        return new int[0];
    }
}
