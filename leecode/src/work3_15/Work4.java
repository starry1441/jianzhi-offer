package work3_15;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -15
 * Time: 16:34
 */
public class Work4 {
    public static double myPow(double x, int n) {
        if(x == 1) return 1;
        double res = x;
        if(n > 0) {
            double first = res;
            for(int i = 1; i < n; i++) {
                res = res*first;
            }
        }else if(n == 0){
            return 1;
        }else {
            res = 1/x;
            double first = res;
            for(int i = n; i < -1; i++) {
                res = res*first;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 2;
        int y = -2147483648;
        System.out.println(myPow(x, y));
    }
}
