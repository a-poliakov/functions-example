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
}
