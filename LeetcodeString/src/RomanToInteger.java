/**
 * Created by 79300 on 2019/7/12.
 * 这题的思路是先把每个符号代替的数字填在int数组对应的地方
 * 如果是IX就+X-I这样计算
 * 判断当前字符对应的值如果比后一个值小就需要减去当前值，反之加上当前值
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        char[] char_array = s.toCharArray();
        int[] nums = new int[s.length()];
        for (int i = 0; i < char_array.length; i++) {
            switch (char_array[i]) {
                case 'I':
                    nums[i] = 1;
                    break;
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) result = result + nums[i];
            else result = result - nums[i];
        }
        //最后补上for循环没有cover到的最后一位，肯定是做加法操作
        result = result + nums[nums.length - 1];
        return result;
    }
}
