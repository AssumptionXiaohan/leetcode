import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/7/12.
 * 在encode的时候每个字符串前面加上字符串长度+'/'
 */
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int length = s.length();
            sb.append(length + "/" + s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int current_index = 0;
        while (current_index < s.length()) {
            int slash = s.indexOf((int) '/', current_index);
            int length = Integer.parseInt(s.substring(current_index, slash));
            String current_string = s.substring(slash + 1, slash + length + 1);
            current_index = slash + length + 1;
            result.add(current_string);
        }
        return result;
    }
}
