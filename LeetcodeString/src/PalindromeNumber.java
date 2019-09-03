/**
 * Created by 79300 on 2019/9/2.
 * https://www.youtube.com/watch?v=gA2gbZ0yQLE
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        //负数永远不可能是Palindrome
        if (x < 0) return false;
        //先得到对应的一个div数字 12121 对应10000  div表示最高位为1其他位都是0的数
        int div = 1;
        while (x / div >= 10) {
            div = div * 10;
        }
        //取数字的最左边一位和最右边一位判断是否相等
        while (x != 0) {
            int left = x / div;
            int right = x % 10;
            if(left!=right) return false;
            //更新x的值
            x = (x-left*div)/10;
            //更新div的值 每次减少两位
            div = div/100;
        }
        return true;
    }
}
