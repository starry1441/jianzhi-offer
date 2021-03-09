package work3_9;

/**
 * Created with IntelliJ IDEA.
 * Description:青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * User: starry
 * Date: 2021 -03 -09
 * Time: 11:56
 */
public class Work1 {

    public int numWays(int n) {
        int a = 1;
        if(n == 0) return 1;
        int b = 1;
        if(n == 1) return 1;
        int c = -1;
        for(int i = 2; i <= n; i++) {
            c = (a+b)%1000000007;
            a = b;
            b = c;
        }
        return c;
    }

}
