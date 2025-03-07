import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
    static StringBuilder sb = new StringBuilder();
    static Node[] tree;
    static class Node{
        int left;
        int right;

        Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];

        for (int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            int parent = input[0].charAt(0) - 'A' +1;
            int left = (input[1].charAt(0) == '.') ? -1 : input[1].charAt(0) - 'A' + 1;
            int right = (input[2].charAt(0) == '.') ? -1 : input[2].charAt(0) - 'A' + 1;

            tree[parent] = new Node(left, right);
        }

        preOrder(1);
        sb.append('\n');
        inOrder(1);
        sb.append('\n');
        postOrder(1);
        sb.append('\n');
        System.out.println(sb);
    }

    static void preOrder(int node){ // 전위순회 루트-왼쪽-오른쪽
        if (node == -1) return;
        sb.append((char)(node + 'A' - 1));
        preOrder(tree[node].left);
        preOrder(tree[node].right);
    }

    static void inOrder(int node){ // 중위순회 왼쪽-루트-오른쪽
        if (node == -1) return;
        inOrder(tree[node].left);
        sb.append((char)(node + 'A' -1));
        inOrder(tree[node].right);
    }

    static void postOrder(int node){ // 후위순회 왼쪽-오른쪽-루트
        if (node == -1) return;
        postOrder(tree[node].left);
        postOrder(tree[node].right);
        sb.append((char)(node + 'A' - 1));
    }
}
