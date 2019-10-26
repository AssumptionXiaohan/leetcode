/**
 * Created by 79300 on 2019/10/26.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        //[0][0]是true，第一行剩下的都是false
        dp[0][0] = true;
        //第一列，考虑*的情况可能能匹配空字符串
        for(int i=1;i<p.length()+1;i++){
            if(p.charAt(i-1)=='*'){
                dp[i][0] = dp[i-2][0];
            }
        }

        for(int i=1;i<p.length()+1;i++){
            for(int j=1;j<s.length()+1;j++){
                if(p.charAt(i-1)==s.charAt(j-1)||p.charAt(i-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(i-1)=='*'){
                    //0个或多个
                    dp[i][j]=dp[i-2][j]||(dp[i][j-1]&&(p.charAt(i-2)==s.charAt(j-1)||p.charAt(i-2)=='.'));
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
