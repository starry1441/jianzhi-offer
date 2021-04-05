package work4_5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * User: starry
 * Date: 2021 -04 -05
 * Time: 16:58
 */
public class Work2 {

    List<Integer> list = new ArrayList<>();
    // List<String> list2 = new ArrayList<>();
    int result = 0;
    public int translateNum(int num) {
        int[] arr = change(num);
        int index = 0;
        search(arr,index);
        return result+1;
    }

    public void search(int[] num,int index) {
        if(index > num.length-2) return;
        if(num[index] == 1 || num[index] == 2 && num[index+1] < 6) {
            // List<Integer> had = new ArrayList<>();
            // had.add(index);
            // list2.add(translate(num,had));
            result++;
            search(num,index+2);
        }
        search(num,index+1);
    }

    // public String translate(int[] num,List<Integer> had) {
    //     int i = 0;
    //     StringBuilder s = new StringBuilder();
    //     while(i < num,length) {
    //         s.append(num[i]+"a");
    //         if(list.contains(i)) {
    //             s.append((num[i]*10+num[i+1])+"a");
    //             i = i+2;
    //             continue;
    //         }
    //         i++;
    //     }
    //     return s.toString();
    // }

    public int[] change(int num) {
        while(num > 0) {
            list.add(num%10);
            num = num/10;
        }
        int[] arr = new int[list.size()];
        int i = 0;
        int j = arr.length-1;
        while(i < arr.length) {
            arr[i] = list.get(j);
            i++;
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        Work2 a = new Work2();
        System.out.println(a.translateNum(12258));
    }

}
