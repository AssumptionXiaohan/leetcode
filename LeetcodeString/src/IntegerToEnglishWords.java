/**
 * Created by 79300 on 2019/7/13.
 * 递归问题..
 * 首先把num和String数组的index对应起来
 * 然后num从小到大的几个临界情况判断一下进行递归
 */
public class IntegerToEnglishWords {
    //belowTen的第一位其实是zero，会单独判断，因为在递归的时候不会出现Zero，只有num=0才会是Zero
    final String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    final String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] belowHundred = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        else return numToword(num);
    }

    //这里每个加了空格的情况都需要trim一下去掉前后的空格，避免前后递归return是空字符串的时候多出空格的情况
    private String numToword(int num) {
        //1-9的情况
        if (num < 10) return belowTen[num];
            //10-19的情况
        else if (num < 20) return belowTwenty[num - 10];
            //20-99的情况,25 num/10=2 num%10=5
        else if (num < 100) return (belowHundred[num / 10] + " " + numToword(num % 10)).trim();
            //100-999的情况：915 num/100=9, num%100=15
        else if (num < 1000) return (numToword(num / 100) + " Hundred " + numToword(num % 100)).trim();
            //1000-999,999的情况：25,987 25987/1000=25,%1000=987
        else if (num < 1000000) return (numToword(num / 1000) + " Thousand " + numToword(num % 1000)).trim();
            //1,000,000-999,999,999的情况
        else if (num < 1000000000) return (numToword(num / 1000000) + " Million " + numToword(num % 1000000)).trim();
            //1,000,000,000-Max的情况
        else return (numToword(num / 1000000000) + " Billion " + numToword(num % 1000000000)).trim();
    }
}
