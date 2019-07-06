import java.util.HashMap;
import java.util.Map;

/**
 * Created by 79300 on 2019/7/6.
 * 判断字符串里的每个字符和第二个字符串里的word的pattern是否一致
 * 用两个hashmap把他们和index分别对应起来
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        if (word.length != pattern.length()) return false;
        Map<Character, Integer> hashMap = new HashMap<>();
        Map<String, Integer> string_hashmap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            //同时都有这个key存在，判断对应的index是否一致，不一致就是false
            if (hashMap.containsKey(pattern.charAt(i)) && string_hashmap.containsKey(word[i])) {
                if (!hashMap.get(pattern.charAt(i)).equals(string_hashmap.get(word[i]))) return false;
                //同时不存在，加入hashmap
            } else if (!hashMap.containsKey(pattern.charAt(i)) && !string_hashmap.containsKey(word[i])) {
                hashMap.put(pattern.charAt(i), i);
                string_hashmap.put(word[i], i);
                //只有一个存在key，肯定是不一致的，返回false
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
                "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));
    }
}
