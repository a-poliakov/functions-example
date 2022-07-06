import org.junit.Assert;
import org.junit.Test;

public class PredicateTest {
    @Test
    public void testAndOperation() {
        Assert.assertFalse(Predicate.ALWAYS_FALSE.and(Predicate.ALWAYS_TRUE).apply(0));
        Assert.assertFalse(Predicate.ALWAYS_TRUE.and(Predicate.ALWAYS_FALSE).apply(0));
        Assert.assertFalse(Predicate.ALWAYS_FALSE.and(Predicate.ALWAYS_FALSE).apply(0));
        Assert.assertTrue(Predicate.ALWAYS_TRUE.and(Predicate.ALWAYS_TRUE).apply(0));
    }

    private static class A {
        public int get() {return 1;}
    }

    private static class B extends A{
        public int get() {return 2;}
        public int bGet() {return 3;}
    }

    private static class C  extends B{
        public int get() {return 3;}
    }

    private static class D {
        public int get() {return 3;}
    }

    @Test
    public void testOrParametrized() {
        Predicate<B> predicate1 = b -> b.bGet() > 1;
        predicate1.apply(new B());
        predicate1.apply(new C());
//        predicate1.test(new A());
//
        Predicate<A> predicate2 = a -> a.get() > 1;
//        predicate2.or(predicate1).apply(new A());
    }
}
