package work3_13;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * User: starry
 * Date: 2021 -03 -13
 * Time: 21:54
 */

//有问题的思路
public class Work2 {

    public boolean exist(char[][] board, String word) {
        int hang = board.length;
        int lie = board[0].length;
        int[][] arr = first(board,word);
        if(arr == null) return false;

        char[][] big = new char[hang+2][lie+2];
        for(int i = 0; i < hang; i++) {
            for(int j = 0; j < lie; j++) {
                big[i+1][j+1] = board[i][j];
            }
        }

        int k = 0;
        while(k < arr.length) {
            int[][] isused = new int[hang+2][lie+2];
            int i = arr[k][0]+1;
            int j = arr[k][1]+1;
            isused[i][j] = 1;
            int count = 1;
            //这里开始有些问题，不一定按照下上左右的顺序寻找，所以此思路有问题
            while(count < word.length()) {
                if(isused[i+1][j] == 0 && big[i+1][j] == word.charAt(count)) {  //下
                    i = i+1;
                }else if(isused[i-1][j] == 0 &&big[i-1][j] == word.charAt(count)) { //上
                    i =i-1;
                }else if(isused[i][j-1] == 0 &&big[i][j-1] == word.charAt(count)) { //左
                    j = j-1;
                }else if(isused[i][j+1] == 0 &&big[i][j+1] == word.charAt(count)) { //右
                    j = j+1;
                }else {
                    break;
                }
                isused[i][j] = 1;
                count++;
            }
            if(count != word.length()) {
                k++;
            }else {
                return true;
            }
        }
        return false;
    }

    public int[][] first(char[][] board, String word) {
        char tmp = word.charAt(0);
        int hang = board.length;
        int lie = board[0].length;
        int count = 0;
        for(int i = 0; i < hang; i++) {
            for(int j = 0; j < lie; j++) {
                if(board[i][j] == tmp) {
                    count++;
                }
            }
        }
        if(count == 0) return null;
        int[][] arr = new int[count][];
        int k = 0;
        int i,j;
        for(i = 0; i < hang; i++) {
            for(j = 0; j < lie; j++) {
                if(board[i][j] == tmp) {
                    arr[k] = new int[]{i, j};
                    k++;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";      //{'A','A','A'}
        Work2 a = new Work2();    //{'B','C','D'}
        System.out.println(a.exist(arr, word));
    }

}
