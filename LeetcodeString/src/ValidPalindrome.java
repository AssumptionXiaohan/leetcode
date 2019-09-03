/**
 * Created by 79300 on 2019/8/20.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (left < right) {
            while (!Character.isLetterOrDigit(charArray[left])&&left<right) left++;
            while (!Character.isLetterOrDigit(charArray[right])&&right>left) right--;
            if(left==right) return true;
            if (!isEqual(charArray[left], charArray[right])) return false;
            left++;
            right--;
        }
        return true;
    }

    private boolean isEqual(char c1, char c2) {
        return String.valueOf(c1).toLowerCase().equals(String.valueOf(c2).toLowerCase());
    }

}
