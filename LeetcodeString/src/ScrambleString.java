import java.util.Arrays;

/**
 * Created by 79300 on 2019/7/7.
 * 这题需要用递归的思路解决，下面的视频很有帮助：
 * https://www.youtube.com/watch?v=Lq3Kr7-qXGI
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() == 1 && s1.equals(s2)) return true;
        //加速运行时间，假设s1和s2里元素都不完全一样的话，直接return false
        char[] s1_char = s1.toCharArray();
        char[] s2_char = s2.toCharArray();
        Arrays.sort(s1_char);
        Arrays.sort(s2_char);
        String sorted_s1 = new String(s1_char);
        String sorted_s2 = new String(s2_char);
        if (!sorted_s1.equals(sorted_s2)) return false;
        //下面这个for循环，先把string分成两个part，然后比较两个part之间是否是scramble的关系
        for (int i = 1; i < s1.length(); i++) {
            String s1_left = s1.substring(0,i), s1_right = s1.substring(i,s1.length());
            String s2_left = s2.substring(0,i), s2_right = s2.substring(i,s2.length());
            if(isScramble(s1_left,s2_left)&&isScramble(s1_right,s2_right)||
                    //这里比较s1_left和s2_right的时候要保证s2_right的元素个数和s1_left相等，都为i
                    //比较s1_right和s2_left的时候也要保证s2_left的元素和s1-right的元素相等
                    (isScramble(s1_left,s2.substring(s2.length()-i,s2.length()))&&isScramble(s1_right,s2.substring(0,s2.length()-i))))
                return true;
        }
        return false;
    }
}
