package com.example;
//import java.lang.invoke.ClassSpecializer.Factory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LListFactory factory = new LListFactory<>(); 
        Converter converter = new Converter();
        converter.leecion("datos.txt"); 

        System.out.println("Escriba su operación Infix:" );
        Scanner connIn = new Scanner(System.in);
        String infix = connIn.nextLine();
        System.out.println("Postfix Form Is: " + converter.convertidor(infix));

        System.out.println("CQue tipo de tack desea?");
        displayOptions();
        int op = connIn.nextInt();
        String Stacktype = "";
        switch(op){
            case 1:
                Stacktype = "arrayList";
                factory.createList(Stacktype);
                break;
            case 2:
                Stacktype = "vector";
                factory.createList(Stacktype);
                break;
            case 3:
                Stacktype = "lista";
                factory.createList(Stacktype);
                break;
            default:
                System.out.println("Adios.");

        }
    }

    private static void displayOptions(){
        System.out.println("1. Stack ArraList.");
        System.out.println("2. Stack Vector.");
        System.out.println("3. Stack lista.");
        System.out.println("4. Salir.");
        System.out.println("Seleccione su opcion.");
    }

    private static void displayLista(){
        System.out.println("1. Single.");
        System.out.println("2. Doble.");
    }
}