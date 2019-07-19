/**
 * Created by 79300 on 2019/7/19.
 * int read4(char[] buf);
 */
public class ReadNCharactersGivenRead4 extends Reader4 {
    public int read(char[] buf, int n) {
        int count = 0;
        boolean isEnd = false;
        char[] temp = new char[4];
        while (!isEnd && count < n) {
            //先读4个字符或者末尾的几个字符出来
            int charNo = read4(temp);
            //已经读到末尾的话把isend设置为true
            if (charNo < 4) isEnd = true;
            //这里决定了接下来是读4个还是读n-count个，有可能读4个就超过n的范围了
            charNo = Math.min(charNo, n - count);
            //把这一次读的内容存到buf里
            for (int i = 0; i < charNo; i++) {
                buf[count] = temp[i];
                count++;
            }
        }
        return count;
    }

}
