package practice.leetcode.medium;

import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) stack.push(cur.next);
                cur.next = cur.child;
                cur.child = null;
            } else {
                if (cur.next == null && !stack.isEmpty()) {
                    cur.next = stack.pop();
                }
            }
            if (cur.next != null) cur.next.prev = cur;
            cur = cur.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten1(Node head) {
        if (head == null) return null;
        flattenList(head);
        return head;
    }

    private Node flattenList(Node node) {
        if (node.child != null) {
            Node tail = flattenList(node.child);
            tail.next = node.next;
            if (node.next != null) node.next.prev = tail;
            node.next = node.child;
            node.child = null;
            node.next.prev = node;
            if (tail.next == null) return tail;
            return flattenList(tail.next);
        }
        if (node.next == null) return node;
        return flattenList(node.next);
    }

    Node pre = null;
    public Node flatten2(Node head) {
        if (head == null) {
            return null;
        }
        if (pre != null) {
            pre.next = head;
            head.prev = pre;
        }
        pre = head;
        Node next = head.next;
        flatten2(head.child);
        head.child = null;
        flatten2(next);
        return head;
    }
}
