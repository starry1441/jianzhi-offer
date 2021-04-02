package work4_2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -02
 * Time: 21:27
 */
public class Work1 {

    //时间复杂度太高，On3
    public int maxSubArray3(int[] nums) {
        int max = nums[0];
        //i来记录连续i+1个数字
        for(int i = 0; i < nums.length; i++) {
            //j来记录每次遍历i+1个连续数的次数
            for(int j = 0; j < nums.length-i; j++) {
                int sum = 0;
                //k来求区段的和
                for(int k = j; k <= j+i; k++) {
                    sum = sum+nums[k];
                }
                //算完区段的和才判断，可用方法二简化
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    //On2
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        //i来记录每次从第i个数开始往后算
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            //j来记录每次从i开始往后一直加
            for(int j = i; j < nums.length; j++) {
                sum = sum+nums[j];
                //每加一次判断一次
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    //动态规划
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(dp[i-1] < 0) {
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i-1] + nums[i];
            }
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    //动态规划
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i < nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    //贪心算法
    public int maxSubArray5(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int n : nums)
        {
            sum += n;
            if(sum > res)   res = sum;
            if(sum < 0)     sum = 0;
        }
        return res;
    }

    //分治
    public int maxSubArray6(int[] nums) {
        return divideConquer(nums,0,nums.length-1);
    }
    public int divideConquer(int[] nums,int low,int high) {
        //递归出口
        if (low>=high){
            return nums[low];
        }
        //三种情况，第一种：数组在左区间
        //第二种：数组在又区间
        //第三种：数组横跨左右区间
        //前两种递归求解即可
        //第三种情况以中间位置向两周扩散，找到最大值
        int mid = low+(high-low)/2;
        int left = divideConquer(nums,low,mid-1);
        int right = divideConquer(nums,mid+1,high);
        int maxMid = nums[mid];
        int curMId = nums[mid];
        for (int i = mid-1;i>=low;i--){
            curMId += nums[i];
            if (maxMid<curMId) maxMid = curMId;
        }
        curMId = maxMid;
        for (int i = mid+1;i<=high;i++){
            curMId += nums[i];
            if (maxMid<curMId) maxMid = curMId;
        }
        //4.返回三种情况中的最大值
        return Math.max(Math.max(left,right),maxMid);
    }

    public static void main(String[] args) {
        Work1 a = new Work1();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        a.maxSubArray1(nums);
        a.maxSubArray(nums);
    }

}
