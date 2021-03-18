package Work3_18;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * User: starry
 * Date: 2021 -03 -18
 * Time: 16:19
 */
public class Work3 {

    Stack<Integer> a;
    Stack<Integer> b;

    public Work3() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void appendTail(int value) {
        a.push(value);
    }

    public int deleteHead() {
        if(b.empty()) {
            if(a.empty()) return -1;
            while(!a.empty()) {
                int tmp = a.pop();
                b.push(tmp);
            }
        }
        return b.pop();
    }

}
