import java.util.*;

/**
 * Created by 79300 on 2019/10/17.
 * 把wordList转成hashset会更方便查找
 * 先用BFS从begin到end找到minLength，同时记录一个Map<String,length>标记每个String到begin的距离
 * 再用DFS从end到begin,用minLength和Map里的length的条件进行剪枝
 */
public class WordLadderII {

    Map<String,Integer> step_dict = new HashMap<>();


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int length = 0;
        while (!queue.isEmpty()){
            length++;
            int size = queue.size();
            while (size>0){
                String temp = queue.poll();
                
                size--;
            }
        }



    }




}
