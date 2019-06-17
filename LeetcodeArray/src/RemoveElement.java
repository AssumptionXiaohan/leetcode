/**
 * Created by 79300 on 2019/6/16.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] == val) {
                //边界情况
                if (i == length - 1) return --length;
                //把最后一个元素补到删除的位置上
                nums[i] = nums[length - 1];
                length--;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(new int[]{1}, 1));
    }
}
