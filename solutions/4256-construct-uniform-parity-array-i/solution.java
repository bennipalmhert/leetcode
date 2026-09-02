class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean result = false;
        int[] nums2 = new int[nums1.length];
        boolean even = false;
        boolean uneven = false;
        if (nums1[0] % 2 == 0) {
            even = true;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (even == true) {
                if (nums1[i] % 2 == 0) {
                    nums2[i] = nums1[i];
                } else {
                    uneven = true;
                    break;
                }
            } else {
                if (nums1[i] % 2 != 0) {
                    nums2[i] = nums1[i];
                } else {
                    uneven = true;
                    break;
                }
            }
        }
        if (uneven == true) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] % 2 == 0) {
                    for (int k = 0; k < nums1.length; k++) {
                        int value = nums1[j] - nums1[k];
                        if (value % 2 != 0) {
                            nums2[j] = value;
                        }
                    }
                    if (nums2[j] == 0) {
                        return result;
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
