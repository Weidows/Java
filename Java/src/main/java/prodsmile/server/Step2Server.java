package prodsmile.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.function.Function;

public class Step2Server {
    ServerSocket serverSocket;
    Function<String,String> handler;

    public Step2Server(Function<String, String> handler){
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
        var socket = serverSocket.accept();

        new Thread(() -> {
            try {
                this.handler(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    void handler(Socket socket) throws IOException {
        // Blocking...
        // Thread--->Sleep ---> Other Threads
        try {
            System.out.println("A socket created by Thread:" + Thread.currentThread().getId());

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
        var server = new Step2Server(req -> {
            try {
                // New IO
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "HTTP/1.1 201 ok\n\nGood!\n";
        });
        server.listen(8001);
    }

}
