package work3_5;

/**
 * Created with IntelliJ IDEA.
 * Description:斐波那契数列
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * User: starry
 * Date: 2021 -03 -05
 * Time: 15:28
 */
public class Work1 {
    //方法一
    public int Fibonacci(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        if(n == 0) return 0;
        arr[1] = 1;
        if(n == 1) return 1;
        for(int i = 2; i < n+1; i++) {
            arr[i] = arr[i-1]+arr[i-2];
            if(i == n) return arr[i];
        }
        return -1;
    }

    //方法二
    public int Fibonacci1(int n) {
        int a = 0;
        if(n == 0) return 0;
        int b = 1;
        if(n == 1) return 1;
        int c;
        for(int i = 2; i <= n; i++) {
            c = a+b;
            if(i == n) return c;
            a = b;
            b = c;
        }
        return -1;
    }
}
