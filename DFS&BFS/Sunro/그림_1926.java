package Sunro;

import java.io.*;
import java.util.*;

/*
그림 없을때는 카운트와 넓이 모두 0출력
BFS로 구현하기 - queue
 */
public class 그림_1926 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int N,M; //<=500
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count=0;
        int maxCount =0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    maxCount= Math.max(BFS(i,j),maxCount);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxCount);

    }

    private static int BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        int cnt =1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = poll[0] + dx[k];
                int y = poll[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M && !visited[x][y] && map[x][y]==1) {
                    queue.add(new int[]{x,y});
                    visited[x][y] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
