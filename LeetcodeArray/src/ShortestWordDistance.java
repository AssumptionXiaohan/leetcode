/**
 * Created by 79300 on 2019/6/25.
 * 主要思路就是，不需要循环遍历这两个词所有出现的地方
 * 只需要存储两个词最近一次的出现位置即可
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int word1_idx = -1, word2_idx = -1;
        int min_distance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1_idx = i;
            } else if (words[i].equals(word2)) {
                word2_idx = i;
            }
            if (word1_idx != -1 && word2_idx != -1)
                min_distance = Math.min(min_distance, Math.abs(word1_idx - word2_idx));
        }
        return min_distance;
    }

    public static void main(String[] args) {
        ShortestWordDistance swd = new ShortestWordDistance();
        System.out.println(swd.shortestDistance(
                new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
    }
}
