package prodsmile.basic.monad;

public interface TryMapFunction<T, R> {
    R apply(T t) throws Throwable;
}