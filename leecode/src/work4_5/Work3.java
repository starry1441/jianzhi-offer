package work4_5;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 46. 把数字翻译成字符串
 * User: starry
 * Date: 2021 -04 -05
 * Time: 17:09
 */
public class Work3 {

    Stack<Integer> stack = new Stack<>();   //存储num的每一位数
    int result = 0; //结果

    //主函数：返回有result种不同的翻译方法
    public int translateNum(int num) {
        int[] arr = change(num);
        int index = 0;
        search(arr,index);
        return result+1;    //最后加上一种每位数都翻译的情况
    }

    //树形结构递归每一位
    public void search(int[] arr,int index) {
        //如果最后剩下一位数，则说明数组遍历完了，返回
        if(index > arr.length-2) return;
        //如果是10-25之间的数字，则可以发生两位数合在一起翻译
        if(arr[index] == 1 || arr[index] == 2 && arr[index+1] < 6) {
            result++;
            search(arr,index+2);    //对应的index下标得往后走两位
        }
        search(arr,index+1);    //index下标往后走一位
    }

    //将数字转换位数组并返回
    public int[] change(int num) {
        //从后往前将每一位数放在栈中
        while(num > 0) {
            stack.push(num%10);
            num = num/10;
        }
        int[] arr = new int[stack.size()];
        //数组从头每个元素为栈顶弹出元素
        for(int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

    //动态规划
    public int translateNum1(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }




}
