package prodsmile.test;


public class Foo {
    static class DbConnection {
        DbConnection() {
        }
    }


    static volatile DbConnection ref;

    public static DbConnection getDb() {

        // weak atomics : acquire, release
        var localRef = ref;
        if(localRef == null) {
            synchronized (Foo.class) {
                System.out.println("Synchronized block pass thread:" + Thread.currentThread().getId());
                localRef = ref;
                if (localRef == null) {
                    localRef = ref = new DbConnection();
                }
            }
        }
        return localRef;
    }



    public static void main(String[] argv) {
        for(var i = 0; i < 200; i++) {
            new Thread(() -> {
                getDb();
            }).start();
        }
    }


}
