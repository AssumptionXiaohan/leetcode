import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/7/6.
 * 利用substring存下可以翻转的两个位置的前后的substring
 * 然后和"--"组成新的string添加到结果集
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String current_string = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                lst.add(current_string);
            }
        }
        return lst;
    }
}
