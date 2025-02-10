package Sunro;

import java.util.*;
import java.io.*;


public class 유기농배추_1012 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int R, C, N, M; //R = 반복수  , C = 몇 개 심어져있는지, N,M 지도
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());



//        시간복잡도 R * NM
        while (R-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N+1][M+1];
            visited = new boolean[N+1][M+1];

            for (int i = 0; i < C; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            int count =0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j]==1 && !visited[i][j]){
                        BFS(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny] == 1){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
