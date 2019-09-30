/**
 * Created by 79300 on 2019/6/28.
 * 下面回复里的图解讲的很不错
 * 每一个点的水位高度=min(这个点左边最高的高度，这个点右边最高的高度)-这个点本身的高度
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        //还是一样的双指针法
        int left = 0, right = height.length - 1;
        //用两个int值来存左边的最大高度和右边的最大高度
        int left_max = 0, right_max = 0;
        int area = 0;
        while (left <= right) {
            left_max = Math.max(left_max, height[left]);
            right_max = Math.max(right_max, height[right]);
            if (left_max < right_max) {
                area = area + left_max - height[left];
                left++;
            } else {
                area = area + right_max - height[right];
                right--;
            }
        }
        return area;
    }

}
