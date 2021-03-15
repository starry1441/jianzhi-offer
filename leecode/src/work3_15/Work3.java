package work3_15;

/**
 * Created with IntelliJ IDEA.
 * Description:二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * User: starry
 * Date: 2021 -03 -15
 * Time: 15:56
 */
public class Work3 {

    public int hammingWeight(int n) {
        int count = 0;
        String s = String.valueOf(n);
        for(int i = 0; i < 32; i++) {
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 123456;
        String b = String.valueOf(a);
        System.out.println(b);
    }

}
