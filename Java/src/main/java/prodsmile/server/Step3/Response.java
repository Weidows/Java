package prodsmile.server.Step3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;

public class Response {
    Socket socket;
    private int status;

    static HashMap<Integer, String> codeMap;
    public Response(Socket socket) {
        this.socket = socket;
        if(codeMap == null) {
            codeMap = new HashMap<>();
            codeMap.put(200, "OK");
        }

    }

    public void send(String msg) throws IOException {
        var resp = "HTTP/1.1 " + this.status + " " + this.codeMap.get(this.status) + "\n";
        resp += "\n";
        resp += msg;
        this.sendRaw(resp);
    }

    public void sendRaw(String msg) throws IOException {
        var bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(msg);
        bufferedWriter.flush();
        socket.close();
    }

}
