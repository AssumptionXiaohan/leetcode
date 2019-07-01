/**
 * Created by 79300 on 2019/7/1.
 * 记住两个数据left[i]和right[i]，分别表示i左边元素的乘积和右边元素的乘积
 * 第一遍遍历的时候把left[i]都计算好
 * 第二遍遍历的时候，本来是需要把right[i]都计算好
 * 但可以直接用一个right_product，边记录右边乘积边修改left[i]*right_product,把left[]变成结果数组
 * 这样空间复杂度就变成O(1)了
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int left_product = 1, right_product = 1;
        //计算左边所有元素的乘积
        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //初始值left[0]=1，因为任何一个数*1=数字本身
            left[i] = left_product;
            //更新left_product
            left_product = left_product * nums[i];
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            //更新left[j]，乘右边所有元素的乘积，直接得到结果
            left[j] = left[j] * right_product;
            //更新right_product
            right_product = right_product * nums[j];
        }
        return left;
    }
}
