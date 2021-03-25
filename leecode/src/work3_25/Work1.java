package work3_25;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * User: starry
 * Date: 2021 -03 -25
 * Time: 15:59
 */
public class Work1 {

    public int[] spiralOrder(int[][] matrix) {
        int hang = matrix.length;
        if(hang == 0) return new int[0];
        int lie = matrix[0].length;
        boolean[][] isUsed = new boolean[hang][lie];
        int i = 0;
        int j = 0;
        int[] res = new int[hang*lie];
        int index = 0;
        if(hang == 1) {
            for(int k = 0; k < lie; k++) {
                res[k] = matrix[i][j];
                j++;
            }
            return res;
        }
        if(lie == 1) {
            for(int k = 0; k < hang; k++) {
                res[k] = matrix[i][j];
                i++;
            }
            return res;
        }
        while(!isUsed[i][j]) {
            while(j < lie && !isUsed[i][j]) {
                res[index] = matrix[i][j];
                isUsed[i][j] = true;
                index++;
                if(j >= lie-1 || isUsed[i][j+1]) {
                    i++;
                    break;
                }
                j = j+1;
            }

            while(i < hang && !isUsed[i][j]) {
                res[index] = matrix[i][j];
                isUsed[i][j] = true;
                index++;
                if(i >= hang-1 || isUsed[i+1][j]) {
                    j--;
                    break;
                }
                i = i+1;
            }

            while(j >= 0 && !isUsed[i][j]) {
                res[index] = matrix[i][j];
                isUsed[i][j] = true;
                index++;
                if(j <= 0 || isUsed[i][j-1]) {
                    i--;
                    break;
                };
                j = j-1;
            }
            while(i >= 0 && !isUsed[i][j]) {
                res[index] = matrix[i][j];
                isUsed[i][j] = true;
                index++;
                if(i <= 0 || isUsed[i-1][j]) {
                    j++;
                    break;
                }
                i = i-1;
            }
        }
        return res;
    }


    //dbs,不能这么用
    public void yxzs(int[][] matrix, boolean[][] isUsed, int i, int j, int[] res, int index) {
        if(i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0) {
            return;
        }
        if(isUsed[i][j]) {
            return;
        }
        res[index] = matrix[i][j];
        index++;
        isUsed[i][j] = true;
        yxzs(matrix,isUsed,i,j+1,res,index);
        yxzs(matrix,isUsed,i+1,j,res,index);
        yxzs(matrix,isUsed,i,j-1,res,index);
        yxzs(matrix,isUsed,i-1,j,res,index);
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{1},{2},{3}};
        Work1 a = new Work1();
        int[] res = a.spiralOrder(matrix);
        System.out.println(Arrays.toString(res));
    }

}
