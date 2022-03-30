package prodsmile.server;
import java.io.*;
import java.net.ServerSocket;

class RawHTTPServer {

    public static void main(String[] argv) throws IOException {

        ServerSocket socketServer = new ServerSocket(8001);

        // Main Thread
        while(true) {
            // Blocking...
            // Thread--->Sleep ---> Other Threads
            var socket = socketServer.accept();
            System.out.println("A socket created");

            var iptStream = new DataInputStream(socket.getInputStream());
            var bfReader = new BufferedReader(new InputStreamReader(iptStream));

            var requestBuilder = new StringBuilder();

            String line = "";

            // Readline -> line end '\n'
            while(!(line = bfReader.readLine()).isBlank()) {
                requestBuilder.append(line + '\n');
            }

            var request = requestBuilder.toString();
            System.out.println(request);

            var bfWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bfWriter.write("HTTP/1.1 200 ok\n\nHello World!\n");
            bfWriter.flush();
            socket.close();
        }

    }

}