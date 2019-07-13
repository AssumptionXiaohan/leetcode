import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 79300 on 2019/7/14.
 * 这题用递归-回溯法：
 */
public class StrobogrammaticNumberII {
    public int a;

    public List<String> findStrobogrammatic(int n) {
        a = n;
        return findStro(n);
    }

    private List<String> findStro(int n) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> last_lst = findStro(n - 2);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < last_lst.size(); i++) {
            String current_string = last_lst.get(i);
            if (n != a) result.add("0" + current_string + "0");
            result.add("1" + current_string + "1");
            result.add("8" + current_string + "8");
            result.add("6" + current_string + "9");
            result.add("9" + current_string + "6");
        }
        return result;
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII sg = new StrobogrammaticNumberII();
        sg.findStrobogrammatic(2);
    }
}
