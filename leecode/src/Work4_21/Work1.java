package Work4_21;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * User: starry
 * Date: 2021 -04 -21
 * Time: 16:23
 */
public class Work1 {

    public int nthUglyNumber(int n) {
        int i = 2;
        int count = 1;
        while(count < n) {
            if(i%2 == 0 || i%3 == 0 || i%5 == 0) {
                count++;
            }
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        Work1 a = new Work1();
        System.out.println(a.nthUglyNumber(11));
    }

}
