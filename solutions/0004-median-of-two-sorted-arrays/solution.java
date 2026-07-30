class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] shorter;
        int[] longer;
        if (nums1.length <= nums2.length) {
            shorter = nums1;
            longer = nums2;
        } else {
            shorter = nums2;
            longer = nums1;
        }

        int totalLength = shorter.length + longer.length;
        int partition = (totalLength + 1) / 2;

        int l = 0;
        int r = shorter.length;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = partition - i;

            int shortLeft  = (i == 0) ? Integer.MIN_VALUE : shorter[i - 1];
            int shortRight = (i == shorter.length) ? Integer.MAX_VALUE : shorter[i];
            int longLeft   = (j == 0) ? Integer.MIN_VALUE : longer[j - 1];
            int longRight  = (j == longer.length) ? Integer.MAX_VALUE : longer[j];

            if (shortLeft <= longRight && longLeft <= shortRight) {
                // valid partition found
                if (totalLength % 2 == 1) {
                    return Math.max(shortLeft, longLeft);
                } else {
                    int leftMax = Math.max(shortLeft, longLeft);
                    int rightMin = Math.min(shortRight, longRight);
                    return (leftMax + rightMin) / 2.0;
                }
            } else if (shortLeft > longRight) {
                // i too big, shrink it
                r = i - 1;
            } else {
                // longLeft > shortRight, i too small, grow it
                l = i + 1;
            }
        }

        // should never reach here given valid sorted input
        throw new IllegalArgumentException("Input arrays are not sorted or invalid");
    }
}
