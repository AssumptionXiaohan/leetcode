/**
 * Created by 79300 on 2019/9/30.
 * https://www.youtube.com/watch?v=HWJEMKWzy-Q
 * 动态规划DP
 * <p>
 * init: [0] = 1 [1] = 1
 * func:求和j从0到k-1：[j]*[n-j-1]
 * result: k
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int num[] = new int[n+1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                num[i] = num[i] + num[j] * num[i - j - 1];
            }
        }
        return num[n];
    }
}
