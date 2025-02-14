import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 유기농배추_1012 { //BOJ_1012_유기농배추

    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //tc

        StringTokenizer st;
        for (int tc=1; tc<T+1; tc++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로 , 열 c
            n = Integer.parseInt(st.nextToken()); // 세로 ,행 r
            int k = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치의 개수

            map = new int[n][m];
            visit = new boolean[n][m];

            for (int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                map[r][c] = 1;
            }

            int cnt = 0;
            for (int i=0;i<n;i++){
                for (int j=0; j<m; j++){
                    if(map[i][j] == 1 & !visit[i][j]){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        } // tc end
    }

    private static void bfs(int r, int c){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {r, c});
        visit[r][c] = true;

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
        }
    }
}