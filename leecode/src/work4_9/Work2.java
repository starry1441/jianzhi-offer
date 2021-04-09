package work4_9;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * User: starry
 * Date: 2021 -04 -09
 * Time: 16:56
 */
class MinStack {
    Stack<Integer> a;
    Stack<Integer> b;

    /** initialize your data structure here. */
    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        if(a.empty() || x <= b.peek()) {
            b.push(x);
            a.push(x);
        }else {
            a.push(x);
        }
    }

    //不能用==，因为Integer不能用==判断里面值是否相等
    public void pop() {
        if(a.pop().equals(b.peek())) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}

public class Work2{
    public static void main(String[] args) {
        MinStack min = new MinStack();
        min.push(512);
        min.push(-1024);
        min.push(-1024);
        min.push(512);
        min.pop();
        System.out.println(min.min());
        min.pop();
        System.out.println(min.min());
        min.pop();
        System.out.println(min.min());

    }
}