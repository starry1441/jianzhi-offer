package work4_9;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * User: starry
 * Date: 2021 -04 -09
 * Time: 15:26
 */
public class Work1 {

    //linkedhashmap
    public char firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    //hashmap
    public char firstUniqChar1(String s) {
        if(s == null || s.length() == 0) return ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else
                map.put(c, 1);
        }
        for(int i = 0;i < s.length();i++){
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    //字典
    public char firstUniqChar2(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i)-'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "leetcode";
        Work1 a = new Work1();
        System.out.println(a.firstUniqChar(s));
    }

}
