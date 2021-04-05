package work4_5;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 45. 把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * User: starry
 * Date: 2021 -04 -05
 * Time: 14:51
 */
public class Work1 {

    //时间复杂度太大：方法一
    List<String> list = new ArrayList();    //链表存放每次构建的字符串
    public String[] s;
    public String minNumber(int[] nums) {
        s = new String[nums.length];
        for(int j = 0; j < nums.length; j++) {
            s[j] = nums[j]+"";
        }
        dfs(0); //从第0层开始递归
        String min = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            String tmp = list.get(i);
            if(min.compareTo(tmp) > 0) {
                min = tmp;
            }
        }
        return min;
    }

    //递归函数，x为arr数组下标
    public void dfs(int x) {
        //当x走到倒数第二个元素时，说明前面所有元素固定完了，剩下一个不用固定
        if(x == s.length-1) {
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < s.length; j++) {
                res.append(s[j]);
            }
            list.add(res.toString());  //此时把该顺序的数组转为字符串加入到顺序表中
            return; //递归结束，返回上一层
        }
        //需要一个set来存放已经遍历过的元素
        Set<String> set = new HashSet<>();
        //遍历每一层，每次从x开始遍历
        for(int i = x; i < s.length; i++) {
            //发生剪枝，当包含这个元素的时候，直接跳过
            if(set.contains(s[i])) {
                continue;
            }
            set.add(s[i]);    //程序走到这说明没有剪枝，那么把该元素放到set中
            swap(x,i);  //交换元素，将arr[i]固定在第 x 位
            dfs(x+1);   //进入下一层递归，开启固定第 x + 1 位字符
            swap(x,i);  // 恢复交换
        }
    }

    //数组中元素交换
    public void swap(int i, int j) {
        String tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }


    /**
     * 正确做法
     * @param nums
     * @return
     */
    public String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        //Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        sort(strs);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    //20 2
    //202   220

    public void sort(String[] strs) {
        for(int i = 0; i < strs.length; i++) {
            for(int j = 0; j < strs.length-i-1; j++) {
                if((strs[j]+strs[j+1]).compareTo(strs[j+1]+strs[j]) > 0) {
                    String tmp = strs[j];
                    strs[j] = strs[j+1];
                    strs[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Work1 a = new Work1();
        System.out.println(a.minNumber1(nums));
    }

}
