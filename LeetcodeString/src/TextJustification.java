import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/7/13.
 * https://leetcode.com/problems/text-justification/discuss/24876/Simple-Java-Solution下面的第一个评论
 * 首先要确定一行放几个单词，
 * 接着对这几个单词做两种处理：最后一行和中间行的处理是不同的
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            //用index和last两个指针找出这一行要放的所有word，这些word的索引是index到last-1

            //count_words表示的是目前放下的内容长度
            int count_words = words[index].length();
            //last表示这一行能够放下的最后一个单词
            int last = index + 1;
            while (last < words.length) {
                if (count_words + words[last].length() + 1 > maxWidth) break;
                count_words = count_words + 1 + words[last].length();
                last++;
            }

            //下面知道了当前要放哪些word，开始做空格处理

            StringBuilder sb = new StringBuilder();
            //先把第一个word加入
            sb.append(words[index]);
            //看看还剩几个word
            int rest_word = last - index - 1;
            //当rest_word==0（也就是说这一行只有一个单词的时候必须左对齐，和最后一行是同样的处理方式）
            //last==words.length表示这是最后一行.这两种情况都是左对齐
            if (rest_word == 0 || last == words.length) {
                //把这一行剩下可以装的word装进去，如果是rest_word==0的话这一行什么也不做
                for (int i = index + 1; i < last; i++) {
                    sb.append(" " + words[i]);
                }
                //剩下的右边填上空格
                for (int i = count_words; i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                // 既不是最后一行，该行也有多个单词的情况，正常处理，平均每个单词之间的空格

                // blanks是剩下要加进去的每个单词前面的空格数
                // 这里除以rest_word是因为rest_word正好每个前面加上一份空格
                int blanks = (maxWidth - count_words) / rest_word;
                int rest_blank = (maxWidth - count_words) % rest_word;

                //开始添加剩下的word
                for (int i = index + 1; i < last; i++) {
                    for (int j = blanks; j > 0; j--) {
                        //先把每个单词前面应该有的空格加上
                        sb.append(" ");
                    }
                    if (rest_blank > 0) {
                        //如果空格是有多余的，那么从第一个地方开始每个地方多加一个，直到把多余的空格加完
                        sb.append(" ");
                        rest_blank--;
                    }
                    //这一个空格其实是因为前面计算每个单词前面的空格数的时候用的-count_words，
                    // 但count_words的值其实已经为每一个单词前面加过一次空格了
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            result.add(sb.toString());
            //开始下一行，index从last的位置开始
            index = last;
        }
        return result;
    }
}
