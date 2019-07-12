import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by 79300 on 2019/7/12.
 * 用stack来做
 * https://www.youtube.com/watch?v=SrlvMmfG8sA
 * Input: "cbacdcbc"
 * Output: "acdb"
 */

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        //用count数组记录每个元素的出现次数
        int[] count = new int[26];
        for (char character : s.toCharArray()) {
            count[character - 'a']++;
        }
        //元素是否已经在stack里
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char character : s.toCharArray()) {
            int index = character - 'a';
            //假设遇到了一个已经被visited的元素，count需要--，其他不用管继续往前挪
            //因为假设abca，我们一直取前面的a即可
            if(visited[index]){
                count[index]--;
                continue;
            }
            //以cabc为例，当栈顶元素c的字典顺序大于a时且count[c]>0也就是说后面还有c的情况下
            //我们可以把这个c删掉，这里用while循环比如bcabc这里我们把c和b一起删掉
            //然后把apush进去，同时调整visited和count的值
            while (stack.size() > 0 && stack.peek() - 'a' > index && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                //这里不需要count++是因为我们要记录当前char的后面有多少个char，不能因为删掉了前面的内容而count++
                stack.pop();
            }
            stack.push(character);
            count[index]--;
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char c:stack) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rd = new RemoveDuplicateLetters();
        System.out.println(rd.removeDuplicateLetters("abacb"));
    }
}
