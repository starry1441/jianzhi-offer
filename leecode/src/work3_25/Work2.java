package work3_25;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -25
 * Time: 19:51
 */
public class Work2 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int push = pushed.length;
        int pop = popped.length;
        int i = 0;  //入栈下标
        int j = 0;  //出栈下标
        Stack<Integer> stack = new Stack<>();
        //下标范围内循环
        while(j < pop) {
            int start = i;  //记录入栈的下标

            //若栈为空 或 栈顶元素不等于弹出j下标元素
            //则进行入栈模拟，找到下个出栈的元素，然后入从start到k
            if(stack.isEmpty() || stack.peek() != popped[j]) {
                for(int k = i; k < push; k++) {
                    //先找到出栈元素 对应的 入栈元素的下标，为k
                    if(pushed[i] == popped[j]) {
                        //从start到k元素入栈
                        for(int n = start; n <= k; n++) {
                            stack.push(pushed[n]);
                        }
                        i++;
                        break;  //入完栈循环结束
                    }
                    i++;
                }
            }

            //判断栈顶元素和出栈元素是否相等，相等遍历下一个，不等就返回false
            if(stack.pop() == popped[j]) {
                j++;
            }else {
                return false;
            }
        }
        //如果程序走到这，证明出栈元素遍历完成，符合入栈出栈条件，返回true
        return true;
    }

    public static void main(String[] args) {
        //int[] pushed = {1,2,3,4,5};
        //int[] popped = {4,5,3,2,1};
        int[] pushed = {2,1,0};
        int[] popped = {1,2,0};
        System.out.println(validateStackSequences(pushed, popped));
    }

}
