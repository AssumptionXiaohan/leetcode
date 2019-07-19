/**
 * Created by 79300 on 2019/7/14.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean eSeen = false;
        boolean pointSeen = false;
        boolean numberSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);
            switch (current_char) {
                //.不能出现在.或者e后面
                //前面不一定非要有数字，".1"这种算true
                case '.':
                    if (eSeen || pointSeen) return false;
                    pointSeen = true;
                    //这里不需要把numberSeen设置为false是因为.后面可以不需要跟上number
                    //"1."这个是合法输入
                    break;
                //e前面一定要有数字，且不能有e
                case 'e':
                    if (!numberSeen || eSeen) return false;
                    eSeen = true;
                    //这里把numberSeen设置为false是为了开始找到e后面的number
                    //确保e后面一定要看到number 否则就return false
                    numberSeen = false;
                    break;
                //+ - 只能在最开始的位置或者在e的后面
                case '+':
                case '-':
                    if (i != 0 && s.charAt(i - 1) != 'e') return false;
                    numberSeen = false;
                    break;
                default:
                    if (current_char - '0' < 0 || current_char - '0' > 9) return false;
                    numberSeen = true;
            }
        }
        //至少看到了一个数字或者e后面要有数字
        return numberSeen;
    }
}
