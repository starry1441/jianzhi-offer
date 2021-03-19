package work3_19;

/**
 * Created with IntelliJ IDEA.
 * Description:剪绳子 II
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * User: starry
 * Date: 2021 -03 -19
 * Time: 17:22
 */
public class Work2 {

    public int cuttingRope(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

}
