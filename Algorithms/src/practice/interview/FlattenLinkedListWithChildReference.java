package practice.interview;

import java.util.Stack;

public class FlattenLinkedListWithChildReference {
    public Node flat(Node n) {
        Node cur = n;
        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) stack.push(cur.next);
                cur.next = cur.child;
                cur.child = null;
            } else {
                if (cur.next == null) {
                    if (!stack.isEmpty()) cur.next = stack.pop();
                }
            }
            cur = cur.next;
        }
        return n;
    }



    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n111 = new Node(111);
        Node n112 = new Node(112);
        Node n51 = new Node(51);
        Node n52 = new Node(52);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n1.child = n11;n11.next=n12;//n12.next=n3;
        n11.child=n111;
        n111.next=n112;
        n5.child=n51;n51.next=n52;
        FlattenLinkedListWithChildReference f = new FlattenLinkedListWithChildReference();
        f.flat(n1);
    }
}

class Node {
    int val;
    Node next;
    Node child;
    public Node(int val) {
        this.val = val;
    }
}