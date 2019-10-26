/**
 * Created by 79300 on 2019/10/22.
 * 和uglynumberII的思路一样，就是需要去重
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0) return -1;
        int[] idx_primes = new int[primes.length];
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            nums[i] = Integer.MAX_VALUE;
            for (int j = 0; j < idx_primes.length; j++) {
                nums[i] = Math.min(nums[i], nums[idx_primes[j]] * primes[j]);
            }
            for(int j=0;j<idx_primes.length;j++){
                if(nums[i]==nums[idx_primes[j]] * primes[j]){
                    idx_primes[j]++;
                }
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        SuperUglyNumber sun = new SuperUglyNumber();
        System.out.println(sun.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
