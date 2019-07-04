/**
 * Created by 79300 on 2019/7/4.
 * 先把整个string翻过来，再把每个word翻过来
 * 这里有一个翻转char[]的某一个范围(idx1,idx2)函数会很方便！！
 */
public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                //这里i-1=-1的话不会报错，相当于什么也没做
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        //把最后一个word翻转过来，因为for循环里不会翻转最后一个word
        reverse(s,start,s.length-1);
    }


    //把s的(idx1,idx2)区间内的元素翻转过来
    private void reverse(char[] s, int idx1, int idx2) {
        while (idx1 < idx2) {
            char temp = s[idx1];
            s[idx1] = s[idx2];
            s[idx2] = temp;
            idx1++;
            idx2--;
        }
    }
}
