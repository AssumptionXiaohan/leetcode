import java.util.HashMap;
import java.util.Map;

/**
 * Created by 79300 on 2019/7/13.
 * 双指针加一个hashmap
 * 其实左右开始配对就可以
 * 只有这几对是可以的 69  96  00 88 11
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put('0', '0');
        hashMap.put('1', '1');
        hashMap.put('6', '9');
        hashMap.put('9', '6');
        hashMap.put('8', '8');

        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!hashMap.containsKey(num.charAt(left)) || !hashMap.containsKey(num.charAt(right))) return false;
            if (hashMap.get(num.charAt(left)) != num.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
