package Sunro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리_1068 {
    static int N, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());
        child = new ArrayList[N];
        leaf = new int[N];
        for (int i = 0; i < N; i++) child[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            child[parent].add(i);
        }
        erased = Integer.parseInt(br.readLine());
    }
    public static void dfs(int  x){
        if (child[x].isEmpty()) {
            leaf[x] = 1;
        }
        for(int y: child[x]){
           dfs(y);
           leaf[x] += leaf[y];
            //leaf[y]가 계산된 상태
        }
    }


    static void pro(){
        //삭제되는 정점 처리
        for (int i = 0; i < N; i++){
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }
        if(root != erased) dfs(root);
        System.out.println(leaf[root]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }


}
