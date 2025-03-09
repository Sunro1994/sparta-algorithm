import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15681_트리와쿼리 {
    static ArrayList<Integer>[] tree;
    static int[] subtree;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int r = Integer.parseInt(st.nextToken()); // 루트의 번호
        int q = Integer.parseInt(st.nextToken()); // 쿼리의 수

        tree = new ArrayList[n+1];
        subtree = new int[n+1];
        for (int i=1; i<n+1; i++){
            tree[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++){
            String[] nodes = br.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);

            tree[u].add(v);
            tree[v].add(u);
        }
        dfs(r, -1);
        for (int i=0; i<q; i++){
            int sub = Integer.parseInt(br.readLine());
            sb.append(subtree[sub]).append('\n');
        }
        System.out.println(sb);
    }

    // ✅ 메모리 초과 개선 : 부모 찾기 & 매번 서브트리 계산 -> 서브트리 크기 미리 계산
    private static int dfs(int node, int parent){
        subtree[node] = 1;

        for (int child: tree[node]){
            if (child != parent) { // 부모 제외
                subtree[node] += dfs(child, node);
            }
        }
        return subtree[node];
    }
}
