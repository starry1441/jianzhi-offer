package work4_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 44. 数字序列中某一位的数字
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * User: starry
 * Date: 2021 -04 -03
 * Time: 9:42
 */
public class Work1 {

    public int findNthDigit(int n) {
        int i = 1;
        int k = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while(true) {
            int count = wei(i);
            int[] arr = addlist(i,count);
            for(int j = 0; j < arr.length; j++) {
                list.add(arr[j]);
            }
            k = k+count;
            if(k > n) break;
            i++;
        }
        return list.get(n);
    }
    public int[] addlist(int i, int count) {
        int[] arr = new int[count];
        int j = count-1;
        while(i > 0) {
            arr[j] = i%10;
            i = i/10;
            j--;
        }
        return arr;
    }
    public int wei(int i) {
        int count = 0;
        while(i > 0) {
            i = i/10;
            count++;
        }
        return count;
    }

    public int findNthDigit1(int n) {
        int k = 0;
        int i = 1;  //位
        while(true) {
            if(k + Math.pow(10,i-1)*9*i >= n) {
                break;
            }
            k = (int) (k + Math.pow(10,i-1)*9*i);
            i++;
        }
        int a = n-k-1;
        int b = a/i;
        int num = (int) (b+Math.pow(10,i-1));
        int yu = a%i;
        int[] arr = new int[i];
        for(int j = i-1; j >=0; j--) {
            arr[j] = num%10;
            num = num/10;
        }
        return arr[yu];
    }

    public static void main(String[] args) {
        Work1 a = new Work1();
        System.out.println(a.findNthDigit1(10));
    }

}
