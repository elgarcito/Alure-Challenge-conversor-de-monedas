package com.alura.challengeConversorDeMonedas;

import com.alura.challengeConversorDeMonedas.modelos.ConversionMoneda;
import com.alura.challengeConversorDeMonedas.modelos.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Valores predeterminados
        Menu menu = new Menu();// Inicializo la clase menu
        ConversionMoneda conversion = new ConversionMoneda();
        //String apiKeyValue = "c096090b482a281a51695afe";//
        int estado = 1;
        //Inicio del scanner
        Scanner lectura = new Scanner(System.in);


        //Inicio del programa

        //Mensaje de bienvenida
        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("Por favor elija una opcion valida" + "\n");

        //Envuelvo en un while hasta que se cambie el estado
        while (estado == 1) {
            //Mostrar el menu con las opciones
            menu.mostrarOpciones();

            //Elegir una opcion del menu
            int eleccionUsuario = menu.elegirOpciones(lectura);

            //Si la eleccion del menu es salir (opcion 7) el estado cambia a 2 y se termina el programa
            if (eleccionUsuario == 7) {
                break;
            } else {
                //De otra forma accedo a la eleccion de moneda
                double cantidadACambiar = menu.elegirMontoACambiar(lectura);
                conversion.definirConversionyMonto(eleccionUsuario, cantidadACambiar);
                //conversion.realizarConversion(apiKeyValue);
                conversion.realizarConversion();
                System.out.println(conversion);
                estado=menu.continuarOCerrarPrograma(lectura);

            }

            //Le pregunto al usuario si desea continuar
            if (estado == 2) {
                break;
            } else {
                menu.mostrarOpciones();
            }
        }
        System.out.println("Muchas gracias por usar nuestro servicio :) ");
    }
}

