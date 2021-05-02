package work5_2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -02
 * Time: 20:08
 */
public class Work3 {
    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public int lastRemaining1(int n, int m) {
        Node head = new Node(0);
        Node cur = head;
        int i = 1;
        while (cur.val < n-1) {
            Node node = new Node(i);
            cur.next = node;
            cur = cur.next;
            i++;
        }
        cur.next = head;
        Node pre = cur;
        cur = head;
        int count = 1;
        while (pre != cur) {
            if(count == m) {
                pre.next = cur.next;
                count = 0;
            }else {
                pre = cur;
            }
            cur = cur.next;
            if(count < m) {
                count++;
            }
        }
        return cur.val;
    }

    public int lastRemaining(int n, int m) {
        boolean[] isUsed = new boolean[n];
        int i = 0;
        int pre = n-1;
        int count = 1;
        int size = 0;
        while (size < n-1) {
            if(count == m) {
                isUsed[i] = true;
                size++;
                count = 0;
            }
            pre = i;
            i++;
            if(i == n) {
                i = 0;
            }
            if(!isUsed[i]) {
                count++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (!isUsed[j]) {
                return j;
            }
        }
        return -1;
    }

    public int lastRemaining3(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Work3 a = new Work3();
        System.out.println(a.lastRemaining(5, 1));
    }
}
