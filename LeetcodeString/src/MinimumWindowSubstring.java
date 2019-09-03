import java.util.HashMap;
import java.util.Map;

/**
 * Created by 79300 on 2019/8/8.
 * l指针和r指针固定窗口，r往右移动直到窗口符合条件后
 * l继续往右移动直到窗口不符合条件
 * 再移动r，重复上面两步即可
 * 这里的符合条件是指窗口里包含t字符串里的所有字符
 */
public class MinimumWindowSubstring {
/*    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        //用一个hashmap存储t里所有字符的次数，用来后面判断窗口是否符合条件
        Map<Character, Integer> t_map = new HashMap<>();
        //遍历t把字符的出现次数存进t_map
        for (int i = 0; i < t.length(); i++) {
            int count = t_map.getOrDefault(t.charAt(i), 0);
            t_map.put(t.charAt(i), count + 1);
        }

        //左右指针和一个记录窗口结果的数组
        //ans[0]表示目前最小的窗口大小，ans[0]==-1表示没有找到合适的窗口
        int left = 0, right = 0;
        int[] ans = {-1, left, right};

        //一个记录当前窗口的hashmap，判断当前窗口是否包含了t字符串里的所有字符
        Map<Character,Integer> window_map = new HashMap<>();

        //移动right并判断窗口是否符合条件
        while (right < s.length()) {
            //移动right然后把新一个进入窗口的元素存到window_map里
            int count = window_map.getOrDefault(s.charAt(right),0);
            window_map.put(s.charAt(right),count+1);
            //判断当前窗口里的元素是不是符合条件的
            

            //移动left指针，看看是否能找到符合条件的更小的窗口
            while (left<right){

            }
        }

    }*/
}
