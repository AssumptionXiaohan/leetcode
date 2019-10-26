/**
 * Created by 79300 on 2019/10/26.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //初始化
        for(int i=1;i<word1.length()+1;i++){
            dp[i][0] = i;
        }

        for(int j=1;j<word2.length()+1;j++){
            dp[0][j] = j;
        }
        //状态转移方程
        for(int i=1;i<word1.length()+1;i++){
            for(int j=1;j<word2.length()+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }
}
