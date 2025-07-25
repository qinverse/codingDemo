package org.coding;

import java.util.*;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        String sss = "wwwwww" +
                "\n" +
                "2\n";
        System.out.println(sss);
        System.out.println(sss.trim());

        System.out.println("Hello world!");
    }


    /**
     * '('，')'，'{'，'}'，'['，']'
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c=='{') {
                stack.push('}');
            } else if (c=='[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}