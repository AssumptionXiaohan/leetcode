import java.util.*;

/**
 * Created by 79300 on 2019/10/19.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 0;
        Set<String> wordlist = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) return step;
                for (int k = 0; k < current.length(); k++) {
                    for (char j = 'a'; j >= 'a' && j <= 'z'; j++) {
                        StringBuilder s = new StringBuilder(current);
                        s.setCharAt(k, j);
                        if (wordlist.contains(s.toString())&&!visited.contains(s.toString())) {
                            queue.offer(s.toString());
                            visited.add(s.toString());
                        }
                    }
                }
            }
        }
        return 0;
    }
}
