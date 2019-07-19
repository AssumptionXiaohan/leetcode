/**
 * Created by 79300 on 2019/7/19.
 */
public class ReadNCharactersGivenRead4II {
    public int read(char[] buf, int n) {
        int read_pointer = 0;
        int read4_pointer = 0;
        char[] temp = new char[4];

        while (read4_pointer < n) {
            if (read4_pointer == 0) {
                read4_pointer = read4(temp);
            }

            
        }
    }
}
