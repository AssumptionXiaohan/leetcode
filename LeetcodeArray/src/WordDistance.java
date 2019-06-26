import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 79300 on 2019/6/26.
 * Multipul query的问题通常都要涉及precomputation
 * 要在query之前做一些处理，不能在每次query的时候都要整个循环一遍，效率很低
 * 如果query的数量真的很多，可以考虑做一个cache，把已经query过的结果存起来
 */
public class WordDistance {
    //用hashmap把数组里每一个信的值作为key，它出现的所有index作为value存起来
    //之后只需要对index的list进行遍历即可
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                map.put(words[i], lst);
            }
        }
    }

    //因为是两个有序的List<Integer>，所以可以采用双指针法 O(m+n)或者一边遍历一边二分查找O(m*logn)
    public int shortest(String word1, String word2) {
        int min_path = Integer.MAX_VALUE;
        List<Integer> word1_idxes = map.get(word1);
        List<Integer> word2_idxes = map.get(word2);
        for (int word1_idx = 0, word2_idx = 0; word1_idx < word1_idxes.size() && word2_idx < word2_idxes.size(); ) {
            min_path = Math.min(min_path, Math.abs(word1_idxes.get(word1_idx) - word2_idxes.get(word2_idx)));
            if (word1_idxes.get(word1_idx) < word2_idxes.get(word2_idx))
                word1_idx++;
            else word2_idx++;
        }
        return min_path;
    }
}
