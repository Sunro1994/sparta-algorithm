package Sunro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    char data;//노드 값
    Node left;
    Node right;

    public Node(char data){
        this.data = data;
    }
}

public class 트리_순회_1991 {
    static Node[] tree;

    public static void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }
    public static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (tree[parentValue - 'A'] == null) {
                tree[parentValue - 'A'] = new Node(parentValue);
            }
            if (leftValue != '.') {
                tree[leftValue-'A'] = new Node(leftValue);
                tree[parentValue-'A'].left = tree[leftValue-'A'];
            }
            if (rightValue != '.') {
                tree[rightValue-'A'] = new Node(rightValue);
                tree[parentValue-'A'].right = tree[rightValue-'A'];
            }
        }
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
        System.out.println();
    }
}
