package com.example;

import java.util.Stack;

public class Converter {
    
    int antes(char ch) {
        if (ch == '+' || ch == '-') {
            return 1; // Precedence of + or - is 1
        } else if (ch == '*' || ch == '/') {
            return 2; // Precedence of * or / is 2
        } else if (ch == '^') {
            return 3; // Precedence of ^ is 3
        } else {
            return 0;
        }
    }

    String convertidor(String infix) {
        Stack<Character> stk = new Stack<>();
        stk.push('#'); // add some extra character to avoid underflow
        StringBuilder postfix = new StringBuilder(); // initially the postfix string is empty

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch); // add to postfix when character is letter or number
            } else if (ch == '(') {
                stk.push('(');
            } else if (ch == '^') {
                stk.push('^');
            } else if (ch == ')') {
                while (stk.peek() != '#' && stk.peek() != '(') {
                    postfix.append(stk.pop()); // store and pop until ( has found
                }
                stk.pop(); // remove the '(' from stack
            } else {
                if (antes(ch) > antes(stk.peek())) {
                    stk.push(ch); // push if precedence is high
                } else {
                    while (stk.peek() != '#' && antes(ch) <= antes(stk.peek())) {
                        postfix.append(stk.pop()); // store and pop until higher precedence is found
                    }
                    stk.push(ch);
                }
            }
        }

        while (stk.peek() != '#') {
            postfix.append(stk.pop()); // store and pop until stack is not empty.
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "1+2*9";
        Converter converter = new Converter();
        System.out.println("Postfix Form Is: " + converter.convertidor(infix));
    }
}