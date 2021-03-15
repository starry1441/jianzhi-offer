package work3_15;

/**
 * Created with IntelliJ IDEA.
 * Description:机器人的运动范围(深度优先遍历)DFS
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * User: starry
 * Date: 2021 -03 -15
 * Time: 14:27
 */

//深度优先遍历
public class Work1 {

    public int movingCount(int m, int n, int k) {
        boolean[][] isUsed = new boolean[m][n];
        return dfs(0, 0, m, n, k, isUsed);
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] isUsed) {
        if(i < 0 || i > m-1 || j < 0 || j > n-1 || sum(i)+sum(j) > k || isUsed[i][j]) {
            return 0;
        }
        isUsed[i][j] = true;
        int result = dfs(i-1, j, m, n, k, isUsed) +
                dfs(i+1, j, m, n, k, isUsed) +
                dfs(i, j-1, m, n, k, isUsed) +
                dfs(i, j+1, m, n, k, isUsed) + 1;
        return result;
    }

    public int sum(int a) {
        int count = 0;
        while(a != 0) {
            count = count + a%10;
            a = a/10;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 123;
        Work1 w = new Work1();
        System.out.println(w.movingCount(2,3,1));
    }

}
