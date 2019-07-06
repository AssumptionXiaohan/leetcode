import java.util.Hashtable;

/**
 * Created by 79300 on 2019/7/6.
 * 也是count每一个字母出现次数的原则，如果每个字母在s和t里出现的次数都相等就返回true
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]!=0) return false;
        }
        return true;
    }

}
