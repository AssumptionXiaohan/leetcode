import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by 79300 on 2019/10/26.
 */
public class ContainsDuplicates {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeset = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer low = treeset.floor(nums[i]-t);
            Integer high = treeset.ceiling(nums[i]+t);
            if((low!=null&&low<=nums[i])||(high!=null&&high>=nums[i])){
                return true;
            }
            treeset.add(nums[i]);

            //保证下一次进循环的时候还是只有k个数
            if(i>=k){
                treeset.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicates cd = new ContainsDuplicates();
        cd.containsNearbyAlmostDuplicate(new int[]{1,0,1,1},1,2);
    }
}
