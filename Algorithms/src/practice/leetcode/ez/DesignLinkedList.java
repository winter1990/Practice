package practice.leetcode.ez;

/**
 * @design
 *
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 *
 * addAtHead(val) : Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 *
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 *
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
 * If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 *
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 *
 * we need to define the node, with value and reference for the next node
 *
 *
 */
public class DesignLinkedList {
}

class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (head == null || index >= size || index < 0) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        ListNode node = new ListNode(val);
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode cur = head;
        for (int i = 1; i < index; i++) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = node;
        node.next = next;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            return;
        }
        ListNode cur = head;
        for (int i = 1; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        if (cur.next == null) {
            tail = cur;
        }
        size--;
    }

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(8);
        list.get(1);
        list.addAtTail(81);
        list.deleteAtIndex(2);
        list.addAtHead(26);
        list.deleteAtIndex(2);
        list.get(1);
        list.addAtTail(24);
        list.addAtHead(15);
        list.addAtTail(0);
        list.addAtTail(13);
        list.addAtTail(1);
        list.addAtIndex(6,33);
        list.get(6);



    }
    //"addAtIndex","get","addAtIndex","addAtHead","deleteAtIndex","addAtIndex","addAtHead","addAtIndex","deleteAtIndex","get","addAtTail","deleteAtIndex","deleteAtIndex","addAtTail","addAtTail","addAtIndex","addAtHead","get","get","addAtTail","addAtTail","addAtTail","addAtTail","addAtIndex","addAtIndex","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","addAtHead","deleteAtIndex","addAtHead","get","addAtHead","get","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtTail","deleteAtIndex","get","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtIndex","deleteAtIndex","deleteAtIndex","deleteAtIndex","addAtHead","addAtTail","addAtTail","addAtHead","addAtTail","addAtIndex","deleteAtIndex","deleteAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","get","addAtIndex","get","addAtHead","addAtHead","addAtHead","addAtIndex","addAtIndex","get","addAtHead","get","get","addAtTail","addAtHead","addAtHead","addAtTail","addAtTail","get","addAtTail"]
    // [6,33],      [6],[2,91],[82],[6],[4,11],[3],[7,14],[1],[6],[99],[11],[7],[5],[92],[7,92],[57],[2],[6],[39],[51],[3],[22],[5,26],[9,52],[69],[5,58],[79],[7],[41],[33],[88],[44],[8],[72],[93],[18],[1],[9],[46],[9],[92],[71],[69],[11,54],[27],[83],[12],[20],[19,97],[77],[36],[3],[35],[16,68],[22],[36],[17],[62],[89],[61],[6],[92],[28,69],[23],[28],[7,4],[0],[24],[52],[1],[23,3],[7],[6],[68],[79],[45,90],[41,52],[28],[25],[9],[32],[11],[90],[24],[98],[36],[34],[26]]

}