import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CollectionsTest {
    @Test
    public void testFoldLeft() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        Integer result = Collections.<Integer, Integer>foldLeft(Integer::sum, 0, integers);
        Assert.assertEquals(Integer.valueOf(10), result);
    }

    @Test
    public void testFoldRight() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        Integer result = Collections.<Integer, Integer>foldRight(Integer::sum, 0, integers);
        Assert.assertEquals(Integer.valueOf(10), result);
    }

    @Test
    public void testTakeWhile() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = Collections.takeWhile(x -> x <= 2, integers);
        Assert.assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    public void testTakeUnless() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = Collections.takeUnless(x -> x > 2, integers);
        Assert.assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    public void testMap() {
        List<String> words = Arrays.asList("a", "b", "test");
        List<String> result = Collections.map(String::toUpperCase, words);
        Assert.assertEquals(Arrays.asList("A", "B", "TEST"), result);
    }

    @Test
    public void testFilter() {
        List<String> words = Arrays.asList("a", "1b", "test1");
        List<String> result = Collections.filter(string -> Character.isDigit(string.charAt(0)), words);
        Assert.assertEquals(List.of("1b"), result);
    }
}
