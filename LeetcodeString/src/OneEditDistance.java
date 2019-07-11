
/**
 * Created by 79300 on 2019/7/7.
 * 分几种情况来考虑!!情况比较多，不要漏掉
 * 这里的空间复杂度是O(N)
 * 因为String是immutable的，所以每次substring操作都会生成一个新的string
 * a b
 * a D b
 * <p>
 * a b c
 * a b d
 * <p>
 * ab
 * abc
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        //保证s的长度比t短
        if (t.length() < s.length()) return isOneEditDistance(t, s);
        //要是两个的length相差>=2说明肯定不是one edit distance
        if (t.length() - s.length() >= 2) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                //abcde abdde这种情况:长度相等，中间有一个字母不一样
                if (s.length() == t.length())
                    return s.substring(i + 1).equals(t.substring(i + 1));
                    //长度相差1的情况，t比s中间多出了一个字母，比较剩下的字符串 ab aDb
                else
                    return s.substring(i).equals(t.substring(i + 1));
            }
        }
        //剩下的是两个字符串前面一段都相等，只剩下一种末尾多出一个字母的情况
        return t.length() - s.length() == 1;
    }
}
