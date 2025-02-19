package Sunro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
    static int map_row;
    static int map_col;
    static boolean[][] visited;
    static int[][] distance;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map_row = Integer.parseInt(st.nextToken());
        map_col = Integer.parseInt(st.nextToken());
        visited = new boolean[map_row][map_col];
        distance = new int[map_row][map_col];
        map = new int[map_row][map_col];
        for (int i = 0; i < map_row; i++) {
            st = new StringTokenizer(br.readLine());
            String target= st.nextToken();
            for (int j = 0; j < map_col; j++) {
                map[i][j] = Integer.parseInt(target.substring(j,j+1));
            }
        }

        BFS(0,0);

        System.out.println(distance[map_row-1][map_col-1]);
    }

    private static void BFS(int i, int j) {
        Queue<Integer[]>  queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new Integer[]{i,j});
        distance[i][j] = 1;
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dx[k];
                int ny = poll[1] + dy[k];
                if(nx>=0 && ny >=0 && nx<map_row && ny<map_col && !visited[nx][ny] && map[nx][ny]==1){
                    visited[nx][ny] = true;
                    queue.add(new Integer[]{nx,ny});
                    distance[nx][ny]=distance[poll[0]][poll[1]]+1;
                }
            }
        }
    }
}
