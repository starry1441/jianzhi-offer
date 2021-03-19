package Work3_18;

/**
 * Created with IntelliJ IDEA.
 * Description:打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * User: starry
 * Date: 2021 -03 -18
 * Time: 16:01
 */
public class Work2 {

    public int[] printNumbers(int n) {
        int count = Sum(n);
        int[] arr = new int[count];
        for(int i = 0; i < count; i++) {
            arr[i] = i+1;
        }
        return arr;
    }

    public int Sum(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            count = count*10;
        }
        return count-1;
    }

}
