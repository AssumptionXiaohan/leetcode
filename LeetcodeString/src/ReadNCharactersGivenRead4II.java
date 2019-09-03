/**
 * Created by 79300 on 2019/7/19.
 */
public class ReadNCharactersGivenRead4II{
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    /**
     * buffer: 大小为4的缓存
     * readPos：读取到缓存中的位置
     * writePos: 缓存终点+1
     */

/*    private int readPos = 0, writePos = 0;
    private char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        // Write your code here
        int i=0;
        while(i<n){
            //readPos==0 说明缓存buffer要么为空，要么已经读完了，
            //这时需要从read4中继续读入存入buffer中
            if(readPos==0){
                writePos = read4(buffer);
                System.out.println(writePos);
                //writePos==0说明上一次read4读取时已经把文件最末尾的字符读完了
                if(writePos==0) return i;
            }
            buf[i++] = buffer[readPos++];
            //readPos==writePos 说明缓存中的各个元素已经被读完了，重置为0
            if(readPos == writePos) readPos = 0;
        }
        return i;
    }*/
}
