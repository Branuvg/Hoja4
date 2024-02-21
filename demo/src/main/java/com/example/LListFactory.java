package com.example;

public class LListFactory<T> {
    /*
    Abstract Factory de listas;
    pero usando generics.
     */
    public UVGLList<T> createList(String type) {
        /*
           Note que por usar generics no puede ser estatica.
         */
        switch (type){
            case "SINGLE":
                return new SLList<T>();
            case "DOUBLE":
                return new DLList<T>();
            default:
                return null;
        }
    }

}