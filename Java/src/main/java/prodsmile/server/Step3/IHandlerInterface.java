package prodsmile.server.Step3;

import java.io.IOException;

@FunctionalInterface
public interface IHandlerInterface {

    void handler(Request request, Response response) throws IOException;
}
