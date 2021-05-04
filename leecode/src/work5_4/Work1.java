package work5_4;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 * User: starry
 * Date: 2021 -05 -04
 * Time: 15:57
 */
public class Work1 {

    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

}
