import java.util.*;

/**
 * Created by 79300 on 2019/10/17.
 * 把wordList转成hashset会更方便查找
 * 先用BFS从begin到end找到minLength，同时记录一个Map<String,length>标记每个String到begin的距离
 * 再用DFS从end到begin,用minLength和Map里的length的条件进行剪枝
 */

public class WordLadderII {
    //String, String下一层可以到达的所有String的List
    Map<String, List<String>> next_level_dict = new HashMap<>();
    //String, String到beginword的最短距离
    Map<String, Integer> step_dict = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        buildMap(wordList,beginWord);
        int minLength = bfs(beginWord,endWord);
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        LinkedList<String> current = new LinkedList<>();
        current.add(endWord);
        visited.add(endWord);
        dfs(endWord,beginWord,minLength,result,current,visited);
        return result;
    }

    // 计算beginword和wordList里的所有的String的下一level的结点，构建next_level_dict
    // Map<String, List<String>> next_level_dict
    private void buildMap(List<String> wordList, String beginword) {
        Set<String> hashset = new HashSet<>(wordList);
        hashset.add(beginword);
        //把每一个string对应的下一level结点对应起来
        for (String str : hashset) {
            next_level_dict.put(str, new ArrayList<>());
            //对其中的一个string的每一个char进行从a到z的改变，并判断是否在wordlist中
            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder(str);
                for (char j = 'a'; j <= 'z'; j++) {
                    //避免把自己添加到list里
                    if (j != str.charAt(i)) {
                        sb.setCharAt(i,j);
                        if(hashset.contains(sb.toString())){
                            next_level_dict.get(str).add(sb.toString());
                        }
                    }
                }
            }
        }
    }

    // 从beginWord到endWord进行bfs,同时记录经过的结点到beginWord的距离，存在step_dict
    // 找到最短距离的时候返回最短距离 (仅标记了距离beginWord距离<=最短距离的结点，方便DFS中的剪枝)
    // Map<String, Integer> step_dict
    private int bfs(String beginWord,String endWord){
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //这里可以把step_dict直接当visited用
        step_dict.put(beginWord,0);
        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            while (size > 0) {
                String current = queue.poll();
                if(current.equals(endWord)) return length;
                for(String str:(next_level_dict.get(current))){
                    if(!step_dict.containsKey(str)){
                        queue.offer(str);
                        step_dict.put(str,length);
                    }
                }
                size--;
            }
        }
        return 0;
    }

    //从endWord到beginWord开始进行dfs,一些剪枝操作：
    //1.要是当前的size已经大于minlength结束递归，要是当前size等于minlength但不是正确结果结束递归，是正确结果添加到结果集
    //2.要是当前的size小于minlength，通过step_dict进行剪枝，必须是step_dict里有的结点，且step+当前的size<=minLength才继续递归下去
    private void dfs(String current,String target, int minLength, List<List<String>> result,LinkedList<String> currentList,Set<String> visited){
        if(currentList.size()>minLength) return;
        else if(currentList.size()==minLength){
            if(currentList.get(0).equals(target)){
                result.add(new ArrayList<>(currentList));
            }else return;
            //currentList.size<minLength
        }else{
            for(String str:next_level_dict.get(current)){
                if(!visited.contains(str)&&step_dict.containsKey(str)&&step_dict.get(str)+currentList.size()<=minLength){
                    currentList.addFirst(str);
                    visited.add(str);
                    dfs(str,target,minLength,result,currentList,visited);
                    //backtracking
                    currentList.removeFirst();
                    visited.remove(str);
                }
            }
        }
    }
}
