/**
 * Created by 79300 on 2019/6/29.
 * 按道理可以用放在正确的位置的方法 但是题目给了not modify array。。
 * ------下面是新方法---------
 * 一个快指针一个慢指针，快指针走两步，慢指针走一步直到相遇。
 * 这时快指针回到初始点，然后和慢指针一人走一步，到遇到相等值的时候就是重复值。
 * 具体解析见草稿纸287.find the duplicate number
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int fast = nums[0], slow = nums[0];
        //这里要用do while循环，不然的话起始点fast和while是相同的
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while (fast != slow);

        fast = nums[0];
        while (fast!=slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }


/*    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) return nums[i];
                else {
                    swap(nums, i, nums[i] - 1);
                }
            }else {
                i++;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }*/
    public static void main(String[] args) {
        FindTheDuplicateNumber fdn = new FindTheDuplicateNumber();
        System.out.println(fdn.findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }

}
