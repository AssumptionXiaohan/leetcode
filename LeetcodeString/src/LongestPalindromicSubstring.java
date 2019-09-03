/**
 * Created by 79300 on 2019/9/2.
 * 这个youtube真的讲的超级好！！
 * https://www.youtube.com/watch?v=pi7ttqr1MT4
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) return s;
        boolean isPalindrome[][] = new boolean[s.length()][s.length()];
        int length = 1, start = 0;
        //一个字母的都是palindrome
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        //两个字母的话只有相等才是palindrome
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) isPalindrome[i][i + 1] = false;
            else {
                isPalindrome[i][i + 1] = true;
                length = 2;
                start = i;
            }
        }
        //i表示现在这个循环里在找的字串长度
        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j + i - 1 < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + i - 1)&&isPalindrome[j+1][j+i-2]){
                    isPalindrome[j][j + i - 1] = true;
                    length = i;
                    start = j;
                }
                else isPalindrome[j][j+i-1] = false;
            }
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("abcda"));
    }
}
