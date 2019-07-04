import java.util.HashMap;
import java.util.Map;

/**
 * Created by 79300 on 2019/7/4.
 *
 * 用两个hashmap把string和index对应起来
 String 1:              A B E A C D B
 index pattern:         0 1 2 0 4 5 1
 String 2:              X Y I X H K Y
 index pattern:         0 1 2 0 4 5 1
 */
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        if (s.length() == 0 && t.length() == 0) return true;
        Map<Character, Integer> s_hashmap = new HashMap<>();
        Map<Character, Integer> t_hashmap = new HashMap<>();
        char[] firstString = s.toCharArray();
        char[] secondString = t.toCharArray();
        for (int i = 0; i < firstString.length; i++) {
            //当这一对character已经有映射关系的时候，检验和之前的是否一致，不一致返回false
            if (s_hashmap.containsKey(firstString[i]) && t_hashmap.containsKey(secondString[i])) {
                if (s_hashmap.get(firstString[i]) != t_hashmap.get(secondString[i])) return false;
                //没有映射关系的时候添加映射关系
            } else if (!s_hashmap.containsKey(firstString[i]) && !t_hashmap.containsKey(secondString[i])) {
                s_hashmap.put(firstString[i],i);
                t_hashmap.put(secondString[i],i);
            }else {
                //只有一个元素有映射关系，说明之前已经映射过了，不能再映射另外一个元素，返回false
                return false;
            }
        }
        return true;
    }
}
