package work3_31;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 38. 字符串的排列
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * User: starry
 * Date: 2021 -03 -31
 * Time: 22:20
 */
public class Work1 {

    List<String> list = new ArrayList();    //链表存放每次构建的字符串
    public char[] arr;

    public String[] permutation(String s) {
        arr = s.toCharArray();  //把字符串s的所有字符存放在数组arr中
        dfs(0); //从第0层开始递归
        return list.toArray(new String[list.size()]);   //把顺序表中存的字符串变为为数组字符串输出
    }

    //递归函数，x为arr数组下标
    public void dfs(int x) {
        //当x走到倒数第二个元素时，说明前面所有元素固定完了，剩下一个不用固定
        if(x == arr.length-1) {
            list.add(new String(arr));  //此时把该顺序的数组转为字符串加入到顺序表中
            return; //递归结束，返回上一层
        }
        //需要一个set来存放已经遍历过的元素
        Set<Character> set = new HashSet<>();
        //遍历每一层，每次从x开始遍历
        for(int i = x; i < arr.length; i++) {
            //发生剪枝，当包含这个元素的时候，直接跳过
            if(set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);    //程序走到这说明没有剪枝，那么把该元素放到set中
            swap(x,i);  //交换元素，将arr[i]固定在第 x 位
            dfs(x+1);   //进入下一层递归，开启固定第 x + 1 位字符
            swap(x,i);  // 恢复交换
        }
    }

    //数组中元素交换
    public void swap(int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
