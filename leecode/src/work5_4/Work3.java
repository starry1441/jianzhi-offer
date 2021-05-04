package work5_4;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 65. 不用加减乘除做加法
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * User: starry
 * Date: 2021 -05 -04
 * Time: 18:33
 */
public class Work3 {

    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

}
