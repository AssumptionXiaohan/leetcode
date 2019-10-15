/**
 * Created by 79300 on 2019/10/15.
 * 思路太强了..
 * 用一个help的数组，把每个startindex都存为要加的值，然后在endindex+1的地方存要加的值的负数
 * 这样最后的结果就可以用help的数组的前n个的和来计算。
 * helper[0,2,3,0,-5]:
 * <p>
 * sum[0] = res[0] = 0;
 * <p>
 * sum[1] = res[0] + res[1] = 0 + 2 = 2;
 * <p>
 * sum[2] = res[0] + res[1] + res[2] = 0 + 2 + 3 = 5;
 * <p>
 * sum[3] = res[0] + res[1] + res[2] + res[3] = 0 + 2 + 3 + 0 = 5;
 * <p>
 * sum[4] = res[0] + res[1] + res[2] + res[3] + res[4] = 0 + 2 + 3 + 0 + (-5) = 0;
 * <p>
 * sum[0,2,5,5,0]
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length == 0 || updates == null || updates.length == 0) return new int[length];
        int[] helper = new int[length];
        for (int[] update : updates) {
            helper[update[0]] += update[2];
            if (update[1] + 1 < length) helper[update[1] + 1] -= update[2];
        }
        int sum = 0;
        for(int i=0;i<helper.length;i++){
            sum = sum+helper[i];
            helper[i] = sum;
        }
        return helper;
    }

}
