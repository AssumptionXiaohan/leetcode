/**
 * Created by 79300 on 2019/7/2.
 * 能想到的one-pass的方法就是把所有的0往左边挪，把所有的2往右边挪
 * 因为总共只有0、1、2三个数字，这个特征很明显，所以还比较好想到
 *
 * 实现的话有一个需要注意的地方 i和left是同向走的，可能会出现同时等于0的情况
 * 这种情况会出现i停滞不前不停的和left++转换，所以就失效了
 * 仔细分析一下他们同时=0的情况只有在i==left的时候会出现
 * 这样可以减少判断成本 也让算法看起来更简洁一点
 */
public class SortColor {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right;) {
            //这里直接替换成判断i!=left
            if(nums[i]==0&&i!=left){
                swap(nums, left, i);
                left++;
/*          if(nums[i]==0){
                if(nums[left]!=0){
                    swap(nums,left,i);
                    left++;
                }else {
                    //这里要处理一下死循环的情况
                    //其实就是nums[left]和nums[i]同时等于0了
                    //这种情况只会在i和left相等的情况下出现
                    left++;
                    i++;
                }*/
            }else if(nums[i]==2){
                swap(nums,right,i);
                right--;
            }else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
