package prodsmile.server.Step3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Step3Server {

    ServerSocket serverSocket;
    IHandlerInterface httpHandler;
    public Step3Server(IHandlerInterface httpHandler){
        this.httpHandler = httpHandler;
    }

    public void listen(int port) throws IOException {

        serverSocket = new ServerSocket(port);
        while(true) {
            this.accept();
        }
    }

    void accept() throws IOException {
        var socket = serverSocket.accept();

        new Thread(() -> {
            try {
                this.handler(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private void handler(Socket socket) throws IOException {
        var request = new Request(socket);
        var response = new Response(socket);
        this.httpHandler.handler(request, response);
    }

    public static void main(String[] argv) throws IOException {
        var server = new Step3Server((req, resp) -> {
            System.out.println(req.getHeaders());
            resp.send("<html><body><h1>Hello world!</h1></body></html>");
        });

        server.listen(8001);
    }
}
