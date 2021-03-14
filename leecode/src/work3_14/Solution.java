package work3_14;

import work3_13.Work2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * User: starry
 * Date: 2021 -03 -14
 * Time: 18:47
 */

//很棒的思路，回溯法，又称深度优先搜索（DFS）
public class Solution {

    //函数返回是否存在该路径
    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();
        //判断位置是否被走过，默认false：没走过
        boolean[][] isused = new boolean[board.length][board[0].length];
        //循环遍历二维数组每个位置
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                //然后每个位置判断是否可以达成word路径
                if(dfs(board, ch, isused, i, j, 0)) return true;
            }
        }
        return false;
    }

    //递归每个位置，回溯法：先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推
    public boolean dfs(char[][] board, char[] ch, boolean[][] isused, int i, int j, int index) {
        //不符合word路径的条件
        //1.该位置越界
        //2.board(i,j)位置不符合word(index)位置
        //3.该位置已经走过
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != ch[index] || isused[i][j]) {
            return false;
        }
        //符合word路径的条件:
        if(index == ch.length-1) {
            return true;
        }
        //已经走过这个位置了
        isused[i][j] = true;
        //step先向上一直搜索，不行了再回溯上一个节点，再向下。。。再向左。。。再向右。。。
        boolean step = false;
        step = dfs(board, ch, isused, i-1, j, index+1) ||
                dfs(board, ch, isused, i+1, j, index+1) ||
                dfs(board, ch, isused, i, j-1, index+1) ||
                dfs(board, ch, isused, i, j+1, index+1);
        //因为走不下去，退回到上一位置了，所以该位置重置为false：没走过
        isused[i][j] = false;
        return step;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";      //{'A','A','A'}
        Solution a = new Solution();    //{'B','C','D'}
        System.out.println(a.exist(arr, word));
    }

}
