import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by 79300 on 2019/7/7.
 * 先用一个hashmap把排序后的数组和一堆anagrams对应起来
 * abe :(abe,aeb,bae,bea)类似这样
 * 然后return value这部分
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hashMap= new HashMap<>();
        for(String str :strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            //把sort之后的string当作key处理
            if(!hashMap.containsKey(String.valueOf(temp))){
                hashMap.put(String.valueOf(temp),new ArrayList<>());
            }
            hashMap.get(String.valueOf(temp)).add(str);
        }
        //最后这个return values的语法需要注意一下
        return new ArrayList<>(hashMap.values());
    }
}
