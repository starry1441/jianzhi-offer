package work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -25
 * Time: 16:04
 */
public class Work5 {

    public static String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = str.length-1; i > 0; i--) {
            if(!str[i].equals("")) {
                res.append(str[i]);
                res.append(" ");
            }
        }
        res.append(str[0]);
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(reverseWords(str));
    }

}
