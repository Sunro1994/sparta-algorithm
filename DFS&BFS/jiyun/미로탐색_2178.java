import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미로탐색_2178 { // BOJ_2178_미로탐색

    static char[][] miro;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        miro = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = str.charAt(j);
            }
        }

        // 1은 이동 가능, 0은 이동 불가능
        bfs(n, m);
    }

    private static void bfs(int n, int m){
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // (0,0)에서 시작 도착은 (n-1,m-1)
        q.offer(new int[] {0, 0, 1}); // r, c, 칸 수
        visit[0][0] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();

            if (cur[0] == n-1 && cur[1] == m-1){
                System.out.println(cur[2]);
                return;
            }

            for (int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (visit[nr][nc] || miro[nr][nc] == '0') continue;
                q.offer(new int[] {nr, nc, cur[2]+1});
                visit[nr][nc] = true; // 방문 처리 위치

            }
        }
    }
}