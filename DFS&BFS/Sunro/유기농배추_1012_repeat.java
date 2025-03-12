package Sunro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추_1012_repeat {
    static int testCount;
    static int[][] map;
    static int raw, col, cnt;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCount = Integer.parseInt(br.readLine());
        while(testCount-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            raw = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());

            map = new int[raw+1][col+1];
            visited = new boolean[raw+1][col+1];

            for (int i = 0; i < cnt; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st1.nextToken());
                int y = Integer.parseInt(st1.nextToken());
                map[x][y] = 1;
            }

            int count =0;
            for (int i = 0; i < raw; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        countNeedWarm(i,j);
                        count++;
                    }
                }

            }
            System.out.println(count);
        }
    }

    private static void countNeedWarm(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if(nx>=0 && ny>=0 && nx<raw && ny<col&& map[nx][ny]==1 && !visited[nx][ny]){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
