/**
 * Created by 79300 on 2019/7/13.
 * 把从大到小的数字和字符串对应起来，然后从大的数字开始遍历即可
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String romans[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(romans[i]);
                num = num - values[i];
            }
        }
        return sb.toString();
    }
}
