public interface Function1<T, R> {
    R apply(T t);

    default Function1<T, R> compose(Function1<? super R, ? extends R> g) {
        return (T t) -> g.apply(apply(t));
    }
}
