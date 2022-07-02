package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class LambdaExample {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        JButton button = new JButton("button");
        button.setBounds(130,100,100, 40);

        // anonymous class vs lambda
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
            }
        });
        button.addActionListener(event -> System.out.println("button clicked"));

        f.add(button);

        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);

        // lambda types
        Runnable noArguments = () -> System.out.println("Hello world!");
        ActionListener oneArgument = event -> System.out.println("button clicked");
        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World!");
        };
        BinaryOperator<Long> add = (x,y) -> x + y;
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

        // effective final variables
        String name = getUserName();
        //name = formatUserName(name);
        button.addActionListener(event -> System.out.println("hi " + name));

        // type inference
        Map<String, Integer> oldWordCount = new HashMap<String, Integer>();
        Map<String, Integer> diamondWordCount = new HashMap<>();

        Predicate<Integer> atLeast5 = x -> x > 5;
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        //BinaryOperator add2 = (x, y) -> x + y;
        // Operator '&#х002В;' cannot Ье applied to java.lang.Object, java.lang.Object

        //new LambdaExample().check(x -> x > 5);
    }

    interface IntPredicate {
        boolean test(Integer value);
    }

    boolean check(Predicate<Integer> predicate) {
        return true;
    }

    boolean check(IntPredicate predicate) {
        return true;
    }

    private static String formatUserName(String name) {
        return name.toLowerCase(Locale.ROOT);
    }

    private static String getUserName() {
        return "Vasya";
    }
}
