package Sunro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_5427 {
    static int test_case;
    static int width;
    static int height;
    static char[][] map;
    static boolean[][] visited; //불이 확산되면 visited에 추가하기
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        test_case = Integer.parseInt(st.nextToken());

        while (test_case-- > 0) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            map = new char[height][width]; //지도
            visited = new boolean[height][width]; //불난곳

            Queue<Point> fireQueue = new LinkedList<>(); //불 Queue
            Queue<Point> humaQueue = new LinkedList<>(); //휴먼 Queue

            for (int i = 0; i < height; i++) {
                String line = br.readLine();
                for (int j = 0; j < width; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*') {
                        fireQueue.add(new Point(i, j));
                        visited[i][j] = true; //불난곳 체크
                    } else if (map[i][j] == '@') {
                        humaQueue.add(new Point(i, j));
                        visited[i][j] = true; //사람이 지나간곳도 체크
                    }
                }
            }

            int result = BFS(humaQueue, fireQueue);
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }

    private static int BFS(Queue<Point> humaQueue, Queue<Point> fireQueue) {
        int distance = 0;

        while (!humaQueue.isEmpty()) {
            distance++;

            // 1. 불 먼저 확산
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                Point fireCur = fireQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = fireCur.x + dx[d];
                    int ny = fireCur.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= height || ny >= width) continue; //영역체크
                    if (visited[nx][ny] || map[nx][ny] == '#' || map[nx][ny] == '*') continue; //벽또는 불인지 체크, 한 번 불붙은곳도 visited로 인식?

                    fireQueue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = '*';
                }
            }

            // 2. 사람 이동
            int humanSize = humaQueue.size();
            for (int i = 0; i < humanSize; i++) {
                Point humanCurPoint = humaQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = humanCurPoint.x + dx[d];
                    int ny = humanCurPoint.y + dy[d];

                    // 탈출 성공
                    if (nx < 0 || ny < 0 || nx >= height || ny >= width) { //영역체크
                        return distance;
                    }

                    if (visited[nx][ny] || map[nx][ny] == '#' || map[nx][ny] == '*') continue; // 불난곳, 벽 체크

                    humaQueue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1; // 탈출 불가능
    }
}