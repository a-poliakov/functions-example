public interface Predicate<T> {
    Predicate<?> ALWAYS_TRUE = t -> true;
    Predicate<?> ALWAYS_FALSE = t -> false;

    Boolean test(T t);

    default Predicate<T> or(Predicate<? super T> b) {
        return (t) -> test(t) || b.test(t);
    }

    default Predicate<T> and(Predicate<? super T> b) {
        return (t) -> test(t) && b.test(t);
    }

    default Predicate<T> not() {
        return (t) -> !test(t);
    }
}
