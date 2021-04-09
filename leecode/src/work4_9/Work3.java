package work4_9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * User: starry
 * Date: 2021 -04 -09
 * Time: 17:17
 */
public class Work3 {

    //回溯 list
    List<Integer> list = new ArrayList<>();
    public int maxValue(int[][] grid) {
        int x = 0;
        int y = 0;
        int count = 0;
        dfs(x,y,count,grid);
        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
    public void dfs(int x,int y,int count,int[][] grid) {
        if(x > grid.length-1 || y > grid[0].length-1) {
            return;
        }
        if(x == grid.length-1 && y == grid[0].length-1) {
            list.add(count+grid[grid.length-1][grid[0].length-1]);
            return;
        }
        dfs(x,y+1,count+grid[x][y],grid);
        dfs(x+1,y,count+grid[x][y],grid);
    }

    //回溯 max
    int max = 0,m,n;
    public int maxValue1(int[][] grid) {
        m = grid.length-1;
        n = grid[0].length-1;
        dfs1(0, 0, 0, grid);
        return max;
    }
    public void dfs1(int i, int j, int tmp, int[][] grid) {
        if (i>m || j>n) return;
        if (i==m && j==n) {
            tmp+=grid[i][j];
            max = Math.max(tmp,max);
            return;
        }
        dfs1(i+1, j, tmp+grid[i][j], grid);
        dfs1(i, j+1, tmp+grid[i][j], grid);
    }

    //dp
    public int maxValue3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j - 1] ;
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Work3 a = new Work3();
        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        int[][] grid2 = {{1,2,5},{3,2,1}};
        System.out.println(a.maxValue(grid2));
    }

}
