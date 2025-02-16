import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 불_5427 { // BOJ_5427_불

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static ArrayDeque<int[]> sangQ;
    static ArrayDeque<int[]> fireQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc =0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 지도 너비 c
            int h = Integer.parseInt(st.nextToken()); // 지도 높이 r

            map = new char[h][w];
            visited = new boolean[h][w];

            sangQ = new ArrayDeque<>();
            fireQ = new ArrayDeque<>();

            for (int i = 0; i < h; i++){
                String str = br.readLine();
                for (int j = 0; j < w; j++){
                    char ch = str.charAt(j);
                    if (ch == '@'){
                        sangQ.add(new int[] {i, j, 1});
                    }
                    if (ch == '*'){
                        fireQ.add(new int[] {i, j});
                    }
                    map[i][j] = ch;
                }
            } // map end

            bfs(h, w);
        }
    }

    private static void bfs(int h, int w){
        while (!sangQ.isEmpty()){
            int firesize = fireQ.size();
            int sangsize = sangQ.size();
            for (int i = 0; i < firesize; i++){
                int[] fire = fireQ.poll();

                for (int d = 0; d < 4; d++){
                    int nr = fire[0] + dr[d];
                    int nc = fire[1] + dc[d];

                    if (nr < 0 || nc < 0 || nr >= h || nc >= w || map[nr][nc] == '#' || map[nr][nc] == '*') continue;

                    fireQ.add(new int[] {nr, nc});
                    map[nr][nc] = '*';
                }
            }

            for (int i = 0; i < sangsize; i++){
                int[] sang = sangQ.poll();
                int cr = sang[0];
                int cc = sang[1];
                if (cr == 0 || cc == 0 || cr == h-1 || cc == w-1) { // 출구 판별
                    System.out.println(sang[2]);
                    return;
                }
                for (int d = 0; d < 4; d++){
                    int nr = sang[0] + dr[d];
                    int nc = sang[1] + dc[d];

                    if (nr < 0 || nc < 0 || nr >= h || nc >= w || map[nr][nc] != '.' || visited[nr][nc]) continue;
                    sangQ.add(new int[] {nr, nc, sang[2]+1});
                    visited[nr][nc] = true;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}