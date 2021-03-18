package Work3_18;

/**
 * Created with IntelliJ IDEA.
 * Description:数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * User: starry
 * Date: 2021 -03 -18
 * Time: 15:44
 */
public class Work1 {

    public double myPow(double x, int n) {
        long b = n;
        if(b < 0){
            x = 1 / x;
            b = - b;
        }
        double res = 1;
        while(b != 0){
            if(b % 2 != 0){
                res *= x;
            }
            b >>= 1;
            x *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 5;
        System.out.println(a);
        a >>= 1;
        System.out.println(a);
    }

}

//10010