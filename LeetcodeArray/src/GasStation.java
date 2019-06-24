/**
 * Created by 79300 on 2019/6/24.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0; //记录最后满足条件的出发点
        int remain = 0; //记录当前车子剩余油量
        int debt = 0; //记录之前所有的欠下的油量，也就是cost>gas的部分
        for (int i = 0; i < gas.length; i++) {
            remain = remain + gas[i] - cost[i];
            if (remain < 0) {
                //更新debt的值，把前一段路欠下的油量加上
                debt = debt - remain;
                //把i+1作为新出发点
                start = i + 1;
                //开始新的一段，更新remain的值
                remain = 0;
            }
        }
        if (remain >= debt) return start;
        else return -1;
    }
}
