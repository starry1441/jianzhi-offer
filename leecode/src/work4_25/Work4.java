package work4_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -25
 * Time: 13:46
 */
public class Work4 {

    //滑动窗口
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int start = 1;
        int end = 2;
        int sum = 3;
        while(start <= target/2) {
            if(sum < target) {
                end++;
                sum += end;
            }else if(sum > target) {
                sum -= start;
                start++;
            }else {
                int[] in = new int[end-start+1];
                for(int i = 0; i < in.length; i++) {
                    in[i] = start+i;
                }
                list.add(in);
                sum -= start;
                start++;
            }
        }
        int[][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    //1 2 3 4 5 6   ---21
    public int[][] findContinuousSequence1(int target) {
        Stack<int[]> out = new Stack<>();
        if(target%2 == 1){
            int i = 2;
            while(target/i >= i/2) {
                if(target % i == 0) {
                    int[] in = new int[i];
                    int start = target/i - i/2;
                    for(int j = 0; j < i; j++) {
                        in[j] = start;
                        start++;
                    }
                    out.push(in);
                }
                if(target % i == i/2) {
                    int[] in = new int[i];
                    int start = target/i - i/2 + 1;
                    for(int j = 0; j < i; j++) {
                        in[j] = start;
                        start++;
                    }
                    out.push(in);
                    if(in[0] == 1) break;
                }
                i++;
            }
        }else {
            int i = 2;
            while(target/i >= i/2) {
                if(target % i == 0) {
                    int[] in = new int[i];
                    int start = target/i - i/2;
                    for(int j = 0; j < i; j++) {
                        in[j] = start;
                        start++;
                    }
                    out.push(in);
                }
                if(target % i == i/2) {
                    int[] in = new int[i];
                    int start = target/i - i/2 + 1;
                    for(int j = 0; j < i; j++) {
                        in[j] = start;
                        start++;
                    }
                    out.push(in);
                    if(in[0] == 1) break;
                }
                i++;
            }
        }
        int size = out.size();
        int[][] res = new int[size][];
        for(int j = 0; j < size; j++) {
            res[j] = out.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Work4 a = new Work4();
        int[][] res = a.findContinuousSequence(15);
        System.out.println(Arrays.deepToString(res));
    }

}
