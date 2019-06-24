import java.util.Arrays;

/**
 * Created by 79300 on 2019/6/20.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == 0 || k == nums.length) return;
        int begin = 0, index = begin, value, next_value = nums[index];
        for (int i = 0; i < nums.length; i++) {
            //更新value
            value = next_value;
            index = (index + k) % nums.length;
            //存马上要被替换掉的值，也就是下一个跳的值
            next_value = nums[index];
            //替换value
            nums[index] = value;
            //如果跳回原点，就从原点下一个开始
            if (index == begin) {
                begin++;
                index = begin;
                next_value = nums[index];
            }
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        ra.rotate(new int[]{-1, -100, 3, 99}, 0);
    }
}
