/**
 * Created by 79300 on 2019/9/9.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0, newResult = 0;
        while (x != 0) {
            int tail = x % 10;
            newResult = result * 10 + tail;
            //deal with overflow
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-102));
    }
}
