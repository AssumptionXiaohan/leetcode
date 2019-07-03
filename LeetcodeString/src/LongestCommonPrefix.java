/**
 * Created by 79300 on 2019/7/3.
 * startsWith() 方法用于检测字符串是否以指定的前缀开始,返回true或false
 * int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(pre)){
                pre = pre.substring(0,pre.length()-1);
            }
        }
        return pre;
    }
}
