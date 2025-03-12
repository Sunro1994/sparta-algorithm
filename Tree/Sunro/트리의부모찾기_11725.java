package Sunro;

import java.util.ArrayList;
import java.util.Scanner;

public class 트리의부모찾기_11725 {
    static Scanner sc= new Scanner(System.in);
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    static void input() {
        N = sc.nextInt();
        adj =  new ArrayList[N+1];
        parent = new int[N+1];
        for (int i =1; i <=N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {  // N-1번 실행해야 함
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // dfs(x,par) := 정점 x의 부모가 par였고, x의 children을 찾아주는 정수
    static void dfs(int x, int par) {
        for(int y : adj[x]){
            if(y == par) continue;
            parent[y]  = x;
            dfs(y, x);
        }
    }

    static void pro() {
        // 1번 정점이 Root이므로 여기서 시작해서 트리 구조 파악
        dfs(1, -1);
        //정답 출력
        for(int i = 2; i <=N; i++){
            System.out.println(parent[i]);
        }
    }

    public static void main(String[] args){
        input();
        pro();
    }

}
