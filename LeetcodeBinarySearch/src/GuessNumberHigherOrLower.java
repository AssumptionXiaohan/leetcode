/**
 * Created by 79300 on 2019/10/7.
 */
public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        if (n <= 0) return -1;
        int low = 1, high = n;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == -1) high = mid;
            else low = mid;
        }
        return guess(low) == 0 ? low : high;
    }
}
