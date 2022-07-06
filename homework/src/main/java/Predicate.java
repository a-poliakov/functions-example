public interface Predicate<T> extends Function1<T, Boolean> {
    Predicate ALWAYS_TRUE = t -> true;
    Predicate ALWAYS_FALSE = t -> false;

    Boolean apply(T t);

    default Predicate<T> or(Predicate<? super T> b) {
        return (t) -> apply(t) || b.apply(t);
    }

    default Predicate<T> and(Predicate<? super T> b) {
        return (t) -> apply(t) && b.apply(t);
    }

    default Predicate<T> not() {
        return (t) -> !apply(t);
    }
}
