class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        if (n == 1) {
            return 0;
        }
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + stones[i - 1];
        }
        long runningBest = pre[n];
        long answer = runningBest;
        for (int i = n-1; i >= 1; i--){
            long dpi = runningBest;
            answer = dpi;
            long gi = pre[i] - dpi;
            runningBest = Math.max(runningBest, gi);

        }
        return (int) answer;
    }
}
