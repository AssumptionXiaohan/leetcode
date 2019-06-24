/**
 * Created by 79300 on 2019/6/24.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int count_bulls = 0, count_cows = 0;
        //总共只有0-9 10个数字，用一个额外的数组来保存这些数字出现的次数
        int count[] = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            //找到bull时不修改数组，直接跳过
            if (s == g) {
                count_bulls++;
            } else {
                //secret每次遇到的数字++，guess每次遇到的数字--
                //如果count[g]为正代表现在guess的数字之前在secret中出现过，所以此时捕获一个cow
                //如果count[s]为负代表现在secret的数字之前在guess中出现过，所以此时捕获一个cow
                if (count[g] > 0) count_cows++;
                if (count[s] < 0) count_cows++;
                count[g]--;
                count[s]++;
            }
        }
        return count_bulls + "A" + count_cows + "B";
    }

}
