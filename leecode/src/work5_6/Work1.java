package work5_6;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 67. 把字符串转换成整数
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * User: starry
 * Date: 2021 -05 -06
 * Time: 11:26
 */
public class Work1 {
    public int strToInt(String str) {
        str = str.trim();
        if(str.length() == 0) return 0;
        StringBuilder s = new StringBuilder();
        boolean isZero = true;
        char a = str.charAt(0);
        if(a == '-' || a == '+') {
            if(str.length() > 1 && str.charAt(1) >= '0' && str.charAt(1) <= '9') {
                if(str.charAt(1) == '0') {
                    isZero = false;
                }
                s.append(a);
            }else {
                return 0;
            }
        }else if(a >= '0' && a <= '9') {
            if(a == '0') {
                isZero = false;
            }else {
                s.append(a);
            }
        }else {
            return 0;
        }

        for (int i = 1; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if(!isZero && tmp == '0') {
                isZero = false;
                continue;
            }else {
                isZero = true;
            }

            if(tmp >= '0' && tmp <= '9') {
                s.append(tmp);
            }else {
                break;
            }
        }
        String res = s.toString();
        if(res.length() > 11) {
            if(res.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        if(res.equals("+") || res.equals("-") || res.equals("")) {
            return 0;
        }
        long l = Long.parseLong(res);
        if(l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)l;
    }

    public static void main(String[] args) {
        Work1 a = new Work1();
        System.out.println(a.strToInt("-000000000000001"));
    }
}
