import java.util.Comparator;

/**
 * Created by 79300 on 2019/10/26.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
            int k=1;
            while(i>=k*k){
                dp[i] = Math.min(dp[i],dp[i-k*k]+1);
                k = k+1;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        ps.numSquares(12);
    }
}
