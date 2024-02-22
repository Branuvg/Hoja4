package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Converter {
    public Stack<Integer> stack = new Stack();
    public ArrayList<Character> operators = new ArrayList<>();
    
     //identificar digitos
     public boolean isStringDigit(String str) {
        if (str == null || str.isEmpty()) {
            return false; 
        }
    
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false; 
            }
        }
        return true; 
    }

     //leer archivo datos
     public String leecion(String Archv) {

        // StringBuilder para almacenar el contenido del archivo
        StringBuilder contenido = new StringBuilder();
        
        // Intentar leer el archivo
        try {
            BufferedReader lector = new BufferedReader(new FileReader(Archv));
            String linea;
            
            // Leer cada línea del archivo y agregarla al StringBuilder
            while ((linea = lector.readLine()) != null) {
                contenido.append(linea);
                contenido.append("\n"); // Agregar un salto de línea después de cada línea leída (opcional)
            }
            
            lector.close(); // Cerrar el lector
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
        
        // Imprimir el contenido del archivo
        System.out.println("Contenido del archivo:");
        System.out.println(contenido.toString());
        return Archv;
     }


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
        System.out.println("La operación es: " + converter.leecion("C:\\Users\\gabri\\OneDrive\\Documents\\Universidad\\Semestre 3\\Base de Datos\\5, infix\\Hoja4\\demo\\src\\main\\java\\com\\example") );
        System.out.println("Postfix Form Is: " + converter.convertidor(infix));
    }
}