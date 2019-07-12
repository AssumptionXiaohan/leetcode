/**
 * Created by 79300 on 2019/7/12.
 * 这题还挺巧的。。一开始就在不停的分类其实好像没有必要~
 * 主要是'A'对应的值是1，但在int和char的映射关系里其实应该对应0
 * 所以首先要进行一个n--的操作
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n == 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) ('A' + n % 26));
            n = n / 26;
        }
        //因为其实是从个位开始append的所以最后要翻转过来
        return sb.reverse().toString();
    }
}
