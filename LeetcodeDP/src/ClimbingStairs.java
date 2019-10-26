/**
 * Created by 79300 on 2019/10/26.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=0) return -1;
        if(n==1) return 1;
        int dp[] = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<dp.length;i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
