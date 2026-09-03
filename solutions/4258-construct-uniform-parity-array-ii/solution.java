class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean result = false;
        int[] nums2 = new int[nums1.length];
        boolean even = false;
        boolean uneven = false;
        int minOdd = Integer.MAX_VALUE;
        if (nums1[0] % 2 == 0) {
            even = true;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (even == true) {
                if (nums1[i] % 2 == 0) {
                    nums2[i] = nums1[i];
                } else {
                    uneven = true;
                }
            } else {
                if (nums1[i] % 2 != 0) {
                    nums2[i] = nums1[i];
                } else {
                    uneven = true;
                }
            }
            if (nums1[i] % 2 != 0 && nums1[i] < minOdd) {
                minOdd = nums1[i];
            }
        }
        if (uneven == true) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] % 2 == 0) {
                    int value = nums1[j] - minOdd;
                    if (value >= 1) {
                        nums2[j] = value;
                    } else {
                        return false;
                    }
                } else {
                    nums2[j] = nums1[j];
                }
            } 
        }
        result = true;
        return result;
    }
}
