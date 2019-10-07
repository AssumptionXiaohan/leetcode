/**
 * Created by 79300 on 2019/10/7.
 */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 0 || n == 1) return n;
        int low = 1, high = n, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
