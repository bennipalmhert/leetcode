class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // 1. Build adjacency list: method -> list of methods it invokes
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        // 2. BFS from k to find every method reachable from it (the suspicious set)
        boolean[] suspicious = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        suspicious[k] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    queue.add(next);
                }
            }
        }

        // 3. Validity check: for every edge a -> b, if b is suspicious, a must be too.
        for (int[] edge : invocations) {
            int a = edge[0], b = edge[1];
            if (suspicious[b] && !suspicious[a]) {
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all; // removal not allowed -> return everything
            }
        }

        // 4. Otherwise, collect every method NOT in the suspicious set
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) remaining.add(i);
        }
        return remaining;
    }
}
