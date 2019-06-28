package practice.interview.google;

import java.util.LinkedList;
import java.util.Queue;

public class DrawHTree {
    public void drawHTree(double x) {
        int level = 0;
        double len = x;
        double cur = 0;
        while (cur < x / 2) {
            len = Math.sqrt(len) / 2;
            cur += len;
            level++;
        }
        level--;
        Queue<HNode> q = new LinkedList<>();
        HNode root = new HNode(x, 0, 0);
        root.x = 0;
        root.y = 0;
        q.offer(root);
        draw(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                HNode node = q.poll();
                double v = node.v;
                double r = node.x;
                double c = node.y;
                HNode tl = new HNode(Math.sqrt(v), r - v / 2, c + v / 2);
                HNode tr = new HNode(Math.sqrt(v), r + v / 2, c + v / 2);
                HNode bl = new HNode(Math.sqrt(v), r - v / 2, c - v / 2);
                HNode br = new HNode(Math.sqrt(v), r + v / 2, c - v / 2);
                node.tl = tl;
                node.tr = tr;
                node.bl = bl;
                node.br = br;
                q.offer(tl);
                q.offer(tr);
                q.offer(bl);
                q.offer(br);
                draw(tl);
                draw(tr);
                draw(bl);
                draw(br);
            }
            if (--level == 0) break;
        }
    }

    private void draw(HNode node) {

    }

    class HNode {
        HNode tl, tr, bl, br;
        double x, y;
        double v;
        public HNode(double v, double x, double y) {
            this.v = v;
            this.x = x;
            this.y = y;
        }
    }
}
