package work4_10;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * User: starry
 * Date: 2021 -04 -10
 * Time: 14:32
 */
public class Work2 {

    public int search(int[] nums, int target) {
        int left = 0;
        int count = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] > target) {
                right = mid-1;
            }else if(nums[mid] < target) {
                left = mid+1;
            }else {
                int goleft = mid;
                int goright = mid;
                while(goleft >= 0 && nums[goleft] == target) {
                    if(nums[goleft] == target) {
                        count++;
                        goleft--;
                    }
                }
                while(goright <= nums.length-1 && nums[goright] == target) {
                    if(nums[goright] == target) {
                        count++;
                        goright++;
                    }
                }
                return count-1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        Work2 a = new Work2();
        System.out.println(a.search(arr, 8));
    }

}
