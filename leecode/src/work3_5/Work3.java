package work3_5;

/**
 * Created with IntelliJ IDEA.
 * Description:二维数组中的查找
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * User: starry
 * Date: 2021 -03 -05
 * Time: 16:18
 */
public class Work3 {

    //暴力求法
    public boolean Find(int target, int [][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                if(array[i][j] == target) return true;
            }
        }
        return false;
    }

    //超级二分法
    public boolean Find1(int target, int [][] array) {
        if(array == null || array.length == 0) return false;
        int rows = array.length;
        int cols = array[0].length;
        int i=rows-1,j=0;
        while(i>=0 && j<cols){
            if(target<array[i][j])
                i--;
            else if(target>array[i][j])
                j++;
            else
                return true;
        }
        return false;
    }

}
