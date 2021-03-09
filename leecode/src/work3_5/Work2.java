package work3_5;

/**
 * Created with IntelliJ IDEA.
 * Description:旋转数组的最小数字
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * User: starry
 * Date: 2021 -03 -05
 * Time: 15:29
 */
public class Work2 {

    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        int mid = -1;
        while(left < right) {
            mid = (left+right)/2;
            if(array[mid] >= array[left]) {
                left = mid;
            }
            if(array[mid] <= array[right]) {
                right = mid;
            }
            if(right-left == 1) return array[right];
        }
        return -1;
    }

}
