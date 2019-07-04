/**
 * Created by 79300 on 2019/7/3.
 * 用last_word来记录最后一个word的长度
 * 每遇到一个空格更新一次值直到最后一个word被更新完
 * 如果是最后以空格结尾的情况要返回word的值，不能更新
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int last_word = 0;
        for (int i = 0; i < s.length(); i++) {
            while (s.charAt(i) == ' ') {
                //假设到最后也是空格，直接return，其他情况跳过空格
                if (i == s.length() - 1) return last_word;
                i++;
            }
            //判断前一个元素是否是空格，如果是说明开始了一个新word，不是的话说明还在一个word里，word++
            if (i - 1 >= 0 && s.charAt(i - 1) == ' ') last_word = 1;
            else last_word++;
        }
        return last_word;
    }
}
