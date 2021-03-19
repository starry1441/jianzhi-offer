package Work3_18;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -18
 * Time: 16:38
 */
public class Work4 {

    //动态规划
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];   //从长度为0到长度为n，一共有n+1个长度
        int i;  //i代表长度为i的线
        int j;  //j代表剪掉线的长度
        dp[2] = 1;  //当线长度为2的时候，最大的乘积肯定是1,d[1],d[0]为创建数组的默认值0
        //i从3开始，因为小于3的长度的最大乘积很明确,一直遍历到最大的长度，得到dp[i]长度为i的绳子剪成m段后的最大乘积
        for(i = 3; i < dp.length; i++) {
            //剪掉的长度为j，一直遍历到该绳子的最大长度
            for(j = 2; j < i; j++) {
                int tmp = Math.max(j*(i-j),j*dp[i-j]);  //剪掉j后的长度为i-j，所以乘积就为j*(i-j)
                //如果剪掉j后再要继续剪，那么就相当于再从i-j中得出最大乘积，i-j绳的最大乘积就为之前算出来的dp[i-j]
                //所以最后直接判断 只剪断j的乘积 和 剪断j后继续再剪的乘积 的最大值就可以
                dp[i] = Math.max(dp[i],tmp);    //比较前一个剪断j后的最大乘积 和 现后的最在剪断j大乘积，因为j是一直变化的
            }
        }
        //最后只用返回题目需要长度为n的绳子 的最大乘积
        return dp[n];
    }

}
