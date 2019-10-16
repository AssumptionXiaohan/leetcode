import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by 79300 on 2019/10/15.
 * 见pad的笔记
 * 其实是先竖着找能把所有=1的点分割成一半一半的那一列，再横着找能把所有=1的点分成一半一半的那一行
 * 计算distance的时候其实tail-head就是他们俩到median的距离之和
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xIdx = new ArrayList<>();
        List<Integer> yIdx = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xIdx.add(i);
                    yIdx.add(j);
                }
            }
        }
        return totalDis(xIdx) + totalDis(yIdx);

    }

    private int totalDis(List<Integer> idx) {
        Collections.sort(idx);
        int head = 0, tail = idx.size() - 1;
        int result = 0;
        //如果是偶数的话一对一对算完，如果是奇数的话中间那个就是最优点不需要考虑，因为到本身的距离为0
        while (head < tail) {
            result = result + idx.get(tail) - idx.get(head);
            tail--;
            head++;
        }
        return result;
    }


}
