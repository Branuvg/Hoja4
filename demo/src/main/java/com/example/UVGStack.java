package com.example;

/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * Gabrein Bran Bolaños - 23590
 * HT2, Stacks and Postfix
 * 31-01-2324
 * interfaz
 * @return Driver
 */

 public interface UVGStack<T> {

    void push(T x);

    T pop();

    T top();

    boolean isEmpty();
}
