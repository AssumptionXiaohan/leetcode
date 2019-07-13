/**
 * Created by 79300 on 2019/7/12.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int n = s.length() - 1, result = 0;
        for (char c : s.toCharArray()) {
            //相当于A-1，B-2... A*26^n-1+B*26^n-2+...
            result = result + (c - 'A' + 1) * (int) Math.pow(26, n);
            n = n - 1;
        }
        return result;
    }
}
