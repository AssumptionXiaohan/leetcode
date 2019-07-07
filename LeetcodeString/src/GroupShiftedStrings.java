import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by 79300 on 2019/7/7.
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 * <p>
 * 和GroupAnagrams同样的思路，我们要找到和每个list对应的一个key
 * 这个key课可以选取为每一个字符的ascii码减去第一个字符的ascii码
 * abc、bcd、xyz 都对应012
 * az对应025 ba对应0 -1 这里-1的情况需要+26
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<>();
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strings) {
            char first_char = str.charAt(0);
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                int temp = str.charAt(i) - first_char;
                //这里是类似ba这种情况会出现负数，+26即可与其他一起判断
                if (temp < 0) temp = temp + 26;
                //后面加一个分隔符是为了避免出现12+5 和1+15这两个被判断相等的情况
                key = key + String.valueOf(temp) + ",";
            }
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<>());
            }
            hashMap.get(key).add(str);
        }
        //注意一下这个return的语法
        return new ArrayList<>(hashMap.values());
    }

}
