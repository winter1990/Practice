package practice.interview.google;

// 1 3 2, 0 1 3 2, 0 3 2, 0 3
// 1 2, 0 1 2, 0 2
public class RemoveAlternateNodesDoublyLinkedList {
    public Node removeAlternate(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = dummy;
        while (cur.next != null) {
            cur.next = cur.next.next;
            if (cur.next == null) {
                break;
            }
            cur.next.pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    class Node {
        Node pre, next;
        int value;
        public Node(int value) {
            this.value = value;
        }
    }
}
