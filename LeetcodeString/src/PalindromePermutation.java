import java.util.HashMap;
import java.util.Map;

/**
 * Created by 79300 on 2019/9/1.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> hashmap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for(char c:charArray){
            hashmap.put(c,hashmap.getOrDefault(c,0)+1);
        }
        int result = 0;
        for(char key:hashmap.keySet()){
            result = result+hashmap.get(key)%2;
        }
        return result<=1;
    }
}
