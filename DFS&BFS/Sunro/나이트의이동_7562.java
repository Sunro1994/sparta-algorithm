package Sunro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {
    static int test_case;
    static int map_size;
    static boolean[][] visited;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test_case = Integer.parseInt(br.readLine());

        while (test_case-- > 0) {
            map_size = Integer.parseInt(br.readLine());
            visited = new boolean[map_size][map_size];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            if (startX == endX && startY == endY) {
                System.out.println(0);
                continue;
            }

            System.out.println(BFS(startX, startY, endX, endY));
        }
    }

    private static int BFS(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[map_size][map_size];

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < map_size && ny >= 0 && ny < map_size && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;

                    if (nx == endX && ny == endY) return distance[nx][ny];
                }
            }
        }
        return -1;
    }
}