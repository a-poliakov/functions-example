package org.example;

public class InterfacesExample {
    public static void main(String[] args) {
        Parent parent = new ParentImpl();
        parent.hello();

        Child child = new ChildImpl();
        child.hello();

        parent = new OverridingParent();
        parent.hello();

        child = new OverridingChild();
        child.hello();
    }

    public static interface Parent {
        void message(String body);

        default void hello() {
            message("Parent: HI!");
        }

        String getLastMessage();
    }

    public static class ParentImpl implements Parent {

        @Override
        public void message(String body) {
            System.out.println(body);
        }

        @Override
        public String getLastMessage() {
            return null;
        }
    }

    public static interface Child extends Parent {
        @Override
        default void hello() {
            message("Child: Hi!");
        }
    }

    public static class ChildImpl implements Child {

        @Override
        public void message(String body) {
            System.out.println(body);
        }

        @Override
        public String getLastMessage() {
            return null;
        }
    }

    public static class OverridingParent extends ParentImpl {
        @Override
        public void hello() {
            message("Class Parent: Hi!");
        }
    }

    public static class OverridingChild extends OverridingParent implements Child {

    }

    public static interface A {
        default void f(){}
    }

    public static interface B {
        default void f(){}
    }

    // org.example.InterfacesExample.Clazz inherits unrelated defaults for f()
    // from types org.example.InterfacesExample.A and org.example.InterfacesExample.B
    public static class Clazz implements A, B {
        @Override
        public void f() {
            A.super.f();
        }
    }
}
