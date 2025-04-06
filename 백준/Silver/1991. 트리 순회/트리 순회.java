import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static class Node {
        char me;
        Node left;
        Node right;

        Node(char me, Node left, Node right) {
            this.me = me;
            this.left = left;
            this.right = right;
        }
    }

    static Node head = new Node('A', null, null);

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            insert(head, a ,l, r);

        }

        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);

        System.out.println(sb);
    }

    public static void insert(Node cur, char a, char l, char r) {
        if (cur.me == a) {
            cur.left = (l == '.' ? null : new Node(l, null, null));
            cur.right = (r == '.' ? null : new Node(r, null, null));
        } else {
            if (cur.left != null) {
                insert(cur.left, a, l, r);
            }
            if (cur.right != null) {
                insert(cur.right, a, l, r);
            }
        }

    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.me);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        sb.append(node.me);
        inOrder(node.right);
    }
    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.me);
    }
}

