package com.alura.challengeConversorDeMonedas.modelos;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Menu {

    private int eleccionDeUsuario;
    private int cantidadACambiar;


    public void mostrarOpciones() {
        // Leer el archivo JSON
        FileReader reader = null;
        try {
            reader = new FileReader("opciones.json");
            JsonElement fileElement = JsonParser.parseReader(reader);
            JsonArray jsonArray = fileElement.getAsJsonArray();

            // Iterar a través del array
            int opcion = 1;
            for (JsonElement element : jsonArray) {
                JsonObject objeto = element.getAsJsonObject();
                String opciones = objeto.get("Opciones_de_conversion").getAsString();
                System.out.println(" Opción: " + opcion + "-----> " + opciones);
                opcion++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int elegirOpciones(Scanner lectura) {
        int eleccionUsuario;
        try {
            while (true) {
                System.out.println("\n" + "Ingrese un numero del 1 al 7");
                if (lectura.hasNextInt()) {
                    eleccionUsuario = Integer.valueOf(lectura.nextLine());
                    if (eleccionUsuario > 0 && eleccionUsuario <= 7) {
                        break;
                    } else {
                        System.out.println("Número fuera de rango. Inténtalo de nuevo.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                    lectura.next();
                }
            }
            return eleccionUsuario;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public double elegirMontoACambiar(Scanner lectura) {
       double cantidadACambiar=1;
        try {
            while (true) {
                System.out.println("Ingrese una cantidad a cambiar, entre 1 y 1.000.000");
                if (lectura.hasNextInt()) {
                    cantidadACambiar = Double.valueOf(lectura.nextLine());
                    if (cantidadACambiar > 0 && cantidadACambiar <= 1000000) {
                        break;
                    } else {
                        System.out.println("Número fuera de rango. Inténtalo de nuevo.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                    lectura.next();
                }
            }
            return cantidadACambiar;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}