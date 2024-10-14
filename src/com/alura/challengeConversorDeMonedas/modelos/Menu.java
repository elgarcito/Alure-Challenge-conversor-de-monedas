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
        int eleccionUsuario = 0;
        try {
            while (true) {
                System.out.println("\nIngrese un número del 1 al 7");
                String input = lectura.nextLine().trim(); // Leer la entrada y eliminar espacios en blanco

                if (input.isEmpty()) {
                    System.out.println("Entrada vacía. Por favor, introduce un número.");
                    continue; // Volver al inicio del bucle
                }

                try {
                    eleccionUsuario = Integer.valueOf(input);
                    if (eleccionUsuario > 0 && eleccionUsuario <= 7) {
                        break;
                    } else {
                        System.out.println("Número fuera de rango. Inténtalo de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                }
            }
            return eleccionUsuario;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double elegirMontoACambiar(Scanner lectura) {
        double cantidadACambiar = 1;
        try {
            while (true) {
                System.out.println("Ingrese una cantidad a cambiar, entre 1 y 1.000.000");
                String input = lectura.nextLine().trim(); // Leer la entrada y eliminar espacios en blanco

                if (input.isEmpty()) {
                    System.out.println("Entrada vacía. Por favor, introduce un número.");
                    continue; // Volver al inicio del bucle
                }

                try {
                    cantidadACambiar = Double.valueOf(input);
                    if (cantidadACambiar > 0 && cantidadACambiar <= 1000000) {
                        break;
                    } else {
                        System.out.println("Número fuera de rango. Inténtalo de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                }
            }
            return cantidadACambiar;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int continuarOCerrarPrograma(Scanner lectura) {
        int eleccionUsuario = 0;
        try {
            while (true) {
                System.out.println("\n¿Desea realizar otra conversión? 1-Sí, 2-No");
                String input = lectura.nextLine().trim(); // Leer la entrada y eliminar espacios en blanco

                if (input.isEmpty()) {
                    System.out.println("Entrada vacía. Por favor, introduce un número.");
                    continue; // Volver al inicio del bucle
                }

                try {
                    eleccionUsuario = Integer.valueOf(input);
                    if (eleccionUsuario > 0 && eleccionUsuario <= 2) {
                        break;
                    } else {
                        System.out.println("Número fuera de rango. Inténtalo de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                }
            }
            return eleccionUsuario;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}