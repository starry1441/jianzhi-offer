package work3_15;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:机器人的运动范围（广度优先遍历）BFS
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * User: starry
 * Date: 2021 -03 -15
 * Time: 15:16
 */

//广度优先遍历BFS
public class Work2 {

    public int movingCount(int m, int n, int k) {
        boolean[][] isUsed = new boolean[m][n]; //走过的格子为true
        Queue<int[]> queue = new LinkedList<>();//队列来放格子的x和y下标
        queue.offer(new int[]{0,0});    //给队列放最左上角的格子
        isUsed[0][0] = true;    //左上角格子置为走过的格子
        int count = 1;  //用来计数可以走的格子数
        int[] addx = {0, 1};    //用来向右移动
        int[] addy = {1, 0};    //用来向下移动
        //出循环条件：队列为空
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();   //出队并记录此格子位置
            //依次遍历此格子的右格子和下格子
            //i==0 遍历右格子
            //i==1 遍历下格子
            for(int i = 0; i < 2; i++) {
                int x = arr[0] + addx[i];   //让x下标走动
                int y = arr[1] + addy[i];   //让y下标走动
                //如果走后的格子为以下条件，则这个格子不能走到，自然不能入队
                //1.该位置越界
                //2.该位置超过k条件
                //3.该位置已经走过了
                if(x < 0 || x > m-1 || y < 0 || y > n-1 || sum(x)+sum(y) > k || isUsed[x][y]) {
                    continue;
                }
                //程序能走到这里，证明此位置可以走到，则让此位置入队
                queue.offer(new int[]{x,y});    //入队此格子
                isUsed[x][y] = true;    //此格子置为走过的格子
                count++;    //可以走的格子数加一
            }
        }
        //程序走到这，说明队列里已经没有了可以遍历的格子，最后返回可以走的格子数
        return count;
    }

    //返回该数所有位的和 例如123 返回1+2+3=6
    public int sum(int a) {
        int count = 0;
        while(a != 0) {
            count = count + a%10;
            a = a/10;
        }
        return count;
    }

}
