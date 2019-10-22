/**
 * Created by 79300 on 2019/10/21.
 * ugly number都是由ugly number*2/3/5 组成的
 * 1*2 2*2
 * 1*3 2*3
 * 1*5 2*5 ....
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n <= 0) return -1;
        int[] nums = new int[n];
        nums[0] = 1;
        //i2 i3 i5用来标记本次用来构建*2/*3/*5的ugly number的index
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int new_num2 = nums[i2] * 2;
            int new_num3 = nums[i3] * 3;
            int new_num5 = nums[i5] * 5;
            int new_num = Math.min(new_num2 > new_num3 ? new_num3 : new_num2, new_num5);
            nums[i] = new_num;
            //被选中的idx+1
            if (new_num == new_num2) i2++;
            if (new_num == new_num3) i3++;
            if (new_num == new_num5) i5++;
        }
        return nums[n - 1];
    }
}
