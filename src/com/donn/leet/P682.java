package com.donn.leet;

import java.util.ArrayDeque;
import java.util.Deque;

public class P682 {

    public static void main(String[] args) {
        System.out.println(new P682().calPoints(new String[] { "-21", "-66", "39", "+", "+" }));
    }

    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : ops) {
            switch (s) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int i = stack.pop();
                    int j = stack.peek();
                    stack.push(i);
                    stack.push(i + j);
                    break;
                default:
                    // error handle if need
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
