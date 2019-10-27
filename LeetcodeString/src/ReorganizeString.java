import java.util.*;

/**
 * Created by 79300 on 2019/10/26.
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        Map<Character,Integer> hashMap = new HashMap<>();
        char[] chars = S.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(hashMap.containsKey(chars[i])){
                hashMap.put(chars[i],hashMap.get(chars[i])+1);
            }else{
                hashMap.put(chars[i],1);
            }
        }
        Queue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>(){
            @Override
            public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2){
                return o2.getValue()-o1.getValue();
            }
        });
        for(Map.Entry<Character,Integer> entry:hashMap.entrySet()){
            pq.offer(entry);
        }
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
            int size = pq.size();
            if(size>=2){
                Map.Entry<Character,Integer> first = pq.poll();
                Map.Entry<Character,Integer> second = pq.poll();
                result.append(first.getKey());
                result.append(second.getKey());
                if(first.getValue()>1){
                    first.setValue(first.getValue()-1);
                    pq.offer(first);
                }
                if(second.getValue()>1){
                    second.setValue(second.getValue()-1);
                    pq.offer(second);
                }
            }else if(size==1){
                Map.Entry<Character,Integer> temp = pq.poll();
                if(temp.getValue()>1){
                    return "";
                }else{
                    result.append(temp.getKey());
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReorganizeString rs = new ReorganizeString();
        rs.reorganizeString("aab");
    }
}
