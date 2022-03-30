package prodsmile.server.Step4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class Step4Server{

    ServerSocketChannel ssc;

    public void listen(int port) throws IOException {
        ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(port));

        // Reactive / Reactor
        ssc.configureBlocking(false);

        var selector = Selector.open();

        ssc.register(selector, ssc.validOps(), null);

        ByteBuffer buffer = ByteBuffer.allocate(1024*16);


        for(;;) {

            int numOfKeys = selector.select();
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();

            while(it.hasNext()) {

                var key = (SelectionKey)it.next();

                if(key.isAcceptable()) {
                    var channel = ssc.accept();
                    if(channel == null) {
                       continue;
                    }

                    // Kernel -> mmap(buffer) -> Channel -> User(Buffer)
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                } else {

                    var channel = (SocketChannel)key.channel();

                    // _ _ _ _ _ _ _
                    //         P(position)
                    //         L
                    buffer.clear();
                    channel.read(buffer);
                    String request = new String(buffer.array());
                    // Logic...
                    buffer.clear();
                    buffer.put("HTTP/1.1 200 ok\n\nHello NIO!!".getBytes());
                    // H T T P / 1 ... ! _  _
                    //                   P(L)
                    // P                 L
                    buffer.flip();
                    channel.write(buffer);
                    channel.close();
                }


            }

        }




    }

    public static void main(String[] argv) throws IOException {
        var server = new Step4Server();
        server.listen(8001);
    }

}



