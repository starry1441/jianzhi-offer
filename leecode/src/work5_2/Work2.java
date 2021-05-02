package work5_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -02
 * Time: 19:46
 */
public class Work2 {

    public boolean isStraight(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int zero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zero++;
            }else {
                list.add(nums[i]);
            }
        }
        list.sort(Integer::compareTo);
        int need = 0;
        for (int i = 1; i < list.size(); i++) {
            int tmp = list.get(i) - list.get(i-1);
            if(tmp < 1) {
                return false;
            }else {
                need += tmp-1;
            }
        }
        if(need <= zero) {
            return true;
        }
        return false;
    }

    public boolean isStraight1(int[] nums) {
        int zero = 0;
        int l = 0;
        int r = 0;
        int need = 0;
        while(r < nums.length) {
            if(nums[r] == 0) {
                zero++;
                r++;
                continue;
            }
            if(nums[r] - nums[l] == 1) {
                l = r;
                continue;
            }else {
                need = need + nums[r] - nums[l] + 1;
            }
            r++;
        }
        if(need == zero){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Work2 a = new Work2();
        System.out.println(a.isStraight(new int[]{11,8,12,8,10}));
    }
}
