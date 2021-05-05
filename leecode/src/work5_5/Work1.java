package work5_5;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 66. 构建乘积数组
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * User: starry
 * Date: 2021 -05 -05
 * Time: 19:26
 */
public class Work1 {

    public int[] constructArr2(int[] a) {
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < b.length; i++) {
            b[i] = b[i-1] * a[i-1];
        }
        for(int i = a.length-2; i >= 0; i--) {
            tmp *= a[i+1];
            b[i] *= tmp;
        }
        return b;
    }

    //超时
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        for(int i = 0; i < b.length; i++) {
            int ji = 1;
            for(int j = 0; j < i; j++) {
                ji *= a[j];
            }
            for(int j = i+1; j < a.length; j++) {
                ji *= a[j];
            }
            b[i] = ji;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        Work1 w = new Work1();
        System.out.println(Arrays.toString(w.constructArr2(a)));
    }

}
