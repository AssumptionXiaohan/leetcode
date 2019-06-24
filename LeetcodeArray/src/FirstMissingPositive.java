/**
 * Created by 79300 on 2019/6/20.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {


    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        System.out.println(fmp.firstMissingPositive(new int[]{9,-1,3,4,1,7,6}));
    }

}