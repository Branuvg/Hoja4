package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @BeforeEach
    void setUp() {
        Calculadora calcu = new Calculadora();
    }

    @Test
    void posfix() {
        // Arrange
        Calculadora calculadora = new Calculadora();
        calculadora.stack = new Stack<>();
        calculadora.operators = new ArrayList<>();
        calculadora.stack.push(2);
        calculadora.stack.push(3);
        calculadora.operators.add('+');

        // Act
        int result = calculadora.posfix();

        // Assert
        assertEquals(5, result, "La suma de 2 y 3 debe ser 5");
    }

    @Test
    public void testPushAndPop() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act
        stack.push(5);
        stack.push(10);
        int popped1 = stack.pop();
        int popped2 = stack.pop();

        // Assert
        assertEquals(10, popped1, "El primer elemento debe ser 10");
        assertEquals(5, popped2, "El segundo elemento debe ser 5");
        assertTrue(stack.isEmpty(), "El stack debe estar vacío después de pop");
    }

    @Test
    public void testTop() {
        // Arrange
        Stack<String> stack = new Stack<>();
        stack.push("Hola");
        stack.push("Mundo");

        // Act
        String topElement = stack.top();

        // Assert
        assertEquals("Mundo", topElement, "El elemento en la cima debe ser 'Mundo'");
    }

    @Test
    public void testIsEmpty() {
        // Arrange
        Stack<Double> stack = new Stack<>();

        // Act
        boolean isEmptyBeforePush = stack.isEmpty();
        stack.push(3.14);
        boolean isEmptyAfterPush = stack.isEmpty();

        // Assert
        assertTrue(isEmptyBeforePush, "El stack debe estar vacío al principio");
        assertFalse(isEmptyAfterPush, "El stack no debe estar vacío después de empujar un elemento");
    }

    @Test
    public void testPopEmptyStack() {
        // Arrange
        Stack<Integer> stack = new Stack<>();

        // Act/Assert
        assertThrows(UnsupportedOperationException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void testAddLastAndGetFirst() {
        // Arrange
        SLList<String> list = new SLList<>();

        // Act
        list.addLast("Hola");
        list.addLast("Mundo");
        String firstElement = list.getFirst();

        // Assert
        assertFalse(list.isEmpty(), "La lista no debe estar vacía después de agregar elementos");
        assertEquals("Hola", firstElement, "El primer elemento debe ser 'Hola'");
    }

    @Test
    public void testRemoveFirst2() {
        // Arrange
        SLList<Integer> list = new SLList<>();
        list.addLast(5);
        list.addLast(10);

        // Act
        list.removeFirst();
        Integer firstElement = list.getFirst();

        // Assert
        assertFalse(list.isEmpty(), "La lista no debe estar vacía después de eliminar el primer elemento");
        assertEquals(10, firstElement, "El nuevo primer elemento debe ser 10");
    }

    @Test
    public void testRemoveFirst() {
        // Arrange
        DLList<Integer> list = new DLList<>();
        list.addLast(5);
        list.addLast(10);

        // Act
        list.removeFirst();
        Integer firstElement = list.getFirst();

        // Assert
        assertFalse(list.isEmpty(), "La lista no debe estar vacía después de eliminar el primer elemento");
        assertEquals(10, firstElement, "El nuevo primer elemento debe ser 10");
    }

    @Test
    public void testToString2() {
        // Arrange
        DLList<Character> list = new DLList<>();
        list.addLast('A');
        list.addLast('B');
        list.addLast('C');

        // Act
        String result = list.toString();

        // Assert
        assertEquals("null<-Head:[A]=>[B]=>[C]:Tail->null", result, "La representación de la lista debe ser correcta");
    }

}