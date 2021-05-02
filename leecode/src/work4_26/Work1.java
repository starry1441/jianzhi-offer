package work4_26;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -26
 * Time: 9:28
 */
public class Work1 {

    Queue<Integer> queue;
    Deque<Integer> deque;

    public Work1() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while(!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if(!queue.isEmpty()) {
            int tmp = queue.poll();
            if(tmp == deque.peekFirst()) {
                deque.pollFirst();
            }
            return tmp;
        }
        return -1;
    }

}
