/**
 * Created by 79300 on 2019/7/3.
 * for循环找就可以了
 * 主要是判断边界条件：
 * neddle为空的时候直接return 0
 * needle比haystack大或者haystack为空（needle不为空）的情况下return -1
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        else if (haystack.isEmpty() || needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            //substring是[a,b)不包括b在内的
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr is = new ImplementStrStr();
        System.out.println(is.strStr("hello", "ll"));
    }
}
