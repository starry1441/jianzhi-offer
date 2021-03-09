package work3_5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -05
 * Time: 17:15
 */
public class Work5 {

    //map
    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.get(i) == null) {
                map.put(i, 1);
            }else {
                map.put(i, 1+map.get(i));
            }
        }
        for(int i : nums) {
            if(map.get(i) > 1) return i;
        }
        return -1;
    }

    //set
    public int findRepeatNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    //直接桶
    public int findRepeatNumber2(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]++;
            if(arr[nums[i]] > 1) return nums[i];
        }
        return -1;
    }

    //排序后比较
    public int findRepeatNumber3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i+1])
                return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        for(int i : nums) {
            System.out.println(i);
        }
    }

}
