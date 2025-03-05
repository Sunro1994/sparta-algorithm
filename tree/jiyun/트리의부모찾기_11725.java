import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        visited = new boolean[n+1];

        tree = new ArrayList[n+1];

        for (int i=0; i<n+1; i++){ // arrayList 초기화
            tree[i] = new ArrayList<>();
        }

        for (int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        // 루트 노트 : 1
        dfs(1, 0);
        for (int i=2; i<n+1; i++){
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int node, int parent){
        parents[node] = parent;
        visited[node] = true;

        for (int child : tree[node]){
            if (visited[child]) continue;
            dfs(child, node);
        }
    }
}
