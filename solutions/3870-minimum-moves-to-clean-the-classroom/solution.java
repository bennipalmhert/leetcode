class Solution {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    public int minMoves(String[] classroom, int energy) {
        int startX = 0;
        int startY = 0;
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] id = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = 1 << count; 
                    count++;
                }
            }
        }
        int full = 1 << count;
        int[][][] bestEnergy = new int[m][n][full];
        
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                Arrays.fill(bestEnergy[k][l], -1);
            }
        }
        bestEnergy[startX][startY][0] = energy;

        class Info {
            int x, y, mask, e, steps;
            Info(int x, int y, int mask, int e, int steps) {
                this.x = x;
                this.y = y;
                this.mask = mask;
                this.e = e;
                this.steps = steps;
            }
        }
        Deque<Info> q = new ArrayDeque<>();
        q.addLast(new Info (startX, startY, 0, energy, 0));
        while (!q.isEmpty()) {
            Info state = q.removeFirst();
            if (state.mask == full - 1){
                return state.steps;
            }
            if (state.e == 0) {
                continue;
            }
            for (int d = 0; d < 4; d ++) {
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];
                if (nx >= m || nx < 0 || ny >= n || ny < 0 || classroom[nx].charAt(ny) == 'X') {
                    continue;
                }
                int ne = -1;
                if (classroom[nx].charAt(ny) == 'R') {
                    ne = energy;
                } else {
                    ne = state.e - 1;
                }
                int nmask = state.mask | id[nx][ny];
                if (ne > bestEnergy[nx][ny][nmask]) {
                    bestEnergy[nx][ny][nmask] = ne;
                    q.addLast(new Info(nx, ny, nmask, ne, state.steps + 1));
                }
            }
        }
        return -1;
    }
}
