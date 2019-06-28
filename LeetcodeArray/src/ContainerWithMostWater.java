/**
 * Created by 79300 on 2019/6/28.
 * 蓄水池的高永远都是由矮的一边决定
 * 蓄水池的长度是按index的差距决定
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //用双指针法，两个指针分别指在数组开头和结尾
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        //左右哪边数值小，就哪边往中间移动
        while (left<right){
            if(height[left]<height[right]){
                maxArea = Math.max(maxArea,(right-left)*height[left]);
                left++;
            }else {
                maxArea = Math.max(maxArea,(right-left)*height[right]);
                right--;
            }
        }
        return maxArea;
    }
}
