package prodsmile.jvm;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.ServerSocket;
import java.net.Socket;

public class MyClassLoader {

    private static byte[] genClass(){
        var pool = ClassPool.getDefault();
        var ctClass = pool.makeClass("greetings.Go");

        var method = new CtMethod(CtClass.voidType, "greetings", new CtClass[]{}, ctClass);
        method.setModifiers(Modifier.PUBLIC);
        try {
            method.setBody("{ System.out.println(\"Hi, greetings!\"); }");
            ctClass.addMethod(method);
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
        try {
            return ctClass.toBytecode();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
        return null;
    }

    class BinLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if (name == "greetings.Go") {
                var bytes = genClass();
                return defineClass("greetings.Go", bytes, 0, bytes.length);
            }
            return super.findClass(name);
        }
    }

    class NetLoader extends ClassLoader {
        byte[] bytes;
        public NetLoader() throws IOException {
            connect();
        }
        private void connect() throws IOException {
            try(var socket = new Socket("localhost", 8000)){
                bytes = socket.getInputStream().readAllBytes();
            }
        }
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if (name == "greetings.Go") {
                return defineClass("greetings.Go", bytes, 0, bytes.length);
            }
            return super.findClass(name);
        }
    }


    @Test
    public void server() throws IOException {
        var serverSocket = new ServerSocket(8000);
        var bytes = genClass();
        while(true) {
            try(var clientSocket = serverSocket.accept()) {
                System.out.println("receve request...");
                var out = clientSocket.getOutputStream();
                out.write(bytes);
                out.flush();
            }
        }
    }


    @Test
    public void test_gen() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        var myloader = new BinLoader();
        var goclazz= myloader.loadClass("greetings.Go");
        var go = goclazz.getConstructor().newInstance();
        go.getClass().getMethod("greetings").invoke(go);
    }

    @Test
    public void test_net() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {

        var myloader = new NetLoader();
        var goclazz= myloader.loadClass("greetings.Go");
        var go = goclazz.getConstructor().newInstance();
        go.getClass().getMethod("greetings").invoke(go);
    }


}
