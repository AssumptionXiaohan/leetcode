/**
 * Created by 79300 on 2019/7/4.
 * 双指针法，左边和右边走到元音就交换即可
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {

        if (s == null || s.length() == 0) return "";

        char[] charArray = s.toCharArray();
        //两个指针从数组开头和结尾走
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //跳过非元音的字母，检查边界条件
            while (left < s.length() && !isVowel(charArray[left])) left++;
            while (right >= 0 && !isVowel(charArray[right])) right--;
            //left>=right说明已经替换完所有元音了
            if (left >= right) return String.valueOf(charArray);
            //替换这两个位置的原因，左右指针再往中间走一步
            swap(charArray, left, right);
            left++;
            right--;
        }
        return String.valueOf(charArray);
    }


    private void swap(char[] charArray, int idx1, int idx2) {
        char temp = charArray[idx1];
        charArray[idx1] = charArray[idx2];
        charArray[idx2] = temp;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString rv = new ReverseVowelsOfAString();
        System.out.println(rv.reverseVowels("hello"));
    }
}
