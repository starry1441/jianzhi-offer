package work5_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -02
 * Time: 11:39
 */
public class Work1 {

    public double[] dicesProbability3(int n) {
        //声明 n 行，最大数字和为 n*6 的二维数组
        int[][] dp = new int[n + 1][6 * n + 1];
        //初始化数据，当 n 为 1 时，分别 1-6 都各 1 次
        for(int i = 1; i <= 6; i++)
            dp[1][i] = 1;
        //每多一个骰子进行处理，i表示骰子的个数
        for(int i = 2; i <= n; i++)
            //循环所有 有的数字，因为 i 个骰子最小的数为 i，所以从 i 下标循环，最大数字为 6 * i
            for(int j = i; j <= 6 * i; j++)
                //数字和有可能分别通过 +1，+2，+3，+4，+5，+6的操作得到，所以分别加上上一层的 -1，-2，-3，-4，-5，-6的个数
                //还有一个前提就是，j-k >= 0 ，也就是 k <= j
                for(int k = 1; k <= 6 && k <= j; k++)
                    dp[i][j] += dp[i-1][j - k];
        //声明结果数组，长度为 6 * n - n + 1
        double[] ans = new double[6 * n - n + 1];
        //每个数字和 对应的 次数 / 总次数 ，得到结果
        //总次数为 6的n次方
        for(int i = n; i <= 6 * n; i++)
            ans[i - n] = ((double)dp[n][i]) / (Math.pow(6,n));
        return ans;
    }

    public static double[] dicesProbability(int n) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < 6; i++) {
            map.put(i+1,1);
        }
        for(int i = 1;i < n; i++) {
            for(int a : map.keySet()) {
                for (int j = 1; j <= 6; j++) {
                    int tmp = a;
                    if(!map.containsKey(tmp+j)) {
                        map.put(tmp+j,1);
                    }else {
                        map.put(tmp+j,map.get(tmp)+1);
                    }
                }
            }
        }
        int sum = 0;
        for (int a : map.values()) {
            sum += a;
        }
        double[] res = new double[map.size()];
        int i = 0;
        for (double a : map.values()) {
            res[i] = a/sum;
            i++;
        }
        return res;
    }

    public static double[] dicesProbability2(int n) {
        int[][] arr = new int[n][n*6];
        double sum = 0;
        for(int i = 0; i < 6; i++) {
            arr[0][i] = 1;
        }
        for(int i = 1;i < n; i++) {
            for(int j = 0; j < i*6; j++) {
                for (int k = 0; k < 6; k++) {
                    int x = arr[i-1][j+k];
                    arr[i][j+k] += 1;
                    if(i == n-1) {
                        sum += 1.0;
                    }
                    x--;
                    if(x <= 0) break;
                }
            }
        }
        double[] res = new double[6*n-n+1];
//        for(int i = 0; i < res.length; i++) {
//            res[i] = arr[i+n]/sum;
//        }
        return res;
    }

    public static void main(String[] args) {
        double[] res = dicesProbability2(2);
        System.out.println(Arrays.toString(res));
    }

}
