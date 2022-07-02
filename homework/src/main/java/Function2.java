import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface Function2<T, U, R> {
    R apply(T t, U u);

    default <V> Function2<T, U, V> compose(Function1<? super R, ? extends V> after) {
        return (T t, U u) -> after.apply(apply(t, u));
    }

    default Function2<T, U, R> bind1(T x) {
        return (T t, U u) -> apply(x, u);
    }

    default Function2<T, U, R> bind2(U y) {
        return (T t, U u) -> apply(t, y);
    }
}
