import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 그림_1926 { // BOJ_1926_그림

    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map  =  new int[n][m];
        visit  =  new boolean[n][m];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0, max = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(map[i][j] == 1 && !visit[i][j]){
                    int res = bfs(i, j);
                    cnt++;
                    max = Math.max(max, res);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    private static int bfs(int r, int c){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {r, c});
        visit[r][c] = true;

        int cnt = 0;
        while (!que.isEmpty()){
            int[] cur = que.pop();
            int cr = cur[0];
            int cc = cur[1];

            for (int d=0; d<4; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == 1 & !visit[nr][nc]){
                    que.offer(new int[] {nr, nc});
                    visit[nr][nc] = true;
                }
            }
            cnt++;
        }
        return cnt;
    }
}