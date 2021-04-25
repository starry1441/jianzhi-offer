package work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -25
 * Time: 16:25
 */
public class Work6 {

    public static String reverseLeftWords(String s, int n) {
        String a = s.substring(0,n);
        String b = s.substring(n);
        StringBuilder res = new StringBuilder();
        res.append(b);
        res.append(a);
        return res.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        String a = "abcdef";
        System.out.println(reverseLeftWords(a, 2));
    }

}
