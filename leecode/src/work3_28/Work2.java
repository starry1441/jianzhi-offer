package work3_28;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * User: starry
 * Date: 2021 -03 -28
 * Time: 20:59
 */
public class Work2 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

}
