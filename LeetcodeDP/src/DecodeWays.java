/**
 * Created by 79300 on 2019/10/26.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            int current = s.charAt(i - 1) - '0';
            int left = s.charAt(i - 2) - '0';
            //如果当前是0的话，因为0不能单独decode，所以不能加上dp[i-1]的值了
            //如果当前和之前一个字符组成的数字不是有效的数字(1-26) 那么不可以加上dp[i-2]的值了
            //有效数字判断条件:>0 <=26且不能以0开头（如01,02，03这样也是无效的
            dp[i] = (current == 0 ? 0 : dp[i - 1]) + ((left != 0 && left * 10 + current <= 26 && left * 10 + current > 0) ? dp[i - 2] : 0);
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        dw.numDecodings("12");
    }
}
