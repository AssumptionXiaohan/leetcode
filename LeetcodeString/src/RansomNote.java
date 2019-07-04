/**
 * Created by 79300 on 2019/7/3.
 * 这题和first unique character in a string很像
 * 都是先把所有字母的出现次数count一遍
 * 然后来看看是否符合条件
 * <p>
 * 这里ransomNote里的字母出现一次就count--，然后出现count<0的情况就return false
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count_char = new int[26];
        // 把magazine里的字母和出现次数记录下来
        for (int i = 0; i < magazine.length(); i++) {
            count_char[magazine.charAt(i) - 'a']++;
        }

        // ransomNote里出现一次字母就把该字母在magazine里的count--
        // 如果减到负数了说明magazine里缺少这个字母,return false
        for (int i = 0; i < ransomNote.length(); i++) {
            count_char[ransomNote.charAt(i)-'a']--;
            if(count_char[ransomNote.charAt(i)-'a']<0) return false;
        }
        return true;
    }
}
