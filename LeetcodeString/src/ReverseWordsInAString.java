/**
 * Created by 79300 on 2019/7/4.
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 有一个更好写的方法
 * 先把整个数组里的空格全部去掉（开头结尾空格全部去掉，word中间规范为1个空格
 * 然后把整个数组翻转过来
 * 再把数组里每个word翻转一遍
 */
public class ReverseWordsInAString {


    public String reverseWords(String s) {
        String result = "", word = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            //跳过所有空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            //说明前几个都是空格了直接出去到return
            if (i == -1) break;
            //假设后面一个有字母的情况，说明是一个word，加在temp前面
            //这里i+1可能会超出，如果i是最后一个元素的话也要加在temp前面（前面的while循环保证了这个时候不会是空格
            if ((i + 1 < s.length() && s.charAt(i + 1) != ' ') || i + 1 == s.length()) {
                word = s.charAt(i) + word;
            } else {
                //这里的情况是要开始一个新的word了
                //temp有可能是空的这样会多加一个空格，所以需要一个判断
                if (word != "") result = result + word + " ";
                word = "" + s.charAt(i);
            }
        }
        result = result + word;
        return result;
    }
}
