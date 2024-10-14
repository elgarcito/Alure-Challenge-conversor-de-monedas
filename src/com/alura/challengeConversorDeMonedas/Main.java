package com.alura.challengeConversorDeMonedas;

import com.alura.challengeConversorDeMonedas.modelos.ConversionMoneda;
import com.alura.challengeConversorDeMonedas.modelos.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Valores predeterminados
        int eleccionUsuario=0;
        double cantidadACambiar=0;
        ConversionMoneda conversion= new ConversionMoneda();
        String apiKeyValue = "c096090b482a281a51695afe";
        int estado=1;
        Menu menu =new Menu();

        //Inicio del scanner
        Scanner lectura = new Scanner(System.in);


        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("Por favor elija una opcion valida"+"\n");
        menu.mostrarOpciones();

        eleccionUsuario=menu.elegirOpciones(lectura);
        if (eleccionUsuario==7){
            estado=2;
        }else {
            cantidadACambiar=menu.elegirMontoACambiar(lectura);
        }
//        while (estado==1) {
//            try {
//                while (true) {
//                    System.out.println("\n"+"Ingrese un numero del 1 al 7");
//                    if (lectura.hasNextInt()){
//                        eleccionUsuario = Integer.valueOf(lectura.nextLine());
//                        if (eleccionUsuario > 0 && eleccionUsuario<=7) {
//                            if (eleccionUsuario==7){
//                                estado=2;
//                            }
//                            break;
//                        } else {
//                            System.out.println("Número fuera de rango. Inténtalo de nuevo.");
//                        }}else {
//                        System.out.println("Entrada no válida. Por favor, introduce un número.");
//                        lectura.next();
//                    }
//                }

//                while (estado==1) {
//                    System.out.println("Cantidad a cambiar");
//                    cantidadACambiar = Integer.valueOf(lectura.nextLine());
//                    if (cantidadACambiar > 0) {
//                        break;
//                    }
//                }

                if (estado==1){
                conversion.definirConversionyMonto(eleccionUsuario, cantidadACambiar);
                conversion.realizarConversion(apiKeyValue);
                System.out.println(conversion);

                System.out.println("\n");
                System.out.println("Desea realizar otra conversion? 1-Si, 2-No");
               // estado = Integer.valueOf(lectura.nextLine());
                }

                if (estado==2){
                    System.out.println("\n");
                    System.out.println("Muchas gracias por usar nuestro servicio :) ");
                }else {
                    menu.mostrarOpciones();
                }


            }
        }
  //  }
//}

