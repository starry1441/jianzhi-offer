package work3_23;

import work3_7.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * User: starry
 * Date: 2021 -03 -23
 * Time: 16:24
 */
public class Work2 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        while(k > 1) {
            fast = fast.next;
            k--;
        }
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
