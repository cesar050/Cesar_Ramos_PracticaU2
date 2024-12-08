package com.practica.rest;

import com.practica.controller.tda.list.LinkedList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("time")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        
        int tiempoInicio;
        int tiempoFinal;
        int tiempoTotal;
        int busqueda;

        LinkedList<Integer> listaA = ListaAleatoria(10000);
        LinkedList<Integer> listaB = listaA.duplicar_lista();
        LinkedList<Integer> listaC= listaA.duplicar_lista();
        LinkedList<Integer> listaD = listaA.duplicar_lista();
        
        System.out.println("======================================================");
        // Medición de ShellSort
        tiempoInicio = (int) System.currentTimeMillis();
        listaA.shellSort(1);
        tiempoFinal = (int) System.currentTimeMillis();
        tiempoTotal = tiempoFinal - tiempoInicio;
        System.out.println("------------------------------------------------------");
        System.out.println("ShellSort 1: " + tiempoTotal + " milisegundos");
        System.out.println("------------------------------------------------------");

        // Medición de QuickSort
        tiempoInicio = (int) System.currentTimeMillis();
        listaB.quickSort(1);
        tiempoFinal = (int) System.currentTimeMillis();
        tiempoTotal = tiempoFinal - tiempoInicio;
        System.out.println("------------------------------------------------------");
        System.out.println("QuickSort 1: " + tiempoTotal + " milisegundos");
        System.out.println("------------------------------------------------------");

        // Medición de MergeSort
        tiempoInicio = (int) System.currentTimeMillis();
        listaC.mergeSort(1);
        tiempoFinal = (int) System.currentTimeMillis();
        tiempoTotal = tiempoFinal - tiempoInicio;
        System.out.println("------------------------------------------------------");
        System.out.println("MergeSort 1: " + tiempoTotal + " milisegundos");
        System.out.println("------------------------------------------------------");

        System.out.println("======================================================");
        System.out.println("======================================================");

        // Medición de búsqueda
        Integer value = (int) (Math.random() * 60000);

        // Búsqueda lineal
        listaD.shellSort(1);
        tiempoInicio = (int) System.nanoTime();
        busqueda = listaD.linearSearch(value);
        tiempoFinal = (int) System.nanoTime();
        tiempoTotal = tiempoFinal - tiempoInicio;
        System.out.println("------------------------------------------------------");
        System.out.println("LinearSearch : " + tiempoTotal + " ns en posicion: " + busqueda);
        System.out.println("------------------------------------------------------");

        // Ordenar con shellSort antes de la búsqueda binaria

        tiempoInicio = (int) System.nanoTime();
        busqueda = listaD.binarySarch(value);
        tiempoFinal = (int) System.nanoTime();
        tiempoTotal = tiempoFinal - tiempoInicio;
        System.out.println("------------------------------------------------------");
        System.out.println("BinarySearch con mergeSort : " + tiempoTotal + " ns en posicion: " + busqueda);
        System.out.println("------------------------------------------------------");
        System.out.println("======================================================");
        return "Medicion completada correctamente";
    }

    // Generar lista con números aleatorios
    LinkedList<Integer> ListaAleatoria(Integer cantidad) {
        LinkedList<Integer> listitia = new LinkedList<>();
        for (int i = 0; i < cantidad; i++) {
            listitia.add((int) (Math.random() * 100000));
        }
        return listitia;
    }
}
