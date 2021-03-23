package work3_23;

/**
 * Created with IntelliJ IDEA.
 * Description:调整数组顺序使奇数位于偶数前面
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * User: starry
 * Date: 2021 -03 -23
 * Time: 16:03
 */
public class Work1 {

    public int[] exchange(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = len-1;
        while(i < j) {
            while(i < len && nums[i]%2 != 0) {
                i++;
            }
            while(j >= 0 && nums[j]%2 != 1) {
                j--;
            }
            if(i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }

}
