package work3_5;

/**
 * Created with IntelliJ IDEA.
 * Description:替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/submissions/
 * User: starry
 * Date: 2021 -03 -05
 * Time: 16:40
 */
public class Work4 {

    //调用库函数
    public static String replaceSpace (String s) {
        // write code here
        String b = s.replaceAll(" ", "%20");
        return b;
    }

    public String replaceSpace1(String s) {
        StringBuilder a = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                a.append("%20");
            }else {
                a.append(s.charAt(i));
            }
        }
        return a.toString();
    }

}
