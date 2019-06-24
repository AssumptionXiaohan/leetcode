/**
 * Created by 79300 on 2019/6/20.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            //元素已经在指定位置时，继续下一次遍历，避免死循环
            if (A[i] == i + 1) {
                i++;
                continue;
            }
            //当元素是符合要求的正数时调到应该的位置上
            //最后一个条件是为了避免[1,1]这种情况的死循环，需要先判断替换的位置上是否已经有相等的元素
            if (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1])
                swap(A, i, A[i] - 1);
            else i++;
        }
        //找到不满足条件的第一个正数即缺少的最小的正数
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) return j + 1;
        }
        return A.length + 1;
    }

    private void swap(int[] A, int first_idx, int second_idx) {
        int temp = A[first_idx];
        A[first_idx] = A[second_idx];
        A[second_idx] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        System.out.println(fmp.firstMissingPositive(new int[]{1, 1}));
    }

}