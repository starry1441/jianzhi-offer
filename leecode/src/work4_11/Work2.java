package work4_11;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 53 - II. 0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * User: starry
 * Date: 2021 -04 -11
 * Time: 20:39
 */
public class Work2 {

    public int missingNumber(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0) return 1;
            if(nums[0] == 1) return 0;
        }
        int left = 0;
        int right = nums.length-1;
        if(nums[right] == right) return nums[right]+1;
        if(nums[left] == left+1) return 0;
        while(left+1 != right) {
            int mid = (left+right)/2;
            if(nums[mid] == mid) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return nums[right]-1;
    }

}
