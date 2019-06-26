/**
 * Created by 79300 on 2019/6/26.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int word1_idx = -1, word2_idx = -1,min_path = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)){
                word1_idx = i;
            }
            if(words[i].equals(word2)){
                if(word1.equals(word2)){
                    word1_idx = word2_idx;
                }
                word2_idx = i;
            }
            if(word1_idx!=-1&&word2_idx!=-1){
                min_path = Math.min(min_path,Math.abs(word1_idx-word2_idx));
            }
        }
        return min_path;
    }
}
