class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> contains = new HashSet<>();
        ArrayList<Integer> missing = new ArrayList<>();
        int min = nums[0], max = nums[0];
        for (int number : nums) {
            contains.add(number);
            if (number < min) min = number;
            if (number > max) max = number;
        }
        for (int i = min; i < max; i++) {
            if (!(contains.contains(i))) {
                missing.add(i);
            } 
        }
        return missing;
    }
}
