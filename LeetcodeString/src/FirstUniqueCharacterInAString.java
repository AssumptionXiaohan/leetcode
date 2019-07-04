import java.util.HashMap;
import java.util.Map;

/**
 * Created by 79300 on 2019/7/3.
 * 主要思路是记下26个字母每个字母出现的次数
 * 再遍历一遍 return第一个出现字数为1的字母
 * 要用到ASCII码的比较
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] count_char = new int[26];
        //先遍历一遍把所有字母的出现次数记录下来
        for(int i=0;i<s.length();i++){
            //-'a'的操作成功把字母a和index0对应起来，b和index1..以此类推
            count_char[s.charAt(i)-'a']++;
        }

        //返回第一个出现次数为1的字母
        for(int i=0;i<s.length();i++){
            if(count_char[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
