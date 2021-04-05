package work3_28;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 39. 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * User: starry
 * Date: 2021 -03 -28
 * Time: 20:59
 */
public class Work1 {

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        int max = 0;
        for(Integer key : map.keySet()) {
            if(map.get(key) > nums.length/2) {
                return key;
            }
        }
        return -1;
    }

}
