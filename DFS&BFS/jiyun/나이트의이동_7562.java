import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나이트의이동_7562 { // BOJ_7562_나이트의 이동

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc =0; tc<t; tc++){
            int n = Integer.parseInt(br.readLine()); // 한 변의 길이


            // 현재 칸
            st = new StringTokenizer(br.readLine());
            int cr = Integer.parseInt(st.nextToken());
            int cc = Integer.parseInt(st.nextToken());

            // 이동하려는 칸
            st = new StringTokenizer(br.readLine());
            int ar = Integer.parseInt(st.nextToken());
            int ac = Integer.parseInt(st.nextToken());

            bfs(cr, cc, ar, ac, n);
        } // tc end
    }

    private static void bfs(int cr, int cc, int ar, int ac, int n){
        boolean[][] visited = new boolean[n][n];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {cr, cc, 0}); // r, c, 이동 횟수
        visited[cr][cc] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();

            if (cur[0] == ar && cur[1] == ac){
                System.out.println(cur[2]);
                return;
            }

            for (int d=0; d<8; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]) continue;
                q.add(new int[] {nr, nc, cur[2]+1});
                visited[nr][nc] = true;
            }

        }

    }
}