import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1068_트리 {
    static ArrayList<Integer>[] tree;
    static int[] children;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        children = new int[n];
        parent = new int[n];
        tree = new ArrayList[n];

        for (int i=0; i<n;i++){
            tree[i] = new ArrayList<>();
        }

        String[] str = br.readLine().split(" ");
        for (int i=0; i<n; i++){
            int p = Integer.parseInt(str[i]);
            if (p == -1) continue;
            children[p]++;
            parent[i] = p; // 부모 노드 기록
            tree[p].add(i); // 부모 노드에 자식 추가
        }

        int remove = Integer.parseInt(br.readLine());
        children[parent[remove]]--;
        remove(remove);
        int cnt = 0;
        for (int c:children){ // 리프노드 구하기
            if (c == 0) cnt++;
        }
        System.out.println(cnt);
    }

    private static void remove(int remove){
        children[remove] = -1;
        for (int child : tree[remove]){
            remove(child);
        }
    }
}
