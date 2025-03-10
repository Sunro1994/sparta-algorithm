package Sunro;

import java.io.*;
import java.util.*;

public class 트리와쿼리_15681 {

    static int N, ROOT, QUERY;
    static ArrayList<Integer>[] tree;
    static int[] subtreeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ROOT = Integer.parseInt(st.nextToken());
        QUERY = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        subtreeSize = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 입력 받기
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        // 서브트리 크기 계산 (DFS)
        dfs(ROOT, -1);

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < QUERY; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[query]).append("\n");
        }
        System.out.print(sb);
    }

    // 서브트리 크기 계산 DFS
    private static int dfs(int node, int parent) {
        subtreeSize[node] = 1; // 자기 자신 포함
        for (int child : tree[node]) {
            if (child != parent) { // 부모 노드로 돌아가지 않음
                subtreeSize[node] += dfs(child, node);
            }
        }
        return subtreeSize[node];
    }
}