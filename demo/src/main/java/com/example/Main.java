package com.example;
//import java.lang.invoke.ClassSpecializer.Factory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        converter.leecion("datos.txt"); 

        Scanner connIn = new Scanner(System.in);
        System.out.println("Como desea almacenar los datos");
        displayOptions();
        int op = connIn.nextInt();
        String Stacktype = "";
        switch(op){
            case 1:
                Stacktype = "arrayList";
                break;
            case 2:
                Stacktype = "vector";
                break;
            case 3:
                Stacktype = "lista";
                break;
            default:
                System.out.println("Adios.");

        }
       /* System.out.println("Seleccione el tipo de patrón de diseño desea utilizar:");
        displayLista();
        int tipo = connIn.nextInt();
        String listType = "";
        switch(op){
            case 1:
                listType = "lista enlazada";
                break;
            case 2:
                listType = "lista doble";
                break;
            default:
                break;
            }*/
    }

    private static void displayOptions(){
        System.out.println("1. Stack ArraList.");
        System.out.println("2. Stack Vector.");
        System.out.println("3. Stack lista.");
        System.out.println("4. Salir.");
        System.out.println("Seleccione su opcion.");
    }

    private static void displayLista(){
        System.out.println("1. Singleton.");
        System.out.println("2. Factory.");
    }
}