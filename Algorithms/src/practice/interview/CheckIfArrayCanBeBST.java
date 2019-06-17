package practice.interview;

import java.util.Stack;

/**
 * prop
 * all left smaller than root
 * all right larger than root
 *
 * 5 2 4 3
 */
public class CheckIfArrayCanBeBST {
    public static void main(String[] args) {
        int[] in = {5,3,1,2,6,8,7,9};
        CheckIfArrayCanBeBST c = new CheckIfArrayCanBeBST();
        System.out.println(c.isValidBST(in));
    }

    public boolean isValidBST(int[] pre) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE, n = pre.length;
        for (int i = 0; i < n; i++) {
            if (pre[i] < root) {
                return false;
            }
            while (!stack.empty() && stack.peek() < pre[i]) {
                root = stack.peek();
                stack.pop();
            }
            stack.push(pre[i]);
        }
        return true;
    }

//        public static void main(String args[]) {
//            BinarySearchTree bst = new BinarySearchTree();
//            int[] pre1 = new int[]{40, 30, 35, 80, 100};
//            int n = pre1.length;
//            if (bst.canRepresentBST(pre1, n) == true) {
//                System.out.println("true");
//            } else {
//                System.out.println("false");
//            }
//            int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
//            int n1 = pre2.length;
//            if (bst.canRepresentBST(pre2, n) == true) {
//                System.out.println("true");
//            } else {
//                System.out.println("false");
//            }
//        }
}
