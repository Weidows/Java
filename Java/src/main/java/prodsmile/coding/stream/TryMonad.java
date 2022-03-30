package prodsmile.coding.stream;

public class TryMonad<T> {

    boolean success = false;
    Exception ex = null;


    public static <T> TryMonad<T> tryIt(Runnable r) {
        var monad = new TryMonad<T>();
        try {
            r.run();
            monad.success = true;
        } catch (Exception ex) {
            monad.ex = ex;
        }
        return monad;
    }
}
