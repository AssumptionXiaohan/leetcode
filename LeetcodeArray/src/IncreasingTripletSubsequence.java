/**
 * Created by 79300 on 2019/6/28.
 * min用来存储i左边的最小值，medium用来存储min右边比min大的最小的值。
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 2) return false;
        int min = Integer.MAX_VALUE, medium = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // step2:假设medium已经被更新过了，且现在找到了一个值比medium大，那sequence就出现了
            if (medium != Integer.MAX_VALUE && nums[i] > medium) return true;
            // step1：假设现在出现了一个值比min大，我们存在medium里，作为sequence里的第二个数
            // 假设medium已经有值了，那么我们更新它，存目前为止比min大的所有值里最小的medium，因为第三个数只要比这个大就可以return true了
            // min也要不断更新，比如[3,2,6,7..]这样的数组，min一开始是3然后更新为2，
            // 这并不会miss掉一些正确结果，因为后面比3大的肯定也比2大，所以找到的sequence是[2,6,7]还是[3,6,7]并没有什么关系都是true
            if (nums[i] > min) {
                medium = Math.min(medium, nums[i]);
            } else {
                min = nums[i];
            }
        }
        return false;
    }
}
