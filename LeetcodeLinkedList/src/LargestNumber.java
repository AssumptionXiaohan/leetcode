import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by 79300 on 2019/10/26.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings,new Comparator<String>(){
            public int compare(String o1,String o2){
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str2.compareTo(str1);
            }
        });
        //假设只有一堆0的话说明开头肯定是0
        if(strings[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s :strings){
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        ln.largestNumber(new int[]{0,0,0,0});
    }
}
