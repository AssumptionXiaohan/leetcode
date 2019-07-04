/**
 * Created by 79300 on 2019/7/4.
 * 把左半边位置和右半边位置对应的元素换过来就可以了
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
