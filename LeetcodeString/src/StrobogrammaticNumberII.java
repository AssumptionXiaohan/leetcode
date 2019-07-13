import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 79300 on 2019/7/14.
 * 这题用递归-回溯法：https://blog.csdn.net/u010089444/article/details/53908003
 * 1.n=0和n=1的时候是两个退出条件。因为奇数的话中间是可以多取一个数的，所以其实是奇偶两个退出条件
 * 2.先找到n-2的Strobogrammatic然后在这个string的list的基础上，list里的每一个string遍历一遍，每一个string两边可以加上11、88、69、96的组合
 * 3.其实有的string两边可以加上00的组合，因为要是一个合理的数字，所以00组合其实只要不加在最外层就可以了
 * 为了保证不加在最外层，我们需要记录最初的n（因为调用递归的过程中参数会不断变成n-2，没办法判断是不是在最外层的递归里）
 */
public class StrobogrammaticNumberII {
    //记录最初的n
    public int a;

    public List<String> findStrobogrammatic(int n) {
        a = n;
        //递归入口
        return findStro(n);
    }

    private List<String> findStro(int n) {
        //两个退出条件
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        //递归找到上一层的list
        List<String> last_lst = findStro(n - 2);
        //记录result
        List<String> result = new ArrayList<>();
        //对上一层的list的两边添加合理的pair
        for (int i = 0; i < last_lst.size(); i++) {
            String current_string = last_lst.get(i);
            //这里判断是不是最外层，不是最外层的话可以有两边加00的情况
            if (n != a) result.add("0" + current_string + "0");
            result.add("1" + current_string + "1");
            result.add("8" + current_string + "8");
            result.add("6" + current_string + "9");
            result.add("9" + current_string + "6");
        }
        return result;
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII sg = new StrobogrammaticNumberII();
        sg.findStrobogrammatic(2);
    }
}
