/**
 * Created by 79300 on 2019/7/12.
 * 题目意思比较难懂可以看看discuss区的解释
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 0) return null;
        //n=1的时候默认是1
        String result = "1";
        //生成n-1次新的字符串
        for (int i = 1; i < n; i++) {
            result = nextString(result);
        }
        return result;
    }

    public String nextString(String s) {
        int count = 1;
        char current_char = s.charAt(0);
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                result = result + String.valueOf(count) + current_char;
                current_char = s.charAt(i + 1);
                count = 1;
            }
        }
        //这里加上最后一个!!
        result = result + String.valueOf(count) + current_char;
        return result;
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        System.out.println(cs.countAndSay(1));
    }
}
