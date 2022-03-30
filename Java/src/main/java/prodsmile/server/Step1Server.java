package prodsmile.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.function.Function;

public class Step1Server {

    ServerSocket serverSocket;
    Function<String,String> handler;

    public Step1Server(Function<String, String> handler){
        this.handler = handler;
    }

    // Pending Queue
    public void listen(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while(true) {
            this.accept();
        }
    }

    void accept() throws IOException {
        // Blocking...
        // Thread--->Sleep ---> Other Threads
        try {
            var socket = serverSocket.accept();
            System.out.println("A socket created");

            var iptStream = new DataInputStream(socket.getInputStream());
            var bfReader = new BufferedReader(new InputStreamReader(iptStream));

            var requestBuilder = new StringBuilder();

            String line = "";

            // Readline -> line end '\n'
            while (true) {
                line = bfReader.readLine();
                if(line == null || line.isBlank()) {
                    break;
                }
                requestBuilder.append(line + '\n');
            }

            var request = requestBuilder.toString();
            System.out.println(request);

            var bfWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            var response = this.handler.apply(request);
            bfWriter.write(response);
            bfWriter.flush();
            socket.close();
        }catch(SocketException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] argv) throws IOException {
        var server = new Step1Server(req -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "HTTP/1.1 201 ok\n\nGood!\n";
        });
        server.listen(8001);
    }

}
