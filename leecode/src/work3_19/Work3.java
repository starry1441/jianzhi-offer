package work3_19;

/**
 * Created with IntelliJ IDEA.
 * Description:表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * User: starry
 * Date: 2021 -03 -19
 * Time: 17:22
 */
public class Work3 {

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        char[] arr = s.toCharArray();
        int len = arr.length;
        int count = 0;
        boolean haveE = false;
        for(int i = 0; i < len; i++) {
            if(!isnum(arr[i]) && !isnor(arr[i])) return false;
            //e,E
            if(arr[i] == 'e' || arr[i] == 'E') {
                if(haveE) return false;
                haveE = true;
                //e的前后位置越界
                if(i-1 < 0 || i+1 >= len) {
                    return false;
                }
                //e的前位置不为数字,e的后位置不为 - 或者数字
                if(!isnum(arr[i-1]) && arr[i-1]!='.') return false;
                if(!isnum(arr[i+1]) && arr[i+1] != '-' && arr[i-1]!='.' && arr[i+1]!='+') return false;
            }
            //+
            if(arr[i] == '+') {
                //第一位不为+
                if(i == 0) continue;
                if(i == len-1) return false;
                if(arr[i - 1] == 'e' || arr[i - 1] == 'E') continue;
                return false;
            }
            //-
            if(arr[i] == '-') {
                //最后为-
                if(arr[len-1] == '-') return false;
                //-的前不为e
                if(i-1 >=0 && arr[i-1] != 'e' && arr[i-1] != 'E') {
                    return false;
                }
            }
            //.
            if(arr[i] == '.') {
                //.在最前 且 后位越界
                if(i == 0) {
                    count++;
                    if(i+1 < len) {
                        //.后不为数字
                        if(!isnum(arr[i+1])) return false;
                        continue;
                    }else {
                        return false;
                    }
                }
                //.在最后一位
                if(i == len-1) {
                    count++;
                    if(count > 1) return false;
                    if(isnor(arr[i-1]) && i+1>=len) return false;
                    //.的前面有e
                    if(haveE) return false;
                    continue;
                }
                count++;
                //.的后位置不为数字
                if(!isnum(arr[i+1]) && arr[i+1]!='e' && arr[i+1]!='E') return false;
                //.的前面有e
                if(haveE) return false;
                if(count > 1) return false;
            }
        }
        return true;
    }

    public boolean isnum(char en) {
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        int i;
        for(i = 0; i < 10; i++) {
            if(en == num[i]) break;
        }
        return i != 10;
    }

    public boolean isnor(char en) {
        char[] num = {'+','-','e','E','.'};
        int i;
        for(i = 0; i < num.length; i++) {
            if(en == num[i]) break;
        }
        return i != num.length;
    }

    public static void main(String[] args) {
        String s =
                "4e+";
        Work3 a = new Work3();
        System.out.println(a.isNumber(s));
    }

}
