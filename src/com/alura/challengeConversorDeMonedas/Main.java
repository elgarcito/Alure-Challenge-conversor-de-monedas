package com.alura.challengeConversorDeMonedas;

import com.alura.challengeConversorDeMonedas.modelos.ConversionMoneda;
import com.google.gson.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Valores predeterminados
        int eleccionUsuario=0;
        double cantidadACambiar=0;
        ConversionMoneda conversion= new ConversionMoneda();
        String apiKeyValue = "c096090b482a281a51695afe";

        //Inicio del scanner
        Scanner lectura = new Scanner(System.in);


        System.out.println("Bienvenido al conversor de monedas");
        try {

            while (true) {
                System.out.println("Elija una opcion valida");
                eleccionUsuario = Integer.valueOf(lectura.nextLine());
                if (eleccionUsuario > 0) {
                    break;
                }
            }
            while (true) {
                System.out.println("Cantidad a cambiar");
                cantidadACambiar = Integer.valueOf(lectura.nextLine());
                if (cantidadACambiar > 0) {
                    break;
                }
            }
            conversion.definirConversionyMonto(eleccionUsuario,cantidadACambiar);
            conversion.realizarConversion(apiKeyValue);
            System.out.println(conversion.getMontoFinalMonedaObjetivo());
            } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
    }

