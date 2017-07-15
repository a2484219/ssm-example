package test.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by Yao on 2017/3/16.
 */
public class NioTest {

    private Selector selector;

    public static void main(String[] args) throws Exception {
        new NioTest().readFile();
    }

    public void readFile() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("d:/aaa.txt", "rw");
        FileChannel fileChannel = raf.getChannel();
        Charset charset = Charset.forName("GBK");
        CharsetDecoder decoder = charset.newDecoder();
//        selector.select();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size());
        System.out.println(fileChannel.size());
        CharBuffer charBuffer = CharBuffer.allocate((int)fileChannel.size());
        int result = fileChannel.read(byteBuffer);
        System.out.println((char)result);
        while (result != -1) {
            byteBuffer.flip();
            decoder.decode(byteBuffer, charBuffer, false);
            charBuffer.flip();
            while (charBuffer.hasRemaining()){
                System.out.println(charBuffer.get());
            }
            byteBuffer.clear();
            result = fileChannel.read(byteBuffer);
        }
        fileChannel.close();
        raf.close();
    }
}
