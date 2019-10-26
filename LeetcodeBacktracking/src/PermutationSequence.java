import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/25.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> numList = new ArrayList();
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = k / factorial[n - i - 1];
            sb.append(String.valueOf(numList.get(index)));
            numList.remove(index);
            k = k % factorial[n - i - 1];
        }
        return sb.toString();
    }
}
