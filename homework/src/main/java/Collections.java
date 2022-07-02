import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collections {
    public static <T, R> List<R> map(Function1<T, R> f, List<T> a) {
        return a.stream()
                .map(f::apply)
                .collect(Collectors.toList());
    }

    public static <T> List<T> filter(Predicate<T> p, List<T> a) {
        return a.stream()
                .filter(p::test)
                .collect(Collectors.toList());
    }

    public static <T> List<T> takeWhile(Predicate<T> p, List<T> a) {
        List<T> result = new ArrayList<>(a.size());
        for (T a_i : a) {
            if(!p.test(a_i)) {
                break;
            }
            result.add(a_i);
        }
        return result;
    }

    public static <T> List<T> takeUnless(Predicate<T> p, List<T> a) {
        List<T> result = new ArrayList<>(a.size());
        for (T a_i : a) {
            if(p.test(a_i)) {
                break;
            }
            result.add(a_i);
        }
        return result;
    }

    public static <T, R> R foldLeft(Function2<T, R, R> f, R initialValue, List<T> a) {
        if (a == null || a.isEmpty()) {
            return initialValue;
        }
        return foldLeft(f, f.apply(a.get(0), initialValue), a.subList(1, a.size()));
    }

    public static <T, R> R foldRight(Function2<T, R, R> f, R initialValue, List<T> a) {
        if (a == null || a.isEmpty()) {
            return initialValue;
        }
        return foldRight(f, f.apply(a.get(a.size() - 1), initialValue), a.subList(0, a.size() - 1));
    }
}
