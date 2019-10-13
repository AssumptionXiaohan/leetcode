import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 79300 on 2019/10/8.
 * 我太强了！！！
 * 需要定义一个新的node结点，sum:这个节点左子树的结点个数 dup:和当前结点数值相等的元素个数
 * 从数组尾部开始insert到binary tree里，同时修改sum和dup~
 */
public class CountOfSmallerNumbersAfterSelf {
    public class Node {
        Node left, right;
        int val, sum = 0, dup = 1;

        public Node(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        if (nums == null || nums.length == 0) return Arrays.asList(result);
        Node root = new Node(nums[nums.length - 1]);
        result[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = insert(root, nums[i]);
        }
        return Arrays.asList(result);
    }

    //return比当前num小的结点数量
    private int insert(Node root, int num) {
        int sum = 0;
        Node current = root;
        while (current.val != num) {
            if (current.val < num) {
                //每次往右走的时候更新sum的值
                sum = sum + current.sum + current.dup;
                if (current.right == null) {
                    current.right = new Node(num);
                    return sum;
                } else {
                    current = current.right;
                }
            } else {
                //往左走的时候更新当前结点的sum值
                current.sum++;
                if (current.left == null) {
                    current.left = new Node(num);
                    return sum;
                } else {
                    current = current.left;
                }
            }
        }
        current.dup++;
        //duplicate的情况除了之前的sum还要加上current.sum
        return sum + current.sum;
    }
}

