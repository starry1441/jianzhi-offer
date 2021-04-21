package Work4_21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * User: starry
 * Date: 2021 -04 -21
 * Time: 17:18
 */
public class Work2 {

    //map，慢了点
    public int[] singleNumbers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        int[] res = new int[2];
        int j = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                res[j] = entry.getKey();
                j++;
                if(j == 2) {
                    break;
                }
            }
        }
        return res;
    }

    //异或
    public int[] singleNumbers1(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        Work2 a = new Work2();
        int[] res = a.singleNumbers(new int[]{1,2,10,4,1,4,3,3});
        System.out.println(Arrays.toString(res));
    }

}
